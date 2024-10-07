package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Repository.InstruktørerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstruktørerService {

    @Autowired
    private InstruktørerRepository instruktørerRepository;

    public List<Instruktører> findAll() {
        return instruktørerRepository.findAll();
    }

    public Instruktører findById(int id) {
        return instruktørerRepository.findById(id).orElse(null);
    }

    public void save(Instruktører instruktør) {
        instruktørerRepository.save(instruktør);
    }

    public void deleteById(int id) {
        instruktørerRepository.deleteById(id);
    }
}

