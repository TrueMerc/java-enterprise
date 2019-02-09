package ru.ryabtsev.enterprise.controller.customer;

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

@Named("catalogShowController")
@ViewScoped
@ManagedBean
@URLMapping(
        id="catalog-show",
        pattern="/catalog-show",
        viewId = "/WEB-INF/faces/catalog-show.xhtml"
)
public class CustomerCatalogController implements Serializable {

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
}
