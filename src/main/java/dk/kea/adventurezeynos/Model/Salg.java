package dk.kea.adventurezeynos.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "salg")  // Map to the "salg" table in the database
public class Salg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    private int id;

    @ManyToOne
    @JoinColumn(name = "vare_id", referencedColumnName = "id")
    private Varer vare;

    @ManyToOne
    @JoinColumn(name = "kunde_id", referencedColumnName = "id")
    private Kunder kunde;

    private int antal;

    // Constructors
    public Salg() {}

    public Salg(int id, Varer vare, Kunder kunde, int antal) {
        this.id = id;
        this.vare = vare;
        this.kunde = kunde;
        this.antal = antal;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Varer getVare() {
        return vare;
    }

    public void setVare(Varer vare) {
        this.vare = vare;
    }

    public Kunder getKunde() {
        return kunde;
    }

    public void setKunde(Kunder kunde) {
        this.kunde = kunde;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }
}
