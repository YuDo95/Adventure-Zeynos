package dk.kea.adventurezeynos.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kunder")
public class Kunder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String navn;
    private String email;
    private String telefon_nummer;


    public Kunder() {}

    public Kunder(String navn, String email, String telefon_nummer) {
        this.navn = navn;
        this.email = email;
        this.telefon_nummer = telefon_nummer;
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon_nummer() {
        return telefon_nummer;
    }

    public void setTelefon_nummer(String telefon_nummer) {
        this.telefon_nummer = telefon_nummer;
    }
}