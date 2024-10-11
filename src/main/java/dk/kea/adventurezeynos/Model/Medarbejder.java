package dk.kea.adventurezeynos.Model;

import jakarta.persistence.*;

@Entity
public class Medarbejder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;
    private String kode;


    public int getId() {  // Changed Long to int
        return id;
    }

    public void setId(int id) {  // Changed Long to int
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
