package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Repository.InstruktørerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstruktørerService {

    @Autowired
    private InstruktørerRepository instruktørerRepository;

    public List<Instruktører> findAll() {
        return instruktørerRepository.findAll();
    }

    public Instruktører findById(int id) {
        Optional<Instruktører> instruktør = instruktørerRepository.findById(id);
        return instruktør.orElse(null);
    }

    public Instruktører save(Instruktører instruktør) {
        return instruktørerRepository.save(instruktør);
    }

    public void deleteById(int id) {
        instruktørerRepository.deleteById(id);
    }
}
