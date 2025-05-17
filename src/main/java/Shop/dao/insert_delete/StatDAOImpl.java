package Shop.dao.insert_delete;

import Shop.entities.Stat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class StatDAOImpl implements StatDAO {
    private EntityManagerFactory emf;

    public StatDAOImpl() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void insert(Stat stat) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(stat);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Stat> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Stat s", Stat.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteLast() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            // Находим запись с максимальным id
            Integer maxId = em.createQuery("SELECT MAX(s.id) FROM Stat s", Integer.class)
                    .getSingleResult();
            if (maxId != null) {
                Stat stat = em.find(Stat.class, maxId);
                if (stat != null) {
                    em.remove(stat);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}