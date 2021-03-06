package ru.ryabtsev.enterprise.controller.administrator;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.CategoryRepository;
import ru.ryabtsev.enterprise.entity.Category;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("categoriesListController")
@ViewScoped
@ManagedBean
@URLMapping(
        id="admin-categories-list-edit",
        pattern="/admin-categories-list-edit",
        viewId = "/WEB-INF/faces/admin-categories-list-edit.xhtml"
)
public class CategoriesListEditController implements Serializable {

    @Inject
    private CategoryRepository categoryRepository;

    @NotNull
    private List<Category> categories = new ArrayList<>();


    @PostConstruct
    private void init() {
        reload();
    }

    public void reload() {
        categories.clear();
        categories.addAll(categoryRepository.getAll());
    }

    @NotNull
    public List<Category> getCategories() {
        return categories;
    }


    /**
     * Returns product with given productId if it exists or null if it isn't.
     * @param productId product id.
     * @return product with given productId if it exists or null if it isn't.
     */
    @Nullable
    public Category get(String productId) {
        return categoryRepository.get(productId);
    }

    /**
     * Removes product with given identifier.
     * @param productId identifier of product which should be deleted.
     */
    public void remove(String productId) {
        categoryRepository.remove(productId);
        reload();
    }

    public void merge(Category product) {
        categoryRepository.merge(product);
        categories.add(product);
    }

    public String addNew() {
        final Category category = new Category();
        categoryRepository.persist(category);
        Category fromRepository = categoryRepository.get(category.getId());
        if(fromRepository != null) {
            return "admin-category-edit?id=" + category.getId();
        }
        else {
            System.out.println("Can't find persisted object.");
            return "admin-categories-list-edit";
        }
    }
}
