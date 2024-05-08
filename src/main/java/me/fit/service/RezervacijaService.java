package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Rezervacija;
import me.fit.exception.KorisnikException;

@Dependent
public class RezervacijaService {

    @Inject
    private EntityManager em;

    @Transactional
    public Rezervacija createRezervacija(Rezervacija rezervacija) throws KorisnikException {
        // Implementirajte validaciju i ostale operacije ako je potrebno
        return em.merge(rezervacija);
    }

    @Transactional
    public List<Rezervacija> getAllRezervacije() {
        return em.createQuery("SELECT r FROM Rezervacija r", Rezervacija.class)
                .getResultList();
    }
}
