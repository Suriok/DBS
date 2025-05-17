package Shop.dao.update;


import Shop.entities.Administrator;
import Shop.entities.Uzivatel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AdministratorDAOImpl implements AdministratorDAO {
    private EntityManagerFactory emf;

    public AdministratorDAOImpl() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public List<Administrator> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Administrator a JOIN FETCH a.uzivatel", Administrator.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Administrator findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Administrator a JOIN FETCH a.uzivatel WHERE a.id = :id", Administrator.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateName(Integer id, String newJmeno, String newPrijmeni) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Administrator admin = em.find(Administrator.class, id);
            if (admin != null) {
                Uzivatel uzivatel = admin.getUzivatel();
                if (uzivatel != null) {
                    uzivatel.setJmeno(newJmeno);
                    uzivatel.setPrijmeni(newPrijmeni);
                    // Объект uzivatel находится в управляемом состоянии, merge не требуется
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