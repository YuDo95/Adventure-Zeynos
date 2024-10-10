package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Repository.InstruktørerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching // If you want to enable caching for your service
public class InstruktørerService {

    @Autowired
    private InstruktørerRepository instruktørerRepository;

    public Instruktører findById(int id) {
        return instruktørerRepository.findById(id).orElse(null);
    }

    public void save(Instruktører instruktør) {
        instruktørerRepository.save(instruktør);
    }

    public void deleteById(int id) {
        instruktørerRepository.deleteById(id);
    }

    public List<Instruktører> findAll() {
        return instruktørerRepository.findAll(); // Fetch all instructors from the repository
    }
}

