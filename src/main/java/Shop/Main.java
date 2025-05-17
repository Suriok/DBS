package Shop;

import Shop.dao.NazevVelikostiDAO;
import Shop.dao.NazevVelikostiDAOImpl;
import Shop.dao.dedicnost.ZakaznikDAO;
import Shop.dao.dedicnost.ZakaznikDAOImpl;
import Shop.dao.insert_delete.StatDAO;
import Shop.dao.insert_delete.StatDAOImpl;
import Shop.dao.transakce.ProduktKategorieDAO;
import Shop.dao.update.AdministratorDAO;
import Shop.dao.update.AdministratorDAOImpl;
import Shop.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Set;

public class Main {
    // Константы для подключения к базе данных
//    private static final String DB_URL = "jdbc:postgresql://slon.felk.cvut.cz:5432/sydorvol";
//    private static final String DB_USER = "sydorvol";
//    private static final String DB_PASSWORD = "sydorvol_DBS25";

    public static void main(String[] args) {
//        // Очистка существующих соединений
//        terminateExistingConnections();
//
//        System.out.println("Connections cleared. You can now proceed with other operations.");


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//        EntityManager em = emf.createEntityManager();
//
//
//        em.close();
//        emf.close();


//        // -------------------------- INSERT --------------------------
//        StatDAO statDAO = null;
//
//        try {
//            // Initialize DAO
//            statDAO = new StatDAOImpl();
//
//            // INSERT
//            Stat stat = new Stat();
//            stat.setNazev("Korea");
//            statDAO.insert(stat);
//            System.out.println("Country added successfully!");
//
//            List<Stat> allStats = statDAO.findAll(); // SELECT
//            System.out.println("Státy:");
//            allStats.forEach(s -> System.out.println(" - " + s.getNazev()));
//
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (statDAO != null) {
//                statDAO.close();
//            }
//        }


        // -------------------------- UPDATE --------------------------
//        AdministratorDAO adminDAO = new AdministratorDAOImpl();
//
//        try {
//            // Display list of administrators before update
//            List<Administrator> admins = adminDAO.findAll();
//            System.out.println("Administrators before update:");
//            for (Administrator admin : admins) {
//                Uzivatel uzivatel = admin.getUzivatel();
//                System.out.println("ID: " + admin.getId() +
//                        ", Name: " + uzivatel.getJmeno() +
//                        ", Surname: " + uzivatel.getPrijmeni());
//            }
//
//            // Update administrator with ID 9
//            adminDAO.updateName(9, "Marina", "Du");
//
//            // Display list of administrators after update
//            admins = adminDAO.findAll();
//            System.out.println("\nAdministrators after update:");
//            for (Administrator admin : admins) {
//                Uzivatel uzivatel = admin.getUzivatel();
//                System.out.println("ID: " + admin.getId() +
//                        ", Name: " + uzivatel.getJmeno() +
//                        ", Surname: " + uzivatel.getPrijmeni());
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            adminDAO.close();
//        }

        // -------------------------- DELETE --------------------------
//        StatDAO statDAO = new StatDAOImpl();
//
//        try {
//            // Display list of countries before deletion
//            List<Stat> stats = statDAO.findAll();
//            System.out.println("Countries before deletion:");
//            if (stats.isEmpty()) {
//                System.out.println(" - List is empty");
//            } else {
//                stats.forEach(s -> System.out.println(" - ID: " + s.getId() + ", Name: " + s.getNazev()));
//            }
//
//            // Delete the record with the last ID
//            statDAO.deleteLast();
//            System.out.println("Record with the last ID deleted.");
//
//            // Display list of countries after deletion
//            stats = statDAO.findAll();
//            System.out.println("\nCountries after deletion:");
//            if (stats.isEmpty()) {
//                System.out.println(" - List is empty");
//            } else {
//                stats.forEach(s -> System.out.println(" - ID: " + s.getId() + ", Name: " + s.getNazev()));
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            statDAO.close();
//        }

// -------------------------- DEDICNOST --------------------------
//        ZakaznikDAO zakaznikDAO = new ZakaznikDAOImpl();
//        AdministratorDAO adminDAO = new AdministratorDAOImpl();
//
//        try {
//            // --- Zakaznik ---
//            List<Zakaznik> zakazniks = zakaznikDAO.findAll();
//            System.out.println("Customers:");
//            if (zakazniks.isEmpty()) {
//                System.out.println(" - No customers found");
//            } else {
//                for (Zakaznik zakaznik : zakazniks) {
//                    Uzivatel uzivatel = zakaznik.getUzivatel();
//                    System.out.println(" - ID: " + zakaznik.getId() +
//                            ", Name: " + uzivatel.getJmeno() +
//                            ", Surname: " + uzivatel.getPrijmeni() +
//                            ", Email: " + (uzivatel.getEmail() != null ? uzivatel.getEmail() : "N/A") +
//                            ", Phone: " + (uzivatel.getTelefon() != null ? uzivatel.getTelefon() : "N/A"));
//                }
//            }
//
//            // --- Administrator ---
//            List<Administrator> admins = adminDAO.findAll();
//            System.out.println("\nAdministrators:");
//            if (admins.isEmpty()) {
//                System.out.println(" - No administrators found");
//            } else {
//                for (Administrator admin : admins) {
//                    Uzivatel uzivatel = admin.getUzivatel();
//                    System.out.println(" - ID: " + admin.getId() +
//                            ", Name: " + uzivatel.getJmeno() +
//                            ", Surname: " + uzivatel.getPrijmeni() +
//                            ", Email: " + (uzivatel.getEmail() != null ? uzivatel.getEmail() : "N/A") +
//                            ", Phone: " + (uzivatel.getTelefon() != null ? uzivatel.getTelefon() : "N/A") +
//                            ", Internal phone: " + admin.getInterniTelefon());
//                }
//            }
//
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            zakaznikDAO.close();
//            adminDAO.close();
//        }

// -------------------------- Many to Many Dao --------------------------
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//        NazevVelikostiDAO nazevVelikostiDAO = new NazevVelikostiDAOImpl(emf);
//
//        try {
//            // Display list of sizes with their products
//            List<NazevVelikosti> sizes = nazevVelikostiDAO.findAllWithProducts();
//            System.out.println("\nSizes and their products:");
//            if (sizes.isEmpty()) {
//                System.out.println(" - No sizes found");
//            } else {
//                for (NazevVelikosti size : sizes) {
//                    System.out.println("Size ID: " + size.getId() +
//                            ", Size Name: " + size.getNazevVelikosti());
//                    Set<Produkt> products = size.getProdukts();
//                    System.out.println("  Products count: " + products.size());
//                    if (products.isEmpty()) {
//                        System.out.println("  - No products for this size");
//                    } else {
//                        for (Produkt product : products) {
//                            System.out.println("  - Product ID: " + product.getId() +
//                                    ", Name: " + product.getNazev() +
//                                    ", Artikul: " + product.getArtikul() +
//                                    ", Price: " + product.getCena());
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            nazevVelikostiDAO.close();
//            if (emf != null && emf.isOpen()) {
//                emf.close();
//            }
//        }


// -------------------------- Tranzakce --------------------------
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//        EntityManager em = emf.createEntityManager();
//        ProduktKategorieDAO dao = new ProduktKategorieDAO();
//
//        Produkt createdProdukt = null; // To store the created Produkt
//        Kategorie createdKategorie = null; // To store the created or retrieved Kategorie
//
//        try {
//            em.getTransaction().begin();
//
//            // Call a modified version of createProductAndLinkToCategory that returns the created entities
//            createdProdukt = new Produkt();
//            createdProdukt.setIdUzivatel(em.find(Shop.entities.Administrator.class, 8));
//            createdProdukt.setArtikul("ART5648378");
//            createdProdukt.setNazev("Test23");
//            createdProdukt.setIdZnacka(em.find(Shop.entities.Znacka.class, 1));
//            createdProdukt.setBarva("Red");
//            createdProdukt.setCena(BigDecimal.valueOf(99.99));
//
//            em.persist(createdProdukt);
//
//            // Check if Kategorie exists
//            TypedQuery<Kategorie> query = em.createQuery(
//                    "SELECT k FROM Kategorie k WHERE k.nazev = :nazev",
//                    Kategorie.class
//            );
//            query.setParameter("nazev", "Test Kategorie");
//            try {
//                createdKategorie = query.getSingleResult();
//            } catch (jakarta.persistence.NoResultException e) {
//                // Category doesn't exist, create it
//                createdKategorie = new Kategorie();
//                createdKategorie.setNazev("Test Kategorie");
//                createdKategorie.setIdUzivatel(em.find(Shop.entities.Administrator.class, 8));
//                createdKategorie.setIdNadkategorii(null);
//                em.persist(createdKategorie);
//            }
//
//            // Create Nalezi to link Produkt and Kategorie
//            Nalezi nalezi = new Nalezi();
//            NaleziId naleziId = new NaleziId();
//            naleziId.setIdProdukt(createdProdukt.getId());
//            naleziId.setIdKategorie(createdKategorie.getId());
//            nalezi.setId(naleziId);
//            nalezi.setIdProdukt(createdProdukt);
//            nalezi.setIdKategorie(createdKategorie);
//            em.persist(nalezi);
//
//            em.getTransaction().commit();
//            System.out.println("Product and category linked successfully.");
//
//            // Output Produkt details
//            System.out.println("Created Produkt:");
//            System.out.println("  ID: " + createdProdukt.getId());
//            System.out.println("  Artikul: " + createdProdukt.getArtikul());
//            System.out.println("  Nazev: " + createdProdukt.getNazev());
//            System.out.println("  Barva: " + createdProdukt.getBarva());
//            System.out.println("  Cena: " + createdProdukt.getCena());
//            System.out.println("  Znacka ID: " + createdProdukt.getIdZnacka().getId());
//            System.out.println("  Administrator ID: " + createdProdukt.getIdUzivatel().getId());
//
//            // Output Kategorie details
//            System.out.println("Created or Retrieved Kategorie:");
//            System.out.println("  ID: " + createdKategorie.getId());
//            System.out.println("  Nazev: " + createdKategorie.getNazev());
//            System.out.println("  Administrator ID: " + createdKategorie.getIdUzivatel().getId());
//            System.out.println("  Nadkategorie ID: " + (createdKategorie.getIdNadkategorii() != null ? createdKategorie.getIdNadkategorii().getId() : "null"));
//
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            em.close();
//            if (emf != null && emf.isOpen()) {
//                emf.close();
//            }
//        }
  }


    // код для очищения
//    private static void terminateExistingConnections() {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            // Проверка лимита соединений
//            try (PreparedStatement pstmtLimit = conn.prepareStatement("SELECT rolconnlimit FROM pg_roles WHERE rolname = ?")) {
//                pstmtLimit.setString(1, DB_USER);
//                try (ResultSet rs = pstmtLimit.executeQuery()) {
//                    if (rs.next()) {
//                        int connectionLimit = rs.getInt("rolconnlimit");
//                        System.out.println("Connection limit for user " + DB_USER + ": " + (connectionLimit == -1 ? "unlimited" : connectionLimit));
//                    }
//                }
//            }
//
//            // Закрытие существующих соединений
//            String sql = "SELECT pg_terminate_backend(pg_stat_activity.pid) " +
//                    "FROM pg_stat_activity " +
//                    "WHERE pg_stat_activity.usename = ? AND pid <> pg_backend_pid()";
//            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                pstmt.setString(1, DB_USER);
//                int terminatedConnections = 0;
//                try (ResultSet rs = pstmt.executeQuery()) {
//                    while (rs.next()) {
//                        boolean terminated = rs.getBoolean(1); // pg_terminate_backend возвращает true/false
//                        if (terminated) {
//                            terminatedConnections++;
//                        }
//                    }
//                }
//                System.out.println("Terminated " + terminatedConnections + " existing connections for user " + DB_USER + ".");
//            }
//        } catch (SQLException e) {
//            System.err.println("Failed to terminate existing connections: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
}