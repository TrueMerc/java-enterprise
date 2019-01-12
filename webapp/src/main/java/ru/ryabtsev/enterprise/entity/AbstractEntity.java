package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

/**
 * Represents abstract web application entity.
 */
@Data
public abstract class AbstractEntity {
    @NonNull
    private final String id = UUID.randomUUID().toString();
}
