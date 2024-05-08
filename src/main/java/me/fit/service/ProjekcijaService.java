package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Projekcija;
import me.fit.exception.KorisnikException;

@Dependent
public class ProjekcijaService {

    @Inject
    private EntityManager em;

    @Transactional
    public Projekcija createProjekcija(Projekcija projekcija) throws KorisnikException {
        // Implementirajte validaciju i ostale operacije ako je potrebno
        return em.merge(projekcija);
    }

    @Transactional
    public List<Projekcija> getAllProjekcije() {
        return em.createQuery("SELECT p FROM Projekcija p", Projekcija.class)
                .getResultList();
    }
}
