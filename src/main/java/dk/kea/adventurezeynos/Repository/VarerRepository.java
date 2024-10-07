package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Varer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarerRepository extends JpaRepository<Varer, Integer> {
}
