package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.AktiviteterAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AktiviteterAdminRepository extends JpaRepository<AktiviteterAdmin, Integer> {
}
