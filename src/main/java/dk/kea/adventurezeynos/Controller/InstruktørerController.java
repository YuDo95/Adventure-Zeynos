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

    private final InstruktørerService instruktørerService;

    @Autowired
    public InstruktørerController(InstruktørerService instruktørerService) {
        this.instruktørerService = instruktørerService;
    }

    // REST API to get all instructors
    @GetMapping
    public List<Instruktører> getAllInstruktører() {
        return instruktørerService.findAll();
    }

    // REST API to get an instructor by ID
    @GetMapping("/{id}")
    public Instruktører getInstruktørById(@PathVariable int id) {
        return instruktørerService.findById(id);
    }

    // REST API to create a new instructor
    @PostMapping
    public Instruktører createInstruktør(@RequestBody Instruktører instruktører) {
        return instruktørerService.save(instruktører);
    }

    // REST API to delete an instructor by ID
    @DeleteMapping("/{id}")
    public void deleteInstruktør(@PathVariable int id) {
        instruktørerService.deleteById(id);
    }

    // Thymeleaf method to render the form for adding a new instructor
    @GetMapping("/create")
    public String createInstruktørForm(Model model) {
        model.addAttribute("instruktør", new Instruktører());
        return "create-instruktør"; // This is the Thymeleaf template that will render the form
    }

    // Handling form submission for creating a new instructor
    @PostMapping("/create")
    public String createInstruktørSubmit(@ModelAttribute Instruktører instruktør) {
        instruktørerService.save(instruktør);
        return "redirect:/instruktører"; // Redirect to the list of instructors after successful creation
    }
}
