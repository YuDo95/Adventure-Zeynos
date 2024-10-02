package dk.kea.adventurezeynos.Model;

public class Kunder {

    private int id;
    private String navn;
    private String email;

    // Constructors
    public Kunder() {}

    public Kunder(String navn, String email) {
        this.navn = navn;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
