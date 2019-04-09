package repo;

import java.io.IOException;

public interface ICrudRepo<ID, E> {
    /***
     *
     * @return all entities
     */
    Iterable<E> findAll();

}
