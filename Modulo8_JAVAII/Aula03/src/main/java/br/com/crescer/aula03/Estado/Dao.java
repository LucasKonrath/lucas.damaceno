package br.com.crescer.aula03.Estado;

/**
 * @author carloshenrique
 */
public interface Dao<T> {
    
    void insert(T t);

    void update(T t);

    void delete(T t);
    
    T loadBy(Long id);

}