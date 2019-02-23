package ru.ryabtsev.enterprise.service;

import jdk.internal.jline.internal.Nullable;
import ru.ryabtsev.enterprise.api.UserRepository;
import ru.ryabtsev.enterprise.entity.User;
import ru.ryabtsev.enterprise.security.Password;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Implements user management service.
 */
@ApplicationScoped
public class UserService {

    public static final Logger LOGGER = Logger.getLogger(UserService.class.getSimpleName());

    @Inject
    UserRepository userRepository;

    @Nullable
    public User getUser(final String login) {
        return userRepository.getByLogin(login);
    }

    public void init(String login, String email, String password, User.AccessLevel accessLevel) {
        if(!userRepository.isLoginUnique(login)) return;
        if(!userRepository.isEmailUnique(email)) return;
        create(login, email, password, accessLevel);
    }

    public void create(String login, String email, String password, User.AccessLevel accessLevel) {
        if( login == null || login.isEmpty() ) return;
        if( email == null || email.isEmpty() ) return;
        if( password == null || password.isEmpty() ) return;
        final String passwordHash = new Password(password).getHashCode();
        final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(passwordHash);
        user.setEmail(email);
        user.setAccessLevel(accessLevel);
        userRepository.persist(user);
        LOGGER.info("User " + login + " was successfully created.");
    }

    public boolean check(final String login, final String password) {
        LOGGER.warning("Try to login with: " + login + ", " + password);
        if(login == null || login.isEmpty()) return false;
        if(password == null || password.isEmpty()) return false;
        final User user = userRepository.getByLogin(login);
        if(user == null) {
            LOGGER.warning("User not found in database." );
            return false;
        }

        final String passwordHash = new Password(password).getHashCode();
        return passwordHash.equals(user.getPasswordHash());
    }
}
