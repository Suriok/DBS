package Shop.dao.insert_delete;

import Shop.entities.Stat;
import java.util.List;

public interface StatDAO {
    void insert(Stat stat);
    List<Stat> findAll();
    void deleteLast();
    void close();
}