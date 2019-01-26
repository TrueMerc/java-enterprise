package ru.ryabtsev.enterprise.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents customers orders.
 */
@Entity
@Table(name = "app_Order")
public class Order extends AbstractEntity {
}
