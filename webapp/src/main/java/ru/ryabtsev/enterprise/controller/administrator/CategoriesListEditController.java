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

@Named("categoryController")
@ViewScoped
@ManagedBean
@URLMapping(
        id="category-edit",
        pattern="/category-edit",
        viewId = "/WEB-INF/faces/category-edit.xhtml"
)
public class CategoriesEditController implements Serializable {

    @Inject
    private CategoryRepository categoryRepository;

    @NotNull
    private List<Category> categoriesList = new ArrayList<>();

    @PostConstruct
    private void init() {
        reload();
    }

    public void reload() {
        categoriesList.clear();
        categoriesList.addAll(categoryRepository.getAll());
    }

    @NotNull
    public List<Category> getCategories() {
        return categoriesList;
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
        categoriesList.add(product);
    }

    public String addNew() {
        final Category category = new Category();
        categoryRepository.persist(category);
        Category fromRepository = categoryRepository.get(category.getId());
        if(fromRepository != null) {
            return "product-edit?id=" + category.getId();
        }
        else {
            System.out.println("Can't find persisted object.");
            return "catalog-show";
        }
    }
}
