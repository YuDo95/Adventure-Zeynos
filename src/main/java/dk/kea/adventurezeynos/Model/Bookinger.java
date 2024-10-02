package dk.kea.adventurezeynos.Model;

import java.util.Date;

public class Bookinger {

    private int id; // Changed from Long to int
    private Aktiviteter aktivitet;
    private Kunder kunde;
    private Date dato;
    private int antalDeltagere; // Changed from Integer to int

    // Constructors
    public Bookinger() {}

    public Bookinger(int id, Aktiviteter aktivitet, Kunder kunde, Date dato, int antalDeltagere) {
        this.id = id;
        this.aktivitet = aktivitet;
        this.kunde = kunde;
        this.dato = dato;
        this.antalDeltagere = antalDeltagere;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public int getAntalDeltagere() {
        return antalDeltagere;
    }

    public void setAntalDeltagere(int antalDeltagere) {
        this.antalDeltagere = antalDeltagere;
    }
}
