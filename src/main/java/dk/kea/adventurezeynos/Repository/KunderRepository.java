package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Kunder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KunderRepository extends JpaRepository<Kunder, Integer> {
    Optional<Kunder> findByEmail(String email);

    boolean existsByEmail(String email);
}
