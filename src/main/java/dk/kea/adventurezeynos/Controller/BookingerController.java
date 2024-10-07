package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Service.BookingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingerController {

    @Autowired
    private BookingerService bookingService;

    // Get all bookings
    @GetMapping
    public List<Bookinger> getAllBookings() {
        return bookingService.findAll();
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public Bookinger getBookingById(@PathVariable int id) {
        return bookingService.findById(id).orElse(null);
    }

    // Save new booking
    @PostMapping("/save")
    public Bookinger createBooking(@RequestBody Bookinger booking) {
        return bookingService.save(booking);
    }

    // Update an existing booking
    @PutMapping("/edit/{id}")
    public Bookinger updateBooking(@PathVariable int id, @RequestBody Bookinger updatedBooking) {
        return bookingService.findById(id).map(booking -> {
            booking.setAktivitet(updatedBooking.getAktivitet());
            booking.setKunde(updatedBooking.getKunde());
            booking.setDato(updatedBooking.getDato());
            booking.setAntalDeltagere(updatedBooking.getAntalDeltagere());
            return bookingService.save(booking);
        }).orElse(null);
    }

    // Delete booking by ID
    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteById(id);
    }
}
