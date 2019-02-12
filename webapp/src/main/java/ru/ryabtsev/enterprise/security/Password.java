package ru.ryabtsev.enterprise.security;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Stores user password and generates hash code when it is necessary.
 */
public class Password {

    private String hashCode;

    /**
     * Constructs new 'Password' instance.
     * @param password password string.
     */
    @SneakyThrows
    public Password(@NotNull final String password) {
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        final byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        final byte[] hex = messageDigest.digest(bytes);
        hashCode = DatatypeConverter.printHexBinary(hex);
    }

    /**
     * Constructs new 'Password' instance.
     * @param password password string.
     * @param mixture additional string to mix MD5 hash code.
     */
    public Password(@NotNull final String password, @NotNull String mixture) {
        //this.password = password;
        this(password);
    }

    /**
     * Returns MD5 hash code.
     * @return MD5 hash code
     */
    public String getHashCode() {
        return hashCode;
    }
}
