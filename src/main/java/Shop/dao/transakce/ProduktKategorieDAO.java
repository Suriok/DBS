package Shop.dao.transakce;

import Shop.entities.Administrator;
import Shop.entities.Kategorie;
import Shop.entities.Nalezi;
import Shop.entities.NaleziId;
import Shop.entities.Produkt;
import Shop.entities.Znacka;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;

public class ProduktKategorieDAO {

    public void createProductAndLinkToCategory(
            EntityManager entityManager,
            Integer produktIdUzivatel,
            String produktArtikul,
            String produktNazev,
            Integer produktIdZnacka,
            String barva,
            BigDecimal produktCena,
            String kategorieNazev,
            Integer kategorieIdUzivatel,
            Integer kategorieIdNadkategorii
    ) {
        try {
            // Step 1: Create and persist Produkt
            Produkt produkt = new Produkt();

            // Check Administrator for produktIdUzivatel
            Administrator produktAdmin = entityManager.find(Shop.entities.Administrator.class, produktIdUzivatel);
            if (produktAdmin == null) {
                throw new IllegalArgumentException("Administrator with id " + produktIdUzivatel + " not found");
            }
            produkt.setIdUzivatel(produktAdmin);

            produkt.setArtikul(produktArtikul);
            produkt.setNazev(produktNazev);
            produkt.setBarva(barva);

            // Check if Znacka exists
            Znacka znacka = entityManager.find(Shop.entities.Znacka.class, produktIdZnacka);
            if (znacka == null) {
                throw new IllegalArgumentException("Znacka with id " + produktIdZnacka + " not found");
            }
            produkt.setIdZnacka(znacka);

            produkt.setCena(produktCena);
            entityManager.persist(produkt);

            // Step 2: Check if Kategorie exists
            TypedQuery<Kategorie> query = entityManager.createQuery(
                    "SELECT k FROM Kategorie k WHERE k.nazev = :nazev",
                    Kategorie.class
            );
            query.setParameter("nazev", kategorieNazev);
            Kategorie kategorie;
            try {
                kategorie = query.getSingleResult();
            } catch (jakarta.persistence.NoResultException e) {
                // Category doesn't exist, create it
                kategorie = new Kategorie();
                kategorie.setNazev(kategorieNazev);

                // Check Administrator for kategorieIdUzivatel
                Administrator kategorieAdmin = entityManager.find(Shop.entities.Administrator.class, kategorieIdUzivatel);
                if (kategorieAdmin == null) {
                    throw new IllegalArgumentException("Administrator with id " + kategorieIdUzivatel + " not found");
                }
                kategorie.setIdUzivatel(kategorieAdmin);

                // Check Nadkategorie
                if (kategorieIdNadkategorii != null) {
                    Kategorie nadkategorie = entityManager.find(Kategorie.class, kategorieIdNadkategorii);
                    if (nadkategorie == null) {
                        throw new IllegalArgumentException("Nadkategorie with id " + kategorieIdNadkategorii + " not found");
                    }
                    kategorie.setIdNadkategorii(nadkategorie);
                } else {
                    kategorie.setIdNadkategorii(null);
                }

                entityManager.persist(kategorie);
            }

            // Step 3: Create Nalezi to link Produkt and Kategorie
            Nalezi nalezi = new Nalezi();
            NaleziId naleziId = new NaleziId();
            naleziId.setIdProdukt(produkt.getId());
            naleziId.setIdKategorie(kategorie.getId());
            nalezi.setId(naleziId);
            nalezi.setIdProdukt(produkt);
            nalezi.setIdKategorie(kategorie);
            entityManager.persist(nalezi);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create product and link to category: " + e.getMessage(), e);
        }
    }
}