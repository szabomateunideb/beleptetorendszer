package hu.unideb.inf.beleptetorendszer.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "JOGOSULTSAG")
public class JogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false, unique = true)
    private String nev;
    @Column
    private String leiras;
}
