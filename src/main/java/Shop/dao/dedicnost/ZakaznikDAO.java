package Shop.dao.dedicnost;

import Shop.entities.Zakaznik;

import java.util.List;

public interface ZakaznikDAO {
    void insert(Zakaznik zakaznik);
    List<Zakaznik> findAll();
    void update(Integer id, String jmeno, String prijmeni, String email, String telefon);
    void close();
}
