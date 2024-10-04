package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Service.InstruktørerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instruktører")
public class InstruktørerController {

    @Autowired
    private InstruktørerService instruktørerService;

    @GetMapping
    public String getAllInstruktører(Model model) {
        model.addAttribute("instruktører", instruktørerService.findAll());
        return "instruktører";
    }

    @GetMapping("/{id}")
    public String getInstruktørById(@PathVariable int id, Model model) {
        model.addAttribute("instruktør", instruktørerService.findById(id));
        return "instruktør-detail";
    }

    @PostMapping
    public String createInstruktør(@ModelAttribute Instruktører instruktører) {
        instruktørerService.save(instruktører);
        return "redirect:/instruktører";
    }

    @PostMapping("/{id}/delete")
    public String deleteInstruktør(@PathVariable int id) {
        instruktørerService.deleteById(id);
        return "redirect:/instruktører";
    }
}
