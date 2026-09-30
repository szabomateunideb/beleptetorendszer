package hu.unideb.inf.beleptetorendszer.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JOGOSULTSAG")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false, unique = true)
    private String nev;
    @Column
    private String leiras;
}
