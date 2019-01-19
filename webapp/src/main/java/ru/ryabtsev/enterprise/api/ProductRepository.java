package ru.ryabtsev.enterprise.api;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Provides interface for repository which contains products list.
 */
public interface ProductRepository {

    /**
     * Adds given product in repository.
     * @param product product.
     */
    void add(@NonNull Product product);

    /**
     * Returns collection which contains all products from repository.
     * @return
     */
    @NonNull
    Collection<Product> getAll();

    /**
     * Returns product by its id.
     * @param productId product id.
     * @return product by its id
     */
    @Nullable
    Product get(String productId);

    /**
     * Removes product with given id from repository.
     * @param productId product id.
     */
    void remove(String productId);
}
