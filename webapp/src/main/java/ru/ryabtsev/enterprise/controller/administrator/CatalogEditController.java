package ru.ryabtsev.enterprise.controller.administrator;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.entity.Product;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("catalogEditController")
@ViewScoped
@ManagedBean
@URLMapping(
        id="admin-catalog-edit",
        pattern="/admin-catalog-edit",
        viewId = "/WEB-INF/faces/admin-catalog-edit.xhtml"
)
public class CatalogEditController implements Serializable {

    @Inject
    private ProductRepository productRepository;

    @NotNull
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    private void init() {
        reload();
    }

    /**
     * Reloads data from remote repository.
     */
    public void reload() {
        products.clear();
        products.addAll(productRepository.getAll());
    }

    /**
     * Returns list of all products which database contains.
     * @return list of all products which database contains.
     */
    @NotNull
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Returns product with given productId if it exists or null if it isn't.
     * @param productId product id.
     * @return product with given productId if it exists or null if it isn't.
     */
    @Nullable
    public Product get(String productId) {
        return productRepository.get(productId);
    }

    /**
     * Removes product with given identifier.
     * @param productId identifier of product which should be deleted.
     */
    public void remove(String productId) {
        productRepository.remove(productId);
        reload();
    }

    public void merge(Product product) {
        productRepository.merge(product);
        products.add(product);
    }

    public String addNew() {
        final Product product = new Product();
        productRepository.persist(product);
        Product fromRepository = productRepository.get(product.getId());
        if(fromRepository != null) {
            return "admin-product-edit?id=" + product.getId();
        }
        else {
            System.out.println("Can't find persisted object.");
            return "admin-catalog-edit";
        }
    }
}
