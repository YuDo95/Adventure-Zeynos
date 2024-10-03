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
    public List<Aktiviteter> getAllAktiviteter() {
        return aktiviteterService.findAll();
    }

    @GetMapping("/{id}")
    public Aktiviteter getAktivitetById(@PathVariable int id) {
        return aktiviteterService.findById(id);
    }

    @PostMapping
    public Aktiviteter createAktivitet(@RequestBody Aktiviteter aktiviteter) {
        return aktiviteterService.save(aktiviteter);
    }

    @DeleteMapping("/{id}")
    public void deleteAktivitet(@PathVariable int id) {
        aktiviteterService.deleteById(id);
    }


    @GetMapping("/create")
    public String createAktivitetForm(Model model) {
        model.addAttribute("aktivitet", new Aktiviteter());
        model.addAttribute("instruktørerList", instruktørerService.findAll());
        return "create-aktivitet";
    }

    // Handling submission
    @PostMapping("/create")
    public String createAktivitetSubmit(@ModelAttribute Aktiviteter aktivitet) {
        aktiviteterService.save(aktivitet);
        return "redirect:/aktiviteter";
    }
}
