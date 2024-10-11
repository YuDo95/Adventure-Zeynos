package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.AktiviteterAdmin;
import dk.kea.adventurezeynos.Service.AktiviteterAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aktiviteteradmin")
public class AktiviteterAdminController {

    @Autowired
    private AktiviteterAdminService aktiviteterAdminService;

    @GetMapping
    public String getAllAktiviteter(Model model) {
        List<AktiviteterAdmin> aktiviteter = aktiviteterAdminService.findAll();
        model.addAttribute("aktiviteter", aktiviteter);
        return "aktiviteteradmin";
    }

    @GetMapping("/{id}")
    public String getAktivitetById(@PathVariable int id, Model model) {
        AktiviteterAdmin aktivitet = aktiviteterAdminService.findById(id);
        model.addAttribute("aktivitet", aktivitet);
        return "aktiviteteradmin";
    }

    @PostMapping("/create")
    public String createAktivitet(@ModelAttribute AktiviteterAdmin aktivitet) {
        aktiviteterAdminService.save(aktivitet);
        return "redirect:/aktiviteteradmin";
    }

    @PostMapping("/delete/{id}")
    public String deleteAktivitet(@PathVariable int id) {
        aktiviteterAdminService.deleteById(id);
        return "redirect:/aktiviteteradmin";
    }
}