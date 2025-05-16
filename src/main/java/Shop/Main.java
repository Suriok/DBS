package Shop;

import Shop.dao.ZnackaDAO;
import Shop.dao.ZnackaDAOImpl;
import Shop.entities.Znacka;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//        EntityManager em = emf.createEntityManager();
//
//        // Close EntityManager
//        em.close();
//        emf.close();


        ZnackaDAO znackaDAO = null;
        try {
            // Инициализация DAO
            znackaDAO = new ZnackaDAOImpl();

            // Создаем новый бренд
            Znacka znacka = new Znacka();
            znacka.setNazev("Nike");

            // Вставляем бренд в базу данных
            znackaDAO.insert(znacka);
            System.out.println("Бренд успешно добавлен!");

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Закрываем DAO
            if (znackaDAO != null) {
                ((ZnackaDAOImpl) znackaDAO).close();
            }
        }
    }
}
