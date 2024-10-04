package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Varer;
import dk.kea.adventurezeynos.Service.VarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/varer")
public class VarerController {

    @Autowired
    private VarerService varerService;

    @GetMapping
    @ResponseBody
    public List<Varer> getAllVarer() {
        return varerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Varer getVarerById(@PathVariable int id) {
        return varerService.findById(id).orElse(null);
    }

    @PostMapping("/save")
    @ResponseBody
    public Varer createVarer(@RequestBody Varer varer) {
        return varerService.save(varer);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public Varer updateVarer(@PathVariable int id, @RequestBody Varer updatedVarer) {
        return varerService.findById(id).map(varer -> {
            varer.setNavn(updatedVarer.getNavn());
            varer.setPris(updatedVarer.getPris());
            return varerService.save(varer);
        }).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVarer(@PathVariable int id) {
        varerService.deleteById(id);
    }
}
