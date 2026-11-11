package hu.unideb.inf.beleptetorendszer.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "JOGOSULTSAG")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JogEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false, unique = true)
    private String nev;
    @Column
    private String leiras;

    @Override
    public @Nullable String getAuthority() {
        return nev;
    }
}
