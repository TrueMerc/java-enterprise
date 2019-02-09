package ru.ryabtsev.enterprise.controller.customer;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import ru.ryabtsev.enterprise.api.OrderRepository;
import ru.ryabtsev.enterprise.entity.Product;


import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("cartController")
@SessionScoped
@ManagedBean
@URLMapping(
        id="cart-edit",
        pattern="/cart-edit",
        viewId = "/WEB-INF/faces/cart-edit.xhtml"
)
public class CartController implements Serializable {

    @Inject
    private OrderRepository productRepository;

    @NotNull
    private List<Product> products = new ArrayList<>();

    @NotNull
    public List<Product> getProducts() { return products; }

    public void addProduct(@NotNull final Product product) {
        products.add(product);
    }

    public float getTotalPrice() {
        float result = 0;
        for (Product product: products ) {
            result += product.getPrice();
        }
        return result;
    }
}
