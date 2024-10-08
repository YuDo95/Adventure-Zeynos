package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AktiviteterRepository extends JpaRepository<Aktiviteter, Integer> {
}
