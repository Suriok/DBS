package Shop.dao.dedicnost;

import Shop.entities.Administrator;
import java.util.List;

public interface AdministratorDAO extends AutoCloseable {
    List<Administrator> findAll();
    @Override
    void close();
}