package dk.kea.adventurezeynos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedarbejderDashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Add any model attributes if needed
        return "medarbejderDashboard"; // This refers to the HTML file (medarbejderDashboard.html)
    }
}
