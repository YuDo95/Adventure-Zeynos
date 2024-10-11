package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Bookinger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingerRepository extends JpaRepository<Bookinger, Integer> {
    // Custom query methods (if needed) can be defined here
}
