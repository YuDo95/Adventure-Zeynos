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


    public List<Bookinger> findAll() {
        return bookingerRepository.findAll();
    }


    public Optional<Bookinger> findById(int id) {
        return bookingerRepository.findById(id);
    }

    public Bookinger save(Bookinger booking) {
        return bookingerRepository.save(booking);
    }

    public Optional<Kunder> findCustomerByEmail(String email) {
        return kunderRepository.findByEmail(email);
    }

    public void deleteById(int id) {
        bookingerRepository.deleteById(id);
    }
}
