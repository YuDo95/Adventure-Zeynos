package dk.kea.adventurezeynos.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "aktiviteter")  // Specify the table name if different from the class name
public class Aktiviteter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String navn;

    @ManyToOne  // Many activities can be associated with one instructor
    @JoinColumn(name = "instruktor_id", referencedColumnName = "id")
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
