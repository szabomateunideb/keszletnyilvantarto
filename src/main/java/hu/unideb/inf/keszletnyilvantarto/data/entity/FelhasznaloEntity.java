package hu.unideb.inf.keszletnyilvantarto.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
