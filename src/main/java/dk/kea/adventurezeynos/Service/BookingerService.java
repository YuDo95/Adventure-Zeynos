package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingerService {

    @Autowired
    private BookingRepository bookingRepository;


    public List<Bookinger> findAll() {
        return bookingRepository.findAll();
    }

    public Optional<Bookinger> findById(int id) {
        return bookingRepository.findById(id);
    }


    public Bookinger save(Bookinger booking) {
        return bookingRepository.save(booking);
    }


    public void deleteById(int id) {
        bookingRepository.deleteById(id);
    }
}
