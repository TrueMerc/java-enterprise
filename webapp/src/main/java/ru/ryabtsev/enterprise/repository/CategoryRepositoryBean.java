package ru.ryabtsev.enterprise.repository;

import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.CategoryRepository;
import ru.ryabtsev.enterprise.entity.Category;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;

/**
 * Bean for categories repository manipulation
 */
@Stateless
public class CategoryRepositoryBean extends AbstractRepository implements CategoryRepository {

    @Override
    public Collection<Category> getAll() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    @Nullable
    @Override
    public Category get(String categoryId) {
        if(categoryId == null || categoryId.isEmpty() ) return null;
        return getEntity(
                entityManager.createQuery("SELECT c FROM Category c WHERE c.id = :id", Category.class)
                        .setParameter("id", categoryId)
                        .setMaxResults(1)
        );
    }

    @Override
    public void merge(Category item) {
        super.doMerge(item);
    }

    @Override
    public void persist(Category item) {
        super.doPersist(item);
    }

    @Override
    public void remove(String categoryId) {
        super.doRemove(get(categoryId));
    }
}
