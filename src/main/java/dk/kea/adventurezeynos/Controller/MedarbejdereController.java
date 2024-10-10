package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Service.InstruktørerService;
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
@RequestMapping("/test")
public class MedarbejdereController {

    private static final Logger logger = LoggerFactory.getLogger(MedarbejdereController.class);

    @Autowired
    private MedarbejdereService medarbejdereService;

    @GetMapping("/medarbejderlogin")
    public String loginPage() {
        return "login"; // Returns the login page template
    }

    @PostMapping("/login")
    public String login(@RequestParam String navn,
                        @RequestParam String kode,
                        Model model) {
        try {
            // Call user service to validate credentials
            if (medarbejdereService.validateUser(navn, kode)) {
                return "redirect:/dashboard"; // Redirect to the dashboard upon successful login
            } else {
                // Add error message for invalid credentials
                model.addAttribute("error", "Forkert navn eller kode.");
                return "login"; // Stay on the login page
            }
        } catch (Exception e) {
            // Add error message for unexpected errors
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "login"; // Stay on the login page in case of an error
        }
    }

}
