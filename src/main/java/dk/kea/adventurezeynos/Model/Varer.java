package dk.kea.adventurezeynos.Model;

public class Varer {

    private int id;
    private String navn;
    private Double pris;

    // Constructors
    public Varer() {}

    public Varer(String navn, Double pris) {
        this.navn = navn;
        this.pris = pris;
    }

    // Getters and Setters
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

    public Double getPris() {
        return pris;
    }

    public void setPris(Double pris) {
        this.pris = pris;
    }
}
