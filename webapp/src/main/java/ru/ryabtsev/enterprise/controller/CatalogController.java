package ru.ryabtsev.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
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
}
