package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Medarbejder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedarbejdereRepository extends JpaRepository<Medarbejder, Integer> {

    // JPA query to check if an instructor exists with the given navn and kode
    @Query("SELECT COUNT(i) > 0 FROM Instruktører i WHERE i.navn = :navn AND i.kode = :kode")
    boolean validateUser(@Param("navn") String navn, @Param("kode") String kode);
}
