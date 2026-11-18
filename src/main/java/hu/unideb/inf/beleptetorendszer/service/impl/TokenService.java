package hu.unideb.inf.beleptetorendszer.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
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
        byte[] keyBytes = Decoders.BASE64.decode("gjfbvgggfffbffgfdccghcvghhcvtf55gf4f");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private <T> T extractClaim(String token
            , Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
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

    private String generateToken(UserDetails user){
        Map<String, Object> claims = new HashMap<>();
        user.getAuthorities().forEach(a ->
                claims.put(a.getAuthority(), a));

        return Jwts.builder()
                .claims(claims)
                .subject(user.getUsername())
                .issuedAt(Calendar.getInstance().getTime())
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
