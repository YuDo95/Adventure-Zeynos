package dk.kea.adventurezeynos.Controller;

import dk.kea.adventurezeynos.Model.Kunder;
import dk.kea.adventurezeynos.Service.KunderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    @GetMapping("/kundeOprettelse")
    public String showKundeOprettelse() {
        return "kundeOprettelse";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKunde(@PathVariable int id) {
        kundeService.deleteById(id);
    }

    @PostMapping("/kunder/save")
    public ResponseEntity<?> saveKunde(@RequestBody Kunder kunde) {
        // Save the new customer to the database
        Kunder savedKunde = kundeService.save(kunde);

        // Now you can use savedKunde.getId() to get the auto-generated ID
        return ResponseEntity.ok(savedKunde);
    }

    @GetMapping("/check")
    public ResponseEntity<Void> checkCustomerExists(@RequestParam String email) {
        boolean exists = kundeService.existsByEmail(email);
        if (exists) {
            return ResponseEntity.ok().build(); // Return 200 OK if exists
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if not exists
        }
    }

}

