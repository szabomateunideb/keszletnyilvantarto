package hu.unideb.inf.keszletnyilvantarto.data.repository;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FelhasznaloRepository
        extends JpaRepository<FelhasznaloEntity, Long> {

    //Select * from felhasznalo
    //where nem = ?nem
    List<FelhasznaloEntity> findAllByNem(String nem);

    FelhasznaloEntity findByFelhasznalonev(String felhasznalonev);

    List<FelhasznaloEntity> findAllByJogosultsagok_Empty();

    //JPQL
    @Query("SELECT f FROM FelhasznaloEntity f where f.email = ?1 " +
            "and f.nem is not null")
    FelhasznaloEntity findByJpql(String email);

    //Native
    @Query(value = "select * from felhasznalo where nev = ?1"
        , nativeQuery = true)
    FelhasznaloEntity findByNative(String nev);
}
