package Shop.dao.dedicnost;

import Shop.entities.Uzivatel;
import Shop.entities.Zakaznik;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ZakaznikDAOImpl implements ZakaznikDAO {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ZakaznikDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    @Override
    public void insert(Zakaznik zakaznik) {
        em.getTransaction().begin();
        em.persist(zakaznik);
        em.getTransaction().commit();
    }

    @Override
    public List<Zakaznik> findAll() {
        return em.createQuery("SELECT z FROM Zakaznik z", Zakaznik.class).getResultList();
    }

    @Override
    public void update(Integer id, String jmeno, String prijmeni, String email, String telefon) {
        em.getTransaction().begin();

        Zakaznik zakaznik = em.find(Zakaznik.class, id);
        if (zakaznik != null) {
            Uzivatel uzivatel = zakaznik.getUzivatel();
            if (uzivatel != null) {
                uzivatel.setJmeno(jmeno);
                uzivatel.setPrijmeni(prijmeni);
                uzivatel.setEmail(email);
                uzivatel.setTelefon(telefon);
            }
        }

        em.getTransaction().commit();
    }

    @Override
    public void close() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}
