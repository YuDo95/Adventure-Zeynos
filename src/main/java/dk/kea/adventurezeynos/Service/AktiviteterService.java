package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Repository.AktiviteterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AktiviteterService {

    @Autowired
    private AktiviteterRepository aktiviteterRepository;


    public List<Aktiviteter> findAll() {
        return aktiviteterRepository.findAll();
    }

    public Aktiviteter findById(int id) {
        Optional<Aktiviteter> aktivitet = aktiviteterRepository.findById(id);
        return aktivitet.orElse(null); // Return null if not found
    }

    public Aktiviteter save(Aktiviteter aktivitet) {
        return aktiviteterRepository.save(aktivitet);
    }

    public void deleteById(int id) {
        aktiviteterRepository.deleteById(id);
    }
}
