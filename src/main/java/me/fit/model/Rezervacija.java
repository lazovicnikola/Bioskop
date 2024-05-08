package me.fit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rezervacija_seq")
    private Long id;

    private Date datum;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Rezervacija_Projekcija",
        joinColumns = { @JoinColumn(name = "rezervacija_id") },
        inverseJoinColumns = { @JoinColumn(name = "projekcija_id") }
    )
    private Set<Projekcija> projekcije = new HashSet<>();

    public Rezervacija() {
        super();
    }

    public Rezervacija(Date datum) {
        super();
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Set<Projekcija> getProjekcije() {
        return projekcije;
    }

    public void setKorisnici(Set<Projekcija> projekcije) {
        this.projekcije = projekcije;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((datum == null) ? 0 : datum.hashCode());
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
        Rezervacija other = (Rezervacija) obj;
        if (datum == null) {
            if (other.datum != null)
                return false;
        } else if (!datum.equals(other.datum))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rezervacija [id=" + id + ", datum=" + datum + "]";
    }

}
