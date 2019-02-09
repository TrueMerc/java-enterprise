package ru.ryabtsev.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;

/**
 * Represents product category.
 */
@Entity
@Table(name = "app_Category")
@Getter
@Setter
public class Category extends AbstractEntity  {

    private static final String DEFAULT_NAME = "Category name";
    private static final String DEFAULT_DESCRIPTION = "Category description";

    @NotNull
    private String name;

    @NotNull
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")
    private List<Product> products;

    /**
     * Constructs new category with given name and description.
     */
    public Category(@NotNull final String name, @NotNull final String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructs new category with default name and description.
     */
    public Category() {
        this(DEFAULT_NAME, DEFAULT_DESCRIPTION);
    }
}
