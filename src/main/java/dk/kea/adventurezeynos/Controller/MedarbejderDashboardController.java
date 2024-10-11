package dk.kea.adventurezeynos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedarbejderDashboardController {

    @GetMapping("/employee-dashboard")
    public String showDashboard(Model model) {

        return "medarbejderdashboard";
    }
}
