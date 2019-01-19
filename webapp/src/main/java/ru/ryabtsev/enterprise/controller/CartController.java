package ru.ryabtsev.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import ru.ryabtsev.enterprise.api.ProductRepository;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

@ViewScoped
@ManagedBean
@URLMapping(
        id="cart-edit",
        pattern="/cart-edit",
        viewId = "/WEB-INF/faces/cart-edit.xhtml"
)
public class CartController implements Serializable {

    @Inject
    private ProductRepository productRepository;

    public void init() {}
}
