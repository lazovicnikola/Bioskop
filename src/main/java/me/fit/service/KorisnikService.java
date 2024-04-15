package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.exception.KorisnikException;
import me.fit.enums.KorisnikStatus;
import me.fit.model.Korisnik;

@Dependent
public class KorisnikService {

    @Inject
    private EntityManager em;

    @Transactional
    public Korisnik createKorisnik(Korisnik korisnik) throws KorisnikException {
        List<Korisnik> korisnici = getAllKorisnici();

        if (korisnici.contains(korisnik)) {
            throw new KorisnikException(KorisnikStatus.EXISTS.getLabel());
        }

        return em.merge(korisnik);
    }

    @Transactional
    public List<Korisnik> getAllKorisnici() {
        return em.createNamedQuery(Korisnik.GET_ALL_KORISNICI, Korisnik.class).getResultList();
    }

    @Transactional
    public List<Korisnik> getKorisniciByIme(String ime) {
        return em.createNamedQuery(Korisnik.GET_KORISNICI_BY_IME, Korisnik.class)
                .setParameter("ime", ime)
                .getResultList();
    }
}
