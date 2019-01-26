package ru.ryabtsev.enterprise.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Represents abstract web application entity.
 */
@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @NonNull
    @Id
    private final String id = UUID.randomUUID().toString();
}
