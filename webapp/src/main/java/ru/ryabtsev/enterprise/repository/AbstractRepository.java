package ru.ryabtsev.enterprise.repository;

import jdk.internal.jline.internal.Nullable;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implements common functionality for different entity types repositories.
 */
abstract public class AbstractRepository {

    @PersistenceContext(name="webapp-persistence-unit")
    protected EntityManager entityManager;

    /**
     * Returns first entity which returned for given query.
     * @param query query to database manager.
     * @param <T> entity type.
     * @return first entity which returned for given query.
     */
    @Nullable
    <T> T getEntity(@NotNull final TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    /**
     * Merges given entity from database.
     * @param entity entity to remove.
     * @param <T> entity type.
     */
    protected <T> void doMerge(@NotNull final T entity) { entityManager.merge(entity); }


    /**
     * Removes given entity from database.
     * @param entity entity to remove.
     * @param <T> entity type.
     */
    protected <T> void doRemove(@NotNull final T entity) { entityManager.remove(entity);}


    /**
     * Persists given entity from database.
     * @param entity entity to remove.
     * @param <T> entity type.
     */
    protected <T> void doPersist(@NotNull final T entity) {
        entityManager.persist(entity);
    }
}
