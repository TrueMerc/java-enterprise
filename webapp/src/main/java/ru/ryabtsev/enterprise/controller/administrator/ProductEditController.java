package ru.ryabtsev.enterprise.controller.administrator;

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
@Named("productEditController")
@ViewScoped
@ManagedBean
@URLMapping(
        id = "admin-product-edit",
        pattern = "/admin-product-edit",
        viewId = "/WEB-INF/faces/admin-product-edit.xhtml"
)
public class ProductEditController implements Serializable {

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
        return "admin-catalog-edit";
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
