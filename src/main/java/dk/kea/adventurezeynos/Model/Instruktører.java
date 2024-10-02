package dk.kea.adventurezeynos.Model;

public class Instruktører {

    private int id; // Changed from Long to int
    private String navn;

    // Constructors
    public Instruktører() {}

    public Instruktører(int id, String navn) {
        this.id = id;
        this.navn = navn;
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
}
