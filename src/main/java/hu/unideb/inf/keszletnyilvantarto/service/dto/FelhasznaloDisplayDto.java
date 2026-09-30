package hu.unideb.inf.keszletnyilvantarto.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FelhasznaloDisplayDto {

    private String nev;
    private LocalDate szulDatum;
    private String nem;
}
