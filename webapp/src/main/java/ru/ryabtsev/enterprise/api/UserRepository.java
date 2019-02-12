package ru.ryabtsev.enterprise.api;

import jdk.internal.jline.internal.Nullable;
import ru.ryabtsev.enterprise.entity.User;

/**
 * Interface for users data repository.
 */
public interface UserRepository extends UuidBasedRepository<User> {

    @Nullable
    User getByLogin(final String login);

    @Nullable
    User getByEmail(final String email);

    boolean isLoginUnique(@Nullable final String login);

    boolean isEmailUnique(@Nullable final String email);
}
