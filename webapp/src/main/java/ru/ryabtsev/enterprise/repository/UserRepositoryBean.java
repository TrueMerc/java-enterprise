package ru.ryabtsev.enterprise.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.UserRepository;
import ru.ryabtsev.enterprise.entity.Product;
import ru.ryabtsev.enterprise.entity.User;

import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Bean for user repository manipulation.
 */
@Stateless
public class UserRepositoryBean extends AbstractRepository implements UserRepository {

    @NotNull
    @Override
    public User create() {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Nullable
    @Override
    public User get(String userId) {
        if(userId == null || userId.isEmpty() ) return null;
        return getEntity(
                entityManager.createQuery("SELECT u FROM User p WHERE u.id = :id", User.class)
                        .setParameter("id", userId)
                        .setMaxResults(1)
        );
    }

    @Nullable
    @Override
    public User getByLogin(final String login) {
        if(login == null || login.isEmpty() ) return null;
        return getEntity(
                entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
                        .setParameter("login", login)
                        .setMaxResults(1)
        );
    }

    @Nullable
    @Override
    public User getByEmail(final String email) {
        if(email == null || email.isEmpty() ) return null;
        return getEntity(
                entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                        .setParameter("email", email)
                        .setMaxResults(1)
        );
    }

    @Override
    public boolean isLoginUnique(@Nullable final String login) {
        if(login == null || login.isEmpty()) return false;
        return entityManager.createQuery("SELECT COUNT(u.id) FROM User u WHERE u.login = :login", Long.class)
                .setParameter("login", login).setMaxResults(1).getSingleResult().equals(0L);
    }

    @Override
    public boolean isEmailUnique(String email) {
        if(email == null || email.isEmpty()) return false;
        return entityManager.createQuery("SELECT COUNT(u.id) FROM User u WHERE u.email = :email", Long.class)
                .setParameter("email", email).setMaxResults(1).getSingleResult().equals(0L);
    }

    @Override
    public void merge(final User user) {
        super.doMerge(user);
    }

    @Override
    public void persist(final User user) {
        super.doPersist(user);
    }

    @Override
    public void remove(String userId) {
        final User user = get(userId);
        if(user != null) {
            super.doRemove(user);
        }
    }
}
