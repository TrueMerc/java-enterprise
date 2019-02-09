package ru.ryabtsev.enterprise.controller.administrator;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.CategoryRepository;
import ru.ryabtsev.enterprise.entity.Category;
import ru.ryabtsev.enterprise.entity.Product;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controls category edition process.
 */
@Named("categoryEditController")
@ViewScoped
@ManagedBean
@URLMapping(
        id = "admin-category-edit",
        pattern = "/admin-category-edit",
        viewId = "/WEB-INF/faces/admin-category-edit.xhtml"
)
public class CategoryEditController implements Serializable {
    @Inject
    private CategoryRepository categoryRepository;

    @Nullable
    private String categoryId;

    @NotNull
    private Category category = new Category();

    /**
     * Initializes category edition controller.
     */
    public void init() {
        @Nullable final Category category = categoryRepository.get(categoryId);
        if(category != null) this.category = category;
    }

    /**
     * Saves category changes.
     */
    public String save() {
        categoryRepository.merge(category);
        return "admin-categories-list-edit";
    }


    /**
     * Returns category which should be edited.
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Sets category which should be edited.
     */
    public void setCategory(@NotNull final Category category) {
        this.category = category;
    }

    /**
     * Returns category identifier.
     */
    public String getId() {
        return categoryId;
    }

    /**
     * Sets category identifier to new value.
     * @param productId new value of the category identifier.
     */
    public void setId(@Nullable final String productId) {
        this.categoryId = productId;
    }
}
