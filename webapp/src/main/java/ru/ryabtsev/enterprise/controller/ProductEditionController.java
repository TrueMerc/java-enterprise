package ru.ryabtsev.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.entity.Product;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controls product edition process.
 */
@Named("productEditionController")
@ViewScoped
@ManagedBean
@URLMapping(
        id = "product-edit",
        pattern = "/product-edit",
        viewId = "/WEB-INF/faces/product-edit.xhtml"
)
public class ProductEditionController implements Serializable {

    @Inject
    private ProductRepository productRepository;

    @Nullable
    private String productId;

    @NotNull
    private Product product = new Product();

    /**
     * Initializes product edition controller.
     */
    public void init() {
        @Nullable final Product product = productRepository.get(productId);
        if(product != null) this.product = product;
    }

    /**
     * Saves product changes.
     */
    public String save() {
        productRepository.merge(product);
        return "catalog-show";
    }


    /**
     * Returns product which should be edited.
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Sets product which should be edited.
     */
    public void setProduct(@NotNull final Product product) {
        this.product = product;
    }

    /**
     * Returns product identifier.
     */
    public String getId() {
        return productId;
    }

    /**
     * Sets product identifier to new value.
     * @param productId new value of the product identifier.
     */
    public void setId(@Nullable final String productId) {
        this.productId = productId;
    }
}
