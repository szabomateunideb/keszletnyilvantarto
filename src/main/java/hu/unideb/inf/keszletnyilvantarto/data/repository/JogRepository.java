package hu.unideb.inf.keszletnyilvantarto.data.repository;

import hu.unideb.inf.keszletnyilvantarto.data.entity.JogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogRepository
        extends JpaRepository<JogEntity,Long> {
}
