package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;

import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.entity.Product;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

/**
 * Bean for products repository manipulation.
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
        if(productId == null || productId.isEmpty()) {
            System.out.println("Unexpected situation!!!");
        }
        super.doRemove(get(productId));
    }

    @Override
    public void merge(Product product) {
        super.doMerge(product);
    }

    @Override
    public void persist(Product product) {
        super.doPersist(product);
    }
}
