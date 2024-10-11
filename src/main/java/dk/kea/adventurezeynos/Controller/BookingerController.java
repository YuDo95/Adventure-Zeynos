package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Model.Kunder;
import dk.kea.adventurezeynos.Service.AktiviteterService;
import dk.kea.adventurezeynos.Service.BookingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bookinger")
public class BookingerController {

    @Autowired
    private BookingerService bookingService;

    @Autowired
    private AktiviteterService aktiviteterService;

    @GetMapping("/valg")
    public String showBookingForm(Model model) {
        List<Aktiviteter> aktiviteter = aktiviteterService.getAllAktiviteter();
        model.addAttribute("aktiviteter", aktiviteter);
        return "bookinger";
    }

    @PostMapping("/save")
    public String createBooking(@RequestParam("email") String email, @ModelAttribute Bookinger booking, Model model) {
        Optional<Kunder> kunde = bookingService.findCustomerByEmail(email);

        if (kunde.isPresent()) {
            booking.setKunde(kunde.get());
            bookingService.save(booking);
            return "redirect:/bookinger";
        } else {
            model.addAttribute("errorMessage", "Kunde med e-mailen findes ikke.");
            return "bookinger";
        }
    }

    @GetMapping
    public String getAllBookings(Model model) {
        List<Bookinger> bookings = bookingService.findAll();
        model.addAttribute("bookings", bookings);
        return "bookinger";
    }
}
