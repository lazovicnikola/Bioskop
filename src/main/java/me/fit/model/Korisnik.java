package me.fit.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
//import me.fit.model.rest.client.IpClient;

@Entity
@NamedQueries({ 
    @NamedQuery(name = Korisnik.GET_ALL_KORISNICI, query = "SELECT k FROM Korisnik k"),
    @NamedQuery(name = Korisnik.GET_KORISNICI_BY_IME, query = "SELECT k FROM Korisnik k WHERE k.ime = :ime") 
})
public class Korisnik {

    public static final String GET_ALL_KORISNICI = "getAllKorisnici";
    public static final String GET_KORISNICI_BY_IME = "getKorisniciByIme";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "korisnik_seq")
    private Long id;

    private String ime;

    private String prezime;

    private String email;

    private String sifra;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private IpClient ipClient;

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    // Možete dodati gettere i settere za dodatne atribute ili promijeniti postojeće prema potrebi

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        Korisnik other = (Korisnik) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", sifra=" + sifra + "]";
    }
}
