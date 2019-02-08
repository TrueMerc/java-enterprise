package ru.ryabtsev.enterprise.repository;

import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.CategoryRepository;
import ru.ryabtsev.enterprise.entity.Category;

import java.util.Collection;


/**
 * Bean for categories repository manipulation
 */
public class CategoryRepositoryBean extends AbstractRepository implements CategoryRepository {

    @Override
    public Collection<Category> getAll() {
        return null;
    }

    @Nullable
    @Override
    public Category get(String productId) {
        return null;
    }

    @Override
    public void merge(Category item) {

    }

    @Override
    public void persist(Category item) {

    }

    @Override
    public void remove(String productId) {

    }
}
