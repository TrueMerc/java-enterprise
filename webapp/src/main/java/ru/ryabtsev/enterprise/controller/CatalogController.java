package ru.ryabtsev.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.entity.Product;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
@Named("catalogController")
@ViewScoped
@ManagedBean
@URLMapping(
        id="catalog-show",
        pattern="/catalog-show",
        viewId = "/WEB-INF/faces/catalog-show.xhtml"
)
public class CatalogController implements Serializable {

    @Inject
    private ProductRepository productRepository;

    @NotNull
    private List<Product> productList = new ArrayList<>();

    @PostConstruct
    private void init() {
        reload();
    }

    private void reload() {
        productList.clear();
        productList.addAll(productRepository.getAll());
    }

    @NotNull
    public List<Product> getProducts() {
        return productList;
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
        productList.add(product);
    }

    @NotNull
    public String addNew() {
        Product product = new Product();
        productList.add(product);
        return "product-edit?id=" + product.getId();
    }
}
