package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Service.MedarbejdereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/")
public class MedarbejdereController {

    private static final Logger logger = LoggerFactory.getLogger(MedarbejdereController.class);

    @Autowired
    private MedarbejdereService medarbejdereService;

    @GetMapping("/medarbejderlogin")
    public String loginPage() {
        return "login"; // Show login page
    }

    @PostMapping("/login")
    public String login(@RequestParam String navn,
                        @RequestParam String kode,
                        Model model) {
        try {
            if (medarbejdereService.validateUser(navn, kode)) {
                return "redirect:/dashboard"; // Redirect to dashboard if login is valid
            } else {
                model.addAttribute("error", "Forkert navn eller kode.");
                return "login";
            }
        } catch (Exception e) {
            logger.error("An error occurred during login", e);
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "medarbejderdashboard"; // Show the dashboard after login
    }
}
