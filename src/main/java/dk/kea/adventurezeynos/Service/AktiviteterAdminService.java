package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.AktiviteterAdmin;
import dk.kea.adventurezeynos.Repository.AktiviteterAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AktiviteterAdminService {

    @Autowired
    private AktiviteterAdminRepository aktiviteterAdminRepository;

    public List<AktiviteterAdmin> findAll() {
        return aktiviteterAdminRepository.findAll();
    }

    public AktiviteterAdmin findById(int id) {
        return aktiviteterAdminRepository.findById(id).orElse(null);
    }

    public void save(AktiviteterAdmin aktivitet) {
        aktiviteterAdminRepository.save(aktivitet);
    }

    public void deleteById(int id) {
        aktiviteterAdminRepository.deleteById(id);
    }
}
