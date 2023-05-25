package g6.project.CamadaPersistencia.DAO;

import java.util.ArrayList;

public interface DAO<T> {
    int insert(T t);
    T get(int cod);
}
