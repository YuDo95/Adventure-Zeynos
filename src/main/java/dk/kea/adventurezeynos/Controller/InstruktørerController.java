package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Instruktører;
import dk.kea.adventurezeynos.Service.InstruktørerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Use RestController for REST APIs
@RequestMapping("/api/instruktører")
public class InstruktørerController {

    @Autowired
    private InstruktørerService instruktørerService;

    // Get all instructors as JSON
    @GetMapping
    public List<Instruktører> getAllInstruktører() {
        return instruktørerService.findAll();
    }

    // Get a single instructor by ID as JSON
    @GetMapping("/{id}")
    public Instruktører getInstruktørById(@PathVariable int id) {
        return instruktørerService.findById(id);
    }

    // Create a new instructor
    @PostMapping("/create")
    public Instruktører createInstruktør(@RequestBody Instruktører instruktører) {
        return instruktørerService.save(instruktører);
    }

    // Delete an instructor by ID
    @PostMapping("/delete/{id}")
    public void deleteInstruktør(@PathVariable int id) {
        instruktørerService.deleteById(id);
    }
}
