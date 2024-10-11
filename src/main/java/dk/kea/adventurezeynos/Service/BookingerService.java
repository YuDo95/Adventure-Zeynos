package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Model.Kunder;
import dk.kea.adventurezeynos.Repository.BookingerRepository;
import dk.kea.adventurezeynos.Repository.KunderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingerService {

    @Autowired
    private BookingerRepository bookingerRepository;

    @Autowired
    private KunderRepository kunderRepository;

    // Henter alle bookinger fra databasen
    public List<Bookinger> findAll() {
        return bookingerRepository.findAll();
    }

    // Finder en specifik booking ved ID
    public Optional<Bookinger> findById(int id) {
        return bookingerRepository.findById(id);
    }

    // Gemmer eller opdaterer en booking
    public Bookinger save(Bookinger booking) {
        return bookingerRepository.save(booking);
    }

    // Finder en kunde baseret på e-mail
    public Optional<Kunder> findCustomerByEmail(String email) {
        return kunderRepository.findByEmail(email);
    }

    // Sletter en booking baseret på ID
    public void deleteById(int id) {
        bookingerRepository.deleteById(id);
    }
}
