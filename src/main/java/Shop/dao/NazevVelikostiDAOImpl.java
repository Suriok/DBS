package Shop.dao;

import Shop.entities.NazevVelikosti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class NazevVelikostiDAOImpl implements NazevVelikostiDAO {
    private final EntityManagerFactory emf;

    public NazevVelikostiDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<NazevVelikosti> findAllWithProducts() {
        EntityManager em = emf.createEntityManager();
        try {
            List<NazevVelikosti> sizes = em.createQuery("SELECT nv FROM NazevVelikosti nv LEFT JOIN FETCH nv.produkts", NazevVelikosti.class)
                    .getResultList();
            System.out.println("Loaded sizes: " + sizes.size());
            for (NazevVelikosti size : sizes) {
                System.out.println("Size ID: " + size.getId() + ", Name: " + size.getNazevVelikosti() +
                        ", Products count: " + size.getProdukts().size());
            }
            return sizes;
        } finally {
            em.close();
        }
    }

    @Override
    public void close() {
        // Не закрываем emf здесь, так как она будет закрыта в Main
    }
}