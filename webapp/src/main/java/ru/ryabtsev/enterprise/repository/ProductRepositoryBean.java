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


    public void add(@NonNull Product product) {
        addEntity(product);
    }

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
        //return entityManager.find(Product.class, productId);
    }

    @Override
    public void remove(String productId) {
        //products.remove(productId);
    }

    @Override
    public void merge(Product product) {
        //products.put(product.getId(), product);
        //entityManager.persist(product);
        addEntity(product);
    }
}
