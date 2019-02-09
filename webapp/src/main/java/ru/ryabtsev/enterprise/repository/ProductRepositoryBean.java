package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.controller.LogInterceptor;
import ru.ryabtsev.enterprise.entity.Product;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.*;

/**
 * Bean for products repository manipulation.
 */
@Stateless
@Interceptors({LogInterceptor.class})
public class ProductRepositoryBean extends AbstractRepository implements ProductRepository {

    @NotNull
    @Override
    public Product create() {
        Product product = new Product();
        super.doPersist(product);
        return product;
    }

    @Override


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
        final Product product = this.get(productId);
        if( product != null) {
            super.doRemove(product);
        }
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
