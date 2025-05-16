package Shop.dao;

import Shop.entities.Znacka;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ZnackaDAOImpl implements ZnackaDAO {
    private final EntityManagerFactory emf;

    public ZnackaDAOImpl() {
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void insert(Znacka znacka) throws Exception {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(znacka);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Ошибка при вставке бренда: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void close() {
        if (emf != null) {
            emf.close();
        }
    }
}