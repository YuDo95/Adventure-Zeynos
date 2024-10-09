package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Kunder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KunderRepository extends JpaRepository<Kunder, Integer> {
    boolean existsByEmail(String email);
}
