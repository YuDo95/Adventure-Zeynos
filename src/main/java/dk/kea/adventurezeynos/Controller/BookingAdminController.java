package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Bookinger;
import dk.kea.adventurezeynos.Service.BookingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookinger/admin")
public class BookingAdminController {

    @Autowired
    private BookingerService bookingerService;

    @GetMapping
    public String getAllBookings(Model model) {
        List<Bookinger> bookingerList = bookingerService.findAll();
        model.addAttribute("bookingerList", bookingerList);
        return "bookingeradmin"; // Name of the HTML template for admin view
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable("id") int id) {
        bookingerService.deleteById(id);
        return "redirect:/bookinger/admin"; // Redirect to the admin view after deletion
    }
}
