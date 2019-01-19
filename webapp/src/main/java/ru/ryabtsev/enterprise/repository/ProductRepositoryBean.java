package ru.ryabtsev.enterprise.repository;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

/**
 * Bean for products repository.
 */
@ApplicationScoped
public class ProductRepositoryBean implements ProductRepository {

    @NonNull
    final private Map<String, Product> products = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        add(new Product("Butter", 1.f));
        add(new Product("Bread", 0.5f));
        add(new Product("Salt", 0.05f, "Salt... Simple salt."));
        add(new Product("Sparkling water", 0.75f));
        add(new Product("Meat", 2.f));
        add(new Product("Beans", 0.66f));
        add(new Product("Coffee", 1.5f));
        add(new Product("Tea", 1.2f));
        add(new Product("Apple juice", 1.7f));
    }

    public void add(@NonNull Product product) {
        products.put(product.getId(), product);
    }

    @NonNull
    public Collection<Product> getAll() {
        final List<Product> result = new ArrayList<>(products.size());
        for( Map.Entry<String, Product> productEntry: products.entrySet()) {
            result.add(productEntry.getValue());
        }
        return result;
    }

    @Nullable
    @Override
    public Product get(String productId) {
        return products.get(productId);
    }

    @Override
    public void remove(String productId) {
        products.remove(productId);
    }
}
