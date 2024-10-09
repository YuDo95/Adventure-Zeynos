package dk.kea.adventurezeynos.Controller;

import org.springframework.ui.Model;
import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Service.AktiviteterService;
import dk.kea.adventurezeynos.Service.BookingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookinger")
public class BookingerController {

    @Autowired
    private BookingerService bookingService;

    @Autowired
    private AktiviteterService aktiviteterService;

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

    @PostMapping("/save")
    public String createBooking(@ModelAttribute Bookinger booking) {
        bookingService.save(booking);
        return "redirect:/bookinger"; // Redirect after saving the booking
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

    @PostMapping("/create")
    public String showBookingForm(Model model) {
        List<Aktiviteter> aktiviteter = aktiviteterService.findAll(); // Fetch activities
        model.addAttribute("aktiviteter", aktiviteter); // Add to model
        return "/bookinger"; // Assuming the view is named 'create.html'
    }


}
