package hu.unideb.inf.beleptetorendszer.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FelhasznaloDisplayDto {
    private String felhasznalonev;
    private LocalDate szuletesiDatum;
    private String nem;
}
