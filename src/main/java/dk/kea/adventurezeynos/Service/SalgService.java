// File: dk/kea/adventurezeynos/Service/SalgService.java
package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Salg;
import dk.kea.adventurezeynos.Repository.SalgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalgService {

    @Autowired
    private SalgRepository salgRepository;

    public List<Salg> findAll() {
        return salgRepository.findAll();
    }

    public Optional<Salg> findById(int id) {
        return salgRepository.findById(id);
    }

    public Salg save(Salg salg) {
        return salgRepository.save(salg);
    }

    public void deleteById(int id) {
        salgRepository.deleteById(id);
    }
}
