package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Kunder;
import dk.kea.adventurezeynos.Repository.KunderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KunderService {

    @Autowired
    private KunderRepository kundeRepository;

    public List<Kunder> findAll() {
        return kundeRepository.findAll();
    }

    public Optional<Kunder> findById(int id) {
        return kundeRepository.findById(id);
    }

    public Kunder save(Kunder kunde) {
        return kundeRepository.save(kunde);
    }

    public void deleteById(int id) {
        kundeRepository.deleteById(id);
    }
}
