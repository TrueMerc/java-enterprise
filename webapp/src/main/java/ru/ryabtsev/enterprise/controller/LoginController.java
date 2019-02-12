package ru.ryabtsev.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.ryabtsev.enterprise.service.AuthService;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Controls 'log in' procedure.
 */
@Named("loginController")
@Getter
@Setter
@ViewScoped
@ManagedBean
@URLMapping(
        id = "login",
        pattern = "/login",
        viewId = "/WEB-INF/faces/login.xhtml")
public class LoginController implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getSimpleName());

    @NotNull
    private String login = "";

    @NotNull
    private String password = "";

    @Inject
    private AuthService authService;

    @NotNull
    public String authenticate() {
        final boolean checkPassed = authService.openSession(login, password);
        LOGGER.warning("Authentication is passed: " + checkPassed);
        return checkPassed ? "admin" : "login";
    }
}