package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Service.BookingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookinger")
public class BookingerController {

    @Autowired
    private BookingerService bookingService;

    // Show all bookings (optional)
    @GetMapping
    public String getAllBookings(Model model) {
        List<Bookinger> bookings = bookingService.findAll();
        model.addAttribute("bookings", bookings);
        return "bookinger"; // Return the view name for displaying bookings
    }

    // Show the booking form (if you have a separate form view)
    @GetMapping("/new")
    public String showBookingForm(Model model) {
        // You can add any necessary data for the form here
        return "newBooking"; // Return the view name for the booking form
    }

    // Save a new booking
    @PostMapping("/save")
    public String createBooking(@ModelAttribute Bookinger booking) {
        bookingService.save(booking);
        return "redirect:/bookinger"; // Redirect to the list of bookings after saving
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public Bookinger getBookingById(@PathVariable int id) {
        return bookingService.findById(id).orElse(null);
    }

    // Delete booking by ID
    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteById(id);
    }
}
