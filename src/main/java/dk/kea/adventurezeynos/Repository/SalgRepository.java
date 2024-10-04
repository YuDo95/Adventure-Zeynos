package dk.kea.adventurezeynos.Repository;

import dk.kea.adventurezeynos.Model.Salg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalgRepository extends JpaRepository<Salg, Integer> {
}

