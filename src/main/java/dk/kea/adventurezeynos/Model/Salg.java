package dk.kea.adventurezeynos.Model;

public class Salg {

    private int id; // Changed from Long to int
    private Varer vare;
    private Kunder kunde;
    private int antal; // Changed from Integer to int

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
