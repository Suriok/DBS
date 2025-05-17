package Shop;

import Shop.dao.dedicnost.ZakaznikDAO;
import Shop.dao.dedicnost.ZakaznikDAOImpl;
import Shop.dao.insert_delete.StatDAO;
import Shop.dao.insert_delete.StatDAOImpl;
import Shop.dao.update.AdministratorDAO;
import Shop.dao.update.AdministratorDAOImpl;
import Shop.entities.Administrator;
import Shop.entities.Stat;
import Shop.entities.Uzivatel;
import Shop.entities.Zakaznik;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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
//            stat.setNazev("New");
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
//            adminDAO.updateName(9, "Marek", "Du");
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


    }
}