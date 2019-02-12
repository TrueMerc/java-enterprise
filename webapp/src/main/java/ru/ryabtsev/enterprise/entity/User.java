package ru.ryabtsev.enterprise.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents user entity in 'Simple shop' web application.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="app_User")
public class User extends AbstractEntity {

    /**
     * Represents user access level.
     */
    public enum AccessLevel {
        CUSTOMER,
        ADMINISTRATOR
    }

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private AccessLevel accessLevel;
}
