package dk.kea.adventurezeynos.Model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "bookinger")  // Maps to the "bookinger" table in the database
public class Bookinger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "aktivitet_id", referencedColumnName = "id")
    private Aktiviteter aktivitet;

    @ManyToOne
    @JoinColumn(name = "kunde_id", referencedColumnName = "id")
    private Kunder kunde;

    @Temporal(TemporalType.DATE)
    private Date dato;

    private int antalDeltagere;

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
