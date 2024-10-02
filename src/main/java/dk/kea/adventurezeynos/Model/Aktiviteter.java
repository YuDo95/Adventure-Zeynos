package dk.kea.adventurezeynos.Model;

public class Aktiviteter {

    private int id; // Changed from Long to int
    private String navn;
    private Instruktører instruktør;

    // Constructors
    public Aktiviteter() {}

    public Aktiviteter(int id, String navn, Instruktører instruktør) {
        this.id = id;
        this.navn = navn;
        this.instruktør = instruktør;
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

    public Instruktører getInstruktør() {
        return instruktør;
    }

    public void setInstruktør(Instruktører instruktør) {
        this.instruktør = instruktør;
    }
}
