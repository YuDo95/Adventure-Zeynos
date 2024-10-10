package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Medarbejder;
import dk.kea.adventurezeynos.Repository.MedarbejdereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedarbejdereService {

    @Autowired
    private static MedarbejdereRepository medarbejdereRepository;

    public List<Medarbejder> findAll() {
        return medarbejdereRepository.findAll();
    }
    public static boolean validateUser(String navn, String kode) {
        return medarbejdereRepository.validateUser(navn, kode);
    }

    public Medarbejder findById(int id) {
        return medarbejdereRepository.findById(id).orElse(null);
    }

    public void save(Medarbejder medarbejder) {
        medarbejdereRepository.save(medarbejder);
    }

    public void deleteById(int id) {
        medarbejdereRepository.deleteById(id);
    }
}