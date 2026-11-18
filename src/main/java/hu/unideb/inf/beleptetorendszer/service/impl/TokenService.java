package hu.unideb.inf.beleptetorendszer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.jackson.io.JacksonDeserializer;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class TokenService {

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode("gjfsdfjhsjkfhsekfhsejkfhsejkfhseuifhseukhfsukehfkseubvgggfffbffgfdccghcvghhcvtf55gf4f");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private <T> T extractClaim(String token
            , Function<Claims, T> claimsResolver) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        final Claims claims = Jwts.parser()
                .json(new JacksonDeserializer<>(mapper))
                .verifyWith(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getPayload();
        return claimsResolver.apply(claims);
    }

    private Boolean isTokenExpired(String token) {
        Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails user){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        Map<String, Object> claims = new HashMap<>();
        user.getAuthorities().forEach(a ->
                claims.put(a.getAuthority(), a));

        return Jwts.builder()
                .json(new JacksonSerializer<>(mapper))
                .claims(claims)
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+150000))
                .signWith(getSecretKey())
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Boolean validateToken(String token, UserDetails user) {
        final String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
}
