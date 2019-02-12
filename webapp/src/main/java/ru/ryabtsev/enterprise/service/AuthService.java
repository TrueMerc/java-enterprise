package ru.ryabtsev.enterprise.service;

import org.jetbrains.annotations.NotNull;
import ru.ryabtsev.enterprise.entity.User;
import ru.ryabtsev.enterprise.field.FieldKeys;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

@Named("authService")
@RequestScoped
public class AuthService {

    private static final Logger LOGGER = Logger.getLogger(AuthService.class.getSimpleName());

    @Inject
    private HttpServletRequest request;

    @Inject
    private UserService userService;

    public boolean openSession(final String login, final String password) {
        LOGGER.warning("Trying to open session with " + login + ", " + password);
        final boolean check = userService.check(login, password);
        if(!check) {
            LOGGER.warning("User service decline authentificatoin.");
            return false;
        }

        final User user = userService.getUser(login);
        if(user == null) {
            LOGGER.warning("User service can't find user.");
            return false;
        }
        final HttpSession httpSession = request.getSession();
        httpSession.setAttribute(FieldKeys.USER_ID, user.getId());
        httpSession.setAttribute(FieldKeys.LOGIN, user.getLogin());
        LOGGER.warning("Open session returns true.");
        return true;
    }

    public void closeSession() {
        request.getSession().invalidate();
    }

    @NotNull
    public String getLogin() throws AuthException {
        return getField(FieldKeys.LOGIN);
    }

    private String getField(String key) throws AuthException {
        final HttpSession httpSession = request.getSession();
        if(httpSession == null) throw new AuthException();
        final Object value = httpSession.getAttribute(key);
        if(value == null) throw new AuthException();
        return (String)value;
    }

    @NotNull
    public String getUserId() throws AuthException {
        return getField(FieldKeys.USER_ID);
    }

    public boolean isAuth() {
        final HttpSession httpSession = request.getSession();
        return isAuth(httpSession);
    }

    public static boolean isAuth(HttpSession httpSession) {
        if(httpSession == null) return false;
        final boolean hasLogin = httpSession.getAttribute(FieldKeys.LOGIN) != null;
        final boolean hasUserId = httpSession.getAttribute(FieldKeys.USER_ID) != null;
        return hasLogin && hasUserId;
    }

}
