package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Repository.AktiviteterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AktiviteterService {

    @Autowired
    private AktiviteterRepository aktiviteterRepository;

    public List<Aktiviteter> findAll() {
        return aktiviteterRepository.findAll();
    }

    public Aktiviteter findById(int id) {
        return aktiviteterRepository.findById(id);
    }

    public void save(Aktiviteter aktivitet) {
        aktiviteterRepository.save(aktivitet);
    }

    public void deleteById(int id) {
        aktiviteterRepository.deleteById(id);
    }
}
