package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Service.InstruktørerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instruktører")
public class InstruktørerController {

    @Autowired
    private InstruktørerService instruktørerService;

    @GetMapping
    public String getAllInstruktører(Model model) {
        List<Instruktører> instruktører = instruktørerService.findAll();
        model.addAttribute("instruktører", instruktører);
        return "instruktører"; // Returns the view name to display all instructors
    }

    @GetMapping("/{id}")
    public String getInstruktørById(@PathVariable int id, Model model) {
        Instruktører instruktør = instruktørerService.findById(id);
        model.addAttribute("instruktør", instruktør);
        return "instruktør-detail"; // Returns the view name to display a specific instructor's details
    }

    @PostMapping
    public String createInstruktør(@ModelAttribute Instruktører instruktør) {
        instruktørerService.save(instruktør);
        return "redirect:/instruktører"; // Redirects to the list of instructors after creation
    }

    @PostMapping("/{id}/delete")
    public String deleteInstruktør(@PathVariable int id) {
        instruktørerService.deleteById(id);
        return "redirect:/instruktører"; // Redirects to the list of instructors after deletion
    }
}
