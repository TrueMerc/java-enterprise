package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;

import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.entity.Product;

import javax.ejb.Stateless;
import java.util.*;

/**
 * Bean for products repository.
 */
@Stateless
public class ProductRepositoryBean extends AbstractRepository implements ProductRepository {


    @NonNull
    public Collection<Product> getAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Nullable
    @Override
    public Product get(String productId) {
        if(productId == null || productId.isEmpty() ) return null;
        return getEntity(
                entityManager.createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class)
                        .setParameter("id", productId)
                        .setMaxResults(1)
        );
    }

    @Override
    public void remove(String productId) {
        entityManager.remove(get(productId));
    }

    @Override
    public void merge(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void persist(Product product) {
        super.persist(product);
    }

}
