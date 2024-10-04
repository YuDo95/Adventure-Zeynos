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

    @GetMapping
    public String getAllAktiviteter(Model model) {
        List<Aktiviteter> aktiviteter = aktiviteterService.findAll();
        model.addAttribute("aktiviteter", aktiviteter);

        List<Instruktører> instruktører = instruktørerService.findAll();
        model.addAttribute("instruktører", instruktører);

        return "aktiviteter"; // Return view to show activities
    }

    @PostMapping
    public String createAktivitet(@RequestParam("navn") String navn,
                                  @RequestParam("instruktørId") int instruktørId) {
        Instruktører instruktør = instruktørerService.findById(instruktørId);

        Aktiviteter newAktivitet = new Aktiviteter();
        newAktivitet.setNavn(navn);
        newAktivitet.setInstruktør(instruktør);

        aktiviteterService.save(newAktivitet);

        return "redirect:/aktiviteter";
    }

    @GetMapping("/{id}")
    public String getAktivitetById(@PathVariable int id, Model model) {
        Aktiviteter aktivitet = aktiviteterService.findById(id);
        model.addAttribute("aktivitet", aktivitet);
        return "aktivitet-detail";
    }

    @PostMapping("/{id}/delete")
    public String deleteAktivitet(@PathVariable int id) {
        aktiviteterService.deleteById(id);
        return "redirect:/aktiviteter";
    }
}
