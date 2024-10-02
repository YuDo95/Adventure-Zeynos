package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Service.AktiviteterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aktiviteter")
public class AktiviteterController {

    private final AktiviteterService aktiviteterService;

    @Autowired
    public AktiviteterController(AktiviteterService aktiviteterService) {
        this.aktiviteterService = aktiviteterService;
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
}