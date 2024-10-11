package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Medarbejder;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MedarbejdereRepository extends JpaRepository<Medarbejder, Integer> {
    boolean existsByNavnAndKode(String navn, String kode);
}

