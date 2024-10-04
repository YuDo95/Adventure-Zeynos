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

    // Display all activities and form for new activity
    @GetMapping
    public String getAllAktiviteter(Model model) {
        List<Aktiviteter> aktiviteter = aktiviteterService.findAll();
        model.addAttribute("aktiviteter", aktiviteter);

        List<Instruktører> instruktører = instruktørerService.findAll(); // Fetch all instructors
        model.addAttribute("instruktører", instruktører); // Add instructors to the model
        return "aktiviteter"; // View template for displaying activities and form
    }

    // Handle form submission for creating a new activity
    @PostMapping
    public String createAktivitet(@RequestParam("navn") String navn,
                                  @RequestParam("instruktørId") int instruktørId) {
        Instruktører instruktør = instruktørerService.findById(instruktørId);

        Aktiviteter newAktivitet = new Aktiviteter();
        newAktivitet.setNavn(navn);
        newAktivitet.setInstruktør(instruktør); // Set the instructor

        aktiviteterService.save(newAktivitet);

        return "redirect:/aktiviteter";
    }

    // View a single activity by ID
    @GetMapping("/{id}")
    public String getAktivitetById(@PathVariable int id, Model model) {
        Aktiviteter aktivitet = aktiviteterService.findById(id);
        model.addAttribute("aktivitet", aktivitet);
        return "aktivitet-detail"; // View template for displaying a single activity
    }

    // Handle deleting an activity by ID
    @PostMapping("/{id}/delete")
    public String deleteAktivitet(@PathVariable int id) {
        aktiviteterService.deleteById(id);
        return "redirect:/aktiviteter";
    }
}