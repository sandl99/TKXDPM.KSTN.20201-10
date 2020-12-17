package database;

import java.util.List;
import java.util.Optional;

public interface DAO <T> {
	List<T> getAll();
	T getByID(int id);
    void save(T t);
    void update(T t);
    void delete(T t);
}