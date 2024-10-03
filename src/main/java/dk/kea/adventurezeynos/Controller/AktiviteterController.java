package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Service.AktiviteterService;
import dk.kea.adventurezeynos.Service.InstruktørerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aktiviteter")
public class AktiviteterController {

    private final AktiviteterService aktiviteterService;
    private final InstruktørerService instruktørerService;

    @Autowired
    public AktiviteterController(AktiviteterService aktiviteterService, InstruktørerService instruktørerService) {
        this.aktiviteterService = aktiviteterService;
        this.instruktørerService = instruktørerService;
    }

    // Method to display all activities
    @GetMapping
    public String getAllAktiviteter(Model model) {
        List<Aktiviteter> aktiviteter = aktiviteterService.findAll();
        model.addAttribute("aktiviteter", aktiviteter);
        return "aktiviteter"; // Thymeleaf template to render the activities
    }

    // Method to view a specific activity by ID
    @GetMapping("/{id}")
    public String getAktivitetById(@PathVariable int id, Model model) {
        Aktiviteter aktivitet = aktiviteterService.findById(id);
        model.addAttribute("aktivitet", aktivitet);
        return "view-aktivitet"; // Thymeleaf template to view a single activity
    }

    // Display form for creating a new activity
    @GetMapping("/create")
    public String createAktivitetForm(Model model) {
        model.addAttribute("aktivitet", new Aktiviteter());
        model.addAttribute("instruktører", instruktørerService.findAll()); // Pass the list of instructors to the form
        return "create-aktivitet"; // Thymeleaf template for creating a new activity
    }

    // Handle form submission for creating a new activity
    @PostMapping("/create")
    public String createAktivitetSubmit(@RequestParam("navn") String navn, @RequestParam("instruktørId") int instruktørId) {
        // Fetch the selected instructor
        Instruktører instruktør = instruktørerService.findById(instruktørId);

        // Create a new activity and set its fields
        Aktiviteter newAktivitet = new Aktiviteter();
        newAktivitet.setNavn(navn);
        newAktivitet.setInstruktør(instruktør);

        // Save the new activity
        aktiviteterService.save(newAktivitet);

        return "redirect:/aktiviteter"; // Redirect back to the activities list after creation
    }

    // Method to delete an activity by ID
    @PostMapping("/{id}/delete")
    public String deleteAktivitet(@PathVariable int id) {
        aktiviteterService.deleteById(id);
        return "redirect:/aktiviteter"; // Redirect back to the activities list after deletion
    }
}
