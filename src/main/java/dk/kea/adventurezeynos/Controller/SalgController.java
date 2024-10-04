package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Salg;
import dk.kea.adventurezeynos.Service.SalgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salg")
public class SalgController {

    @Autowired
    private SalgService salgService;

    @GetMapping
    public List<Salg> getAllSalg() {
        return salgService.findAll();
    }

    @GetMapping("/{id}")
    public Salg getSalgById(@PathVariable int id) {
        return salgService.findById(id).orElse(null);
    }

    @PostMapping("/save")
    public Salg createSalg(@RequestBody Salg salg) {
        return salgService.save(salg);
    }

    @PutMapping("/edit/{id}")
    public Salg updateSalg(@PathVariable int id, @RequestBody Salg updatedSalg) {
        return salgService.findById(id).map(salg -> {
            salg.setVare(updatedSalg.getVare());
            salg.setKunde(updatedSalg.getKunde());
            salg.setAntal(updatedSalg.getAntal());
            return salgService.save(salg);
        }).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalg(@PathVariable int id) {
        salgService.deleteById(id);
    }
}
