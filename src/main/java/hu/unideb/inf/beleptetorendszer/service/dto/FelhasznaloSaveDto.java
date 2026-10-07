package hu.unideb.inf.beleptetorendszer.service.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FelhasznaloSaveDto {

    private Long id;
    private String felhasznalonev;
    private String jelszo;
    private String email;
    private LocalDate szuletesiDatum;
    private String nem;
}
