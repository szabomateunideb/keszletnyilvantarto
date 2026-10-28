package hu.unideb.inf.keszletnyilvantarto.service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FelhasznaloSaveDto {
    private Long id;
    @NotBlank
    @Size(min = 4, max = 20)
    private String felhasznalonev;
    @NotBlank
    @Size(min = 8, max = 40)
    private String jelszo;
    @NotBlank
    @Size(min = 3, max = 100)
    private String nev;
    @NotBlank
    @Size(min = 3, max = 100)
    @Email
    private String email;
    @NotNull
    @Past
    private LocalDate szuletesiDatum;
    @Size(min = 0, max = 10)
    private String nem;
}
