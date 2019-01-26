package ru.ryabtsev.enterprise.repository;

import jdk.internal.jline.internal.Nullable;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

abstract public class AbstractRepository {

    @PersistenceContext(name="webapp-persistence-unit")
    protected EntityManager entityManager;

    @Nullable
    <T> T getEntity(@NotNull final TypedQuery<T> query) {
        final List<T> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    <T> void addEntity(@NotNull final T entity) {
        entityManager.persist(entity);
    }
}
