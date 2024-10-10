package dk.kea.adventurezeynos.Service;

import dk.kea.adventurezeynos.Model.Aktiviteter;
import dk.kea.adventurezeynos.Repository.AktiviteterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AktiviteterService {

    @Autowired
    private AktiviteterRepository aktiviteterRepository;

    // Method to get all activities
    public List<Aktiviteter> getAllAktiviteter() {
        return aktiviteterRepository.findAll();
    }

    // Method to get a specific activity by its ID
    public Aktiviteter getAktivitetById(int id) {
        return aktiviteterRepository.findById(id).orElse(null);
    }

    // Method to save a new activity
    public Aktiviteter saveAktivitet(Aktiviteter aktivitet) {
        return aktiviteterRepository.save(aktivitet);
    }

    // Method to update an existing activity
    public Aktiviteter updateAktivitet(int id, Aktiviteter updatedAktivitet) {
        return aktiviteterRepository.findById(id).map(existingAktivitet -> {
            // Update fields of the existing activity
            existingAktivitet.setNavn(updatedAktivitet.getNavn());
            existingAktivitet.setBeskrivelse(updatedAktivitet.getBeskrivelse());
            existingAktivitet.setInstruktorId(updatedAktivitet.getInstruktorId());
            existingAktivitet.setAgeLimit(updatedAktivitet.getAgeLimit());
            existingAktivitet.setPictureUrl(updatedAktivitet.getPictureUrl());
            // Save the updated activity
            return aktiviteterRepository.save(existingAktivitet);
        }).orElse(null); // Return null or throw exception if activity not found
    }

    // Method to delete an activity by its ID
    public void deleteAktivitet(int id) {
        if (aktiviteterRepository.existsById(id)) {
            aktiviteterRepository.deleteById(id);
        }
    }

}
