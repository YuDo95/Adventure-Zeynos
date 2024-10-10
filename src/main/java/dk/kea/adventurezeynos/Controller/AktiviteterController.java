package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Service.AktiviteterService;
import dk.kea.adventurezeynos.Service.InstruktørerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AktiviteterController {

    @Autowired
    private AktiviteterService aktiviteterService;

    @GetMapping("/aktiviteter")
    public String getAktiviteter(Model model) {
        model.addAttribute("aktiviteter", aktiviteterService.getAllAktiviteter());
        return "aktiviteter"; // Return the name of the HTML template
    }
}