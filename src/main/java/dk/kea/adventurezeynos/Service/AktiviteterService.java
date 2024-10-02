package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Repository.AktiviteterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AktiviteterService {

    private final AktiviteterRepository aktiviteterRepository;

    @Autowired
    public AktiviteterService(AktiviteterRepository aktiviteterRepository) {
        this.aktiviteterRepository = aktiviteterRepository;
    }

    public List<Aktiviteter> findAll() {
        return aktiviteterRepository.findAll();
    }

    public Aktiviteter findById(int id) {
        return aktiviteterRepository.findById(id);
    }

    public Aktiviteter save(Aktiviteter aktiviteter) {
        return aktiviteterRepository.save(aktiviteter);
    }

    public void deleteById(int id) {
        aktiviteterRepository.deleteById(id);
    }
}
