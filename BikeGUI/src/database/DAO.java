package database;

import java.util.List;
import java.util.Optional;

/**
 * an Interface for db management
 * @author Group 10
 */

public interface DAO <T> {
    /**
     * get all Object from db
     * @return a List of Object
     */
	List<T> getAll();

    /**
     * get Object from db by Id
     * @param id id of object
     * @return Object
     */
	T getByID(int id);

    /**
     * save object to db
     * @param t object t
     */
    void save(T t);

    /**
     * update an existed object to fb
     * @param t obbject
     */
    void update(T t);

    /**
     * remove an object in db
     * @param t object
     */
    void delete(T t);
}