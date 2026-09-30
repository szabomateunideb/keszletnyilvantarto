package hu.unideb.inf.keszletnyilvantarto.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FelhasznaloDisplayDto {

    private String nev;
    private LocalDate szulDatum;
    private String nem;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public LocalDate getSzulDatum() {
        return szulDatum;
    }

    public void setSzulDatum(LocalDate szulDatum) {
        this.szulDatum = szulDatum;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }
}
