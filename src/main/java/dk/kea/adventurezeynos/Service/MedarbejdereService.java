package dk.kea.adventurezeynos.Service;
import dk.kea.adventurezeynos.Model.Medarbejder;
import dk.kea.adventurezeynos.Repository.MedarbejdereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MedarbejdereService {

    private final MedarbejdereRepository medarbejdereRepository;

    @Autowired
    public MedarbejdereService(MedarbejdereRepository medarbejdereRepository) {
        this.medarbejdereRepository = medarbejdereRepository;
    }

    public List<Medarbejder> findAll() {
        return medarbejdereRepository.findAll();
    }

    public boolean validateUser(String navn, String kode) {
        boolean exists = medarbejdereRepository.existsByNavnAndKode(navn, kode);
        System.out.println("Login Attempt: " + navn + ", " + kode + " -> " + exists);
        return exists;
    }

    public Optional<Medarbejder> findById(int id) {
        return medarbejdereRepository.findById(id);
    }

    public void save(Medarbejder medarbejder) {
        medarbejdereRepository.save(medarbejder);
    }

    public void deleteById(int id) {
        medarbejdereRepository.deleteById(id);
    }
}
