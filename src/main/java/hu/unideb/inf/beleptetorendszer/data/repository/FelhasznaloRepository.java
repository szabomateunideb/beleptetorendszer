package hu.unideb.inf.beleptetorendszer.data.repository;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FelhasznaloRepository
        extends JpaRepository<FelhasznaloEntity, Long> {

    //Select * from felhasznalo
    //where felhasznalonev = ?felhasznalovel
    FelhasznaloEntity findByFelhasznalonev(String felhasznalonev);

    //Select * from felhasznalo
    //where nem not is null
    Set<FelhasznaloEntity> findAllByNemEmpty();
    //jogosultsagok.empty()
    Set<FelhasznaloEntity> findAllByJogosultsagok_Empty();

    //JPQL
    @Query("SELECT f from FelhasznaloEntity f WHERE f.nem=?1 " +
            "and f.jogosultsagok.size>0")
    List<FelhasznaloEntity> findByJpql(String nem);

    //native query
    @Query(value = "SELECT * FROM FELHASZNALO where nev = ?1",
    nativeQuery = true)
    FelhasznaloEntity findByNative(String nev);

}
