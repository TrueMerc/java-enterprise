package ru.ryabtsev.enterprise.entity;

import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents product entity in 'Simple shop' web application.
 */
@Getter
public class Product extends AbstractEntity {

    @NonNull private String name;
    @NonNull private float price;
    @Nullable private String description;

    /**
     * Creates new product without description.
     * @param name the name of this product.
     * @param price the price of this product.
     */
    Product(@NonNull String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Creates new product without description.
     * @param name the name of this product.
     * @param price the price of this product.
     * @param description the description of this product.
     */
    Product(@NonNull String name, float price, @NonNull String description) {
        this(name, price);
        setDescription(description);
    }

    /**
     * Sets product description.
     * @param description the description of this product.
     */
    void setDescription(@NonNull String description) {
        this.description = description;
    }

}
