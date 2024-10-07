package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Varer;
import dk.kea.adventurezeynos.Repository.VarerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VarerService {

    @Autowired
    private VarerRepository varerRepository;


    public List<Varer> findAll() {
        return varerRepository.findAll();
    }


    public Optional<Varer> findById(int id) {
        return varerRepository.findById(id);
    }


    public Varer save(Varer varer) {
        return varerRepository.save(varer);
    }


    public void deleteById(int id) {
        varerRepository.deleteById(id);
    }
}
