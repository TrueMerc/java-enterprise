package ru.ryabtsev.enterprise.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

/**
 * Represents product entity in 'Simple shop' web application.
 */
@Entity
@Table(name="app_Product")
@Getter
@Setter
public class Product extends AbstractEntity {

    @NonNull
    private String name;

    private
    float price;

    @Nullable
    @Column(columnDefinition = "TEXT")
    private String description;

    @Nullable
    @ManyToOne(targetEntity = Category.class)
    private Category category;

    /**
     * Create new product without any attributes.
     */
    public Product() {
        this("ProductName", 0f);
    }

    /**
     * Creates new product without description.
     * @param name the name of this product.
     * @param price the price of this product.
     */
    public Product(@NonNull final String name, float price) {
        this.name = name;
        this.price = price;
        this.description = null;
        this.category = null;
    }

    /**
     * Creates new product without description.
     * @param name the name of this product.
     * @param price the price of this product.
     * @param description the description of this product.
     */
    public Product(@NonNull final String name, float price, @NonNull String description) {
        this(name, price);
        setDescription(description);
    }

    /**
     * Returns product category name if this name specified.
     */
    public String getCategoryName() {
        return category != null ? category.getName() : "Unspecified";
    }
}
