package ru.ryabtsev.enterprise.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents product category.
 */
@Entity
@Table(name = "app_Category")
@Getter
@Setter
public class Category extends AbstractEntity  {

    private static final String DEFAULT_NAME = "Cathegory name";
    private static final String DEFAULT_DESCRIPTION = "Cathegory description";

    @NotNull
    private String name;

    @NotNull
    private String description;

    /**
     * Constructs new category with given name and description.
     */
    Category(@NotNull final String name, @NotNull final String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructs new category with default name and description.
     */
    Category() {
        this(DEFAULT_NAME, DEFAULT_DESCRIPTION);
    }
}
