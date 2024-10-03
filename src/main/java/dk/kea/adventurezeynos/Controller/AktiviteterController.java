package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Model.Instruktører; // Make sure you have this import
import dk.kea.adventurezeynos.Service.AktiviteterService;
import dk.kea.adventurezeynos.Service.InstruktørerService; // Import the service for instructors
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AktiviteterController {

    @Autowired
    private AktiviteterService aktiviteterService;

    @Autowired
    private InstruktørerService instruktørerService; // Inject the instructors service

    @GetMapping("/aktiviteter")
    public String getAllAktiviteter(Model model) {
        model.addAttribute("aktiviteter", aktiviteterService.findAll());
        List<Instruktører> instruktører = instruktørerService.findAll(); // Fetch all instructors
        model.addAttribute("instruktører", instruktører); // Add instructors to the model
        return "aktiviteter"; // Make sure this view exists
    }

    @GetMapping("/aktiviteter/{id}")
    public String getAktivitetById(@PathVariable int id, Model model) {
        model.addAttribute("aktivitet", aktiviteterService.findById(id));
        return "aktivitet-detail"; // Use a separate view for aktivitet details if needed
    }

    @PostMapping("/aktiviteter")
    public String createAktivitet(@ModelAttribute Aktiviteter aktivitet, @RequestParam int instruktørId) {
        aktivitet.setId(instruktørId); // Set the instructor ID from the form
        aktiviteterService.save(aktivitet);
        return "redirect:/aktiviteter";
    }


    @PostMapping("/aktiviteter/{id}")
    public String deleteAktivitet(@PathVariable int id) {
        aktiviteterService.deleteById(id);
        return "redirect:/aktiviteter";
    }
}
