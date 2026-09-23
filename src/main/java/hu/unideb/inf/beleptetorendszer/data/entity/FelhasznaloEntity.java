package hu.unideb.inf.beleptetorendszer.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "FELHASZNALO")
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
}
