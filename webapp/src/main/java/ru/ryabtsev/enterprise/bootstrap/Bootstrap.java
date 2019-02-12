package ru.ryabtsev.enterprise.bootstrap;

import ru.ryabtsev.enterprise.entity.User;
import ru.ryabtsev.enterprise.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

@Startup
@Singleton
public class Bootstrap {

    public static final Logger LOGGER = Logger.getLogger(Bootstrap.class.getSimpleName());

    @Inject
    private UserService userService;

    @PostConstruct
    private void start() {
        LOGGER.info("** APPLICATION START **");
        userService.init("customer", "user@mail.mil", "qwerty", User.AccessLevel.CUSTOMER);
        userService.init("administrator", "admin@mail.gov", "qwerty", User.AccessLevel.ADMINISTRATOR);
    }

    @PreDestroy
    private void stop() {
        LOGGER.info("** APPLICATION STOP **");
    }
}
