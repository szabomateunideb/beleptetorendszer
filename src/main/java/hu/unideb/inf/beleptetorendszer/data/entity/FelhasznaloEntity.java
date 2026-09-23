package hu.unideb.inf.beleptetorendszer.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FELHASZNALO")
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "felhnev", length = 90, nullable = false, unique = true)
    private String felhasznalonev;
    @Column(length = 100, nullable = false)
    private String jelszo;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "szulDatum", nullable = false)
    private LocalDate szuletesiDatum;
    @Column(length = 10, nullable = true)
    private String nem;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FELHASZNALO_JOG",
                joinColumns = @JoinColumn(name = "felh_id"),
                inverseJoinColumns = @JoinColumn(name = "jog_id"))
    private Set<JogEntity> jogosultsagok;
}
