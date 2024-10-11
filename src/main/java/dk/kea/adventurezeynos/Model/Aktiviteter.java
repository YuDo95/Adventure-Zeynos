package dk.kea.adventurezeynos.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "aktiviteter")
public class Aktiviteter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String navn;

    @Column(name = "instruktør_id")
    private int instruktorId;

    @Column(name = "picture_url")
    private String pictureUrl;

    private String beskrivelse;

    @Column(name = "age_limit")
    private String ageLimit;


    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getInstruktorId() {
        return instruktorId;
    }

    public void setInstruktorId(int instruktorId) {
        this.instruktorId = instruktorId;
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

    @Override
    public String toString() {
        return "Aktiviteter{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", instruktorId=" + instruktorId +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", ageLimit='" + ageLimit + '\'' +
                '}';
    }
}
