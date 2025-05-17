package Shop.dao.update;

import Shop.entities.Administrator;
import java.util.List;

public interface AdministratorDAO {
    List<Administrator> findAll();
    Administrator findById(Integer id);
    void updateName(Integer id, String newJmeno, String newPrijmeni);
    void close();
}