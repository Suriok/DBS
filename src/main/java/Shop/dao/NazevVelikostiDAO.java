package Shop.dao;

import Shop.entities.NazevVelikosti;
import java.util.List;

public interface NazevVelikostiDAO extends AutoCloseable {
    List<NazevVelikosti> findAllWithProducts();
    @Override
    void close();
}