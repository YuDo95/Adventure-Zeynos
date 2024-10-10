package dk.kea.adventurezeynos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String getContactPage() {
        // This will return the contact.html template
        return "contact";
    }
}
