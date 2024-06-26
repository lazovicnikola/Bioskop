package me.fit.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Projekcija {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rezervacija_seq")
    private Long id;

    private String naziv;

    @ManyToMany(mappedBy = "projekcije")
    private Set<Rezervacija> rezervacije;

    public Projekcija() {
        super();
    }

    public Projekcija(String naziv) {
        super();
        this.naziv = naziv;
    }

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

    public Set<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Projekcija other = (Projekcija) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (naziv == null) {
            if (other.naziv != null)
                return false;
        } else if (!naziv.equals(other.naziv))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Projekcija [id=" + id + ", naziv=" + naziv + "]";
    }

}
