package hu.unideb.inf.keszletnyilvantarto.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;



@Entity
@Table(name = "FELHASZNALO")
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "felhnev", length = 50, nullable = false, unique = true)
    private String felhasznalonev;
    @Column(length = 30, nullable = false)
    private String jelszo;
    @Column(nullable = false)
    private String nev;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "szuldat", nullable = false)
    private LocalDate szuletesiDatum;
    @Column(length = 10)
    private String nem;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FELHASZNALO_JOG",
        joinColumns = @JoinColumn(name = "felh_id"),
            inverseJoinColumns = @JoinColumn(name = "jog_id"))
    private Set<JogEntity> jogosultsagok;

    public FelhasznaloEntity(Long id, String felhasznalonev, String jelszo, String nev, String email, LocalDate szuletesiDatum, String nem, Set<JogEntity> jogosultsagok) {
        this.id = id;
        this.felhasznalonev = felhasznalonev;
        this.jelszo = jelszo;
        this.nev = nev;
        this.email = email;
        this.szuletesiDatum = szuletesiDatum;
        this.nem = nem;
        this.jogosultsagok = jogosultsagok;
    }

    public FelhasznaloEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(LocalDate szuletesiDatum) {
        this.szuletesiDatum = szuletesiDatum;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public Set<JogEntity> getJogosultsagok() {
        return jogosultsagok;
    }

    public void setJogosultsagok(Set<JogEntity> jogosultsagok) {
        this.jogosultsagok = jogosultsagok;
    }
}
