package ru.ryabtsev.enterprise.api;


import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Provides CRUD operations interface for repositories
 * which use UUID as primary key.
 */
public interface UuidBasedRepository<ItemType> {

    /**
     * Creates new element in repository.
     */
    @NotNull
    ItemType create();

    /**
     * Returns collection which contains all products from repository.
     * @return
     */
    @NonNull
    Collection<ItemType> getAll();

    /**
     * Returns product by its id.
     * @param productId product id.
     * @return product by its id
     */
    @Nullable
    ItemType get(String productId);

    /**
     * Merges product into products repository.
     */
    void merge(final ItemType item);


    /**
     * Persists product into products repository.
     */
    void persist(final ItemType item);

    /**
     * Removes item with given id from repository.
     * @param productId product id.
     */
    void remove(String productId);
}
