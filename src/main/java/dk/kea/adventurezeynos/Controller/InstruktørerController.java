package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Service.InstruktørerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InstruktørerController {

    @Autowired
    private InstruktørerService instruktørerService;

    @GetMapping("/instruktører")
    public String getAllInstruktører(Model model) {
        model.addAttribute("instruktører", instruktørerService.findAll());
        return "instruktører";
    }

    @GetMapping("/instruktører/{id}")
    public String getInstruktørById(@PathVariable int id, Model model) {
        model.addAttribute("instruktør", instruktørerService.findById(id));
        return "instruktør-detail"; // Use a separate view for instruktør details if needed
    }

    @PostMapping("/instruktører")
    public String createInstruktør(@ModelAttribute Instruktører instruktører) {
        instruktørerService.save(instruktører);
        return "redirect:/instruktører";
    }

    @PostMapping("/instruktører/{id}")
    public String deleteInstruktør(@PathVariable int id) {
        instruktørerService.deleteById(id);
        return "redirect:/instruktører";
    }

}

