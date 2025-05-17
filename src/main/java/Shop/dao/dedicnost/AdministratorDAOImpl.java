package Shop.dao.dedicnost;

import Shop.entities.Administrator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AdministratorDAOImpl implements AdministratorDAO {
    private final EntityManagerFactory emf;

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
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}