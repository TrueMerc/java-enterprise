package ru.ryabtsev.enterprise.servlet.product;

import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "product-add")
public class ProductAddServlet extends HttpServlet {

    @Inject
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/product-add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String result = request.getParameter("result");
        if(result != null) {
            if( Integer.parseInt(result) != 0 ) {
                final String name = request.getParameter("nameField");
                System.out.println("name: " + name);
                final String priceString = request.getParameter("priceField");
                System.out.println("price " + priceString);
                float price = Float.parseFloat(priceString);
                if(name != null && !name.isEmpty() && price != 0.f) {
                    final String description = request.getParameter("descriptionField");
                    Product product = (description != null) ?
                            new Product(name, price, description) :
                            new Product(name, price);
                    productRepository.add(product);
                }
            }
        }
        response.sendRedirect("catalog");
    }
}
