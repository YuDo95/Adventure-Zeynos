package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Repository.BookingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingerService {

    @Autowired
    private BookingerRepository bookingRepository;

    // Save a booking
    public void save(Bookinger booking) {
        bookingRepository.save(booking);
    }

    // Find all bookings
    public List<Bookinger> findAll() {
        return bookingRepository.findAll();
    }

    // Find booking by ID
    public Optional<Bookinger> findById(int id) {
        return bookingRepository.findById(id);
    }

    // Delete booking by ID
    public void deleteById(int id) {
        bookingRepository.deleteById(id);
    }
}
