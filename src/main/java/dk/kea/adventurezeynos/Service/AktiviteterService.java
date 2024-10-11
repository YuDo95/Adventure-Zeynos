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


    public List<Aktiviteter> getAllAktiviteter() {
        return aktiviteterRepository.findAll();
    }


    public Aktiviteter getAktivitetById(int id) {
        return aktiviteterRepository.findById(id).orElse(null);
    }

    public Aktiviteter saveAktivitet(Aktiviteter aktivitet) {
        return aktiviteterRepository.save(aktivitet);
    }


    public Aktiviteter updateAktivitet(int id, Aktiviteter updatedAktivitet) {
        return aktiviteterRepository.findById(id).map(existingAktivitet -> {
            existingAktivitet.setNavn(updatedAktivitet.getNavn());
            existingAktivitet.setBeskrivelse(updatedAktivitet.getBeskrivelse());
            existingAktivitet.setInstruktorId(updatedAktivitet.getInstruktorId());
            existingAktivitet.setAgeLimit(updatedAktivitet.getAgeLimit());
            existingAktivitet.setPictureUrl(updatedAktivitet.getPictureUrl());
            return aktiviteterRepository.save(existingAktivitet);
        }).orElse(null);
    }


    public void deleteAktivitet(int id) {
        if (aktiviteterRepository.existsById(id)) {
            aktiviteterRepository.deleteById(id);
        }
    }

}
