package ru.ryabtsev.enterprise.repository;

import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.OrderRepository;
import ru.ryabtsev.enterprise.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;

/**
 * Bean for orders repository manipulation.
 */
@ApplicationScoped
public class OrderRepositoryBean extends AbstractRepository implements OrderRepository {

    @Override
    public Collection<Order> getAll() {
        return null;
    }

    @Nullable
    @Override
    public Order get(String productId) {
        return null;
    }

    @Override
    public void merge(Order item) {

    }

    @Override
    public void persist(Order item) {

    }

    @Override
    public void remove(String productId) {

    }
}
