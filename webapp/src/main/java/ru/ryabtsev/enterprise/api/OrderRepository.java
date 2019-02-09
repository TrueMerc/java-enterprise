package ru.ryabtsev.enterprise.api;

import ru.ryabtsev.enterprise.entity.Order;

/**
 * Provides interface for repository which contains orders list.
 */
public interface OrderRepository extends UuidBasedRepository<Order>  {
}
