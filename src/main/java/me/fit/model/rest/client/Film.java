package me.fit.model.rest.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = Film.GET_ALL, query = "SELECT f FROM Film f")
})
public class Film {

    public static final String GET_ALL = "Film.getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_seq")
    @JsonIgnore
    private Long id;

    private String naziv;

    private String opis;

    private int trajanje;

    private int godinaIzdanja;

    // Možete dodati i dodatne atribute i metode prema potrebi

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    // Možete dodati gettere i settere za dodatne atribute ili promijeniti postojeće prema potrebi

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Film other = (Film) obj;
        if (naziv == null) {
            if (other.naziv != null)
                return false;
        } else if (!naziv.equals(other.naziv))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", trajanje=" + trajanje + ", godinaIzdanja="
                + godinaIzdanja + "]";
    }

}
