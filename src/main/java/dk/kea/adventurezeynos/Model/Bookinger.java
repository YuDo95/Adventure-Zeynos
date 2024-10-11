package dk.kea.adventurezeynos.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Bookinger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Aktiviteter aktivitet;

    @ManyToOne
    private Kunder kunde;

    private LocalDate dato; // Changed from Date to LocalDate

    private int antalDeltagere;

    // Default constructor
    public Bookinger() {
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aktiviteter getAktivitet() {
        return aktivitet;
    }

    public void setAktivitet(Aktiviteter aktivitet) {
        this.aktivitet = aktivitet;
    }

    public Kunder getKunde() {
        return kunde;
    }

    public void setKunde(Kunder kunde) {
        this.kunde = kunde;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public int getAntalDeltagere() {
        return antalDeltagere;
    }

    public void setAntalDeltagere(int antalDeltagere) {
        this.antalDeltagere = antalDeltagere;
    }

    @Override
    public String toString() {
        return "Bookinger{" +
                "id=" + id +
                ", aktivitet=" + aktivitet +
                ", kunde=" + kunde +
                ", dato=" + dato +
                ", antalDeltagere=" + antalDeltagere +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bookinger)) return false;
        Bookinger that = (Bookinger) o;
        return antalDeltagere == that.antalDeltagere &&
                id.equals(that.id) &&
                aktivitet.equals(that.aktivitet) &&
                kunde.equals(that.kunde) &&
                dato.equals(that.dato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aktivitet, kunde, dato, antalDeltagere);
    }
}
