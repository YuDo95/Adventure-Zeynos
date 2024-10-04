package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Kunder;
import dk.kea.adventurezeynos.Service.KunderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunde")
public class KunderController {

    @Autowired
    private KunderService kundeService;

    @GetMapping
    public List<Kunder> getAllKunde() {
        return kundeService.findAll();
    }

    @GetMapping("/{id}")
    public Kunder getKundeById(@PathVariable int id) {
        return kundeService.findById(id).orElse(null);
    }

    @PostMapping("/save")
    public Kunder createKunde(@RequestBody Kunder kunde) {
        return kundeService.save(kunde);
    }

    @PutMapping("/edit/{id}")
    public Kunder updateKunde(@PathVariable int id, @RequestBody Kunder updatedKunde) {
        return kundeService.findById(id).map(kunde -> {
            kunde.setNavn(updatedKunde.getNavn());
            kunde.setEmail(updatedKunde.getEmail());
            return kundeService.save(kunde);
        }).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKunde(@PathVariable int id) {
        kundeService.deleteById(id);
    }
}

