package dk.kea.adventurezeynos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedarbejderDashboardController {

    @GetMapping("/employee-dashboard")
    public String showDashboard(Model model) {
        // Add any model attributes if needed
        return "medarbejderdashboard"; // This refers to the HTML file (medarbejderDashboard.html)
    }
}
