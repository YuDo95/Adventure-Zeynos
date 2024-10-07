package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Bookinger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookinger, Integer> {
}
