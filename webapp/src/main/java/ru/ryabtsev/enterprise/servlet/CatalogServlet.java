package ru.ryabtsev.enterprise.servlet;

import ru.ryabtsev.enterprise.entity.Product;
import ru.ryabtsev.enterprise.field.FieldKeys;
import ru.ryabtsev.enterprise.repository.ProductRepositoryBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Catalog page servlet.
 */
@WebServlet(urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    @Inject
    private ProductRepositoryBean productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Collection<Product> products = productRepository.getAll();
        req.setAttribute(FieldKeys.PRODUCTS, products);
        req.getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(req, resp);
    }
}
