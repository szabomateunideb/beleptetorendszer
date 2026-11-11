package hu.unideb.inf.beleptetorendszer.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FelhasznaloLoginDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String felhasznalonev;
    @NotBlank
    @Size(min = 8, max = 20)
    private String jelszo;
}
