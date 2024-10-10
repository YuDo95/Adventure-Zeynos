package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Instruktører;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dk.kea.adventurezeynos.Model.Instruktører; // Make sure this import is correct
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstruktørerRepository extends JpaRepository<Instruktører, Integer> {
    // No additional methods are needed for findAll()
}
