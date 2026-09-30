package hu.unideb.inf.beleptetorendszer.data.repository;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.data.entity.JogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogRepository
        extends JpaRepository<JogEntity, Long> {
}
