package dk.kea.adventurezeynos.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "aktiviteter")
public class AktiviteterAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String navn;

    @Column(name = "instruktør_id")
    private int instruktørId;

    @Column(name = "picture_url")
    private String pictureUrl;

    private String beskrivelse;

    @Column(name = "age_limit")
    private String ageLimit;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getInstruktørId() {
        return instruktørId;
    }

    public void setInstruktørId(int instruktørId) {
        this.instruktørId = instruktørId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }
}