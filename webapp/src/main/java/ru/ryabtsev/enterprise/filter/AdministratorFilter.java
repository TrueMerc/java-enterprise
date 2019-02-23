package ru.ryabtsev.enterprise.filter;

import ru.ryabtsev.enterprise.service.AuthService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/admin*")
public class AdministratorFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(AdministratorFilter.class.getSimpleName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new ServletException();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.warning("Administration filter started. ");
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpSession httpSession = request.getSession();
        final boolean isAuth = AuthService.isAuth(httpSession);
        LOGGER.warning("Authentification accepted by filter: " + isAuth);
        if( isAuth ) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            LOGGER.warning("Authentification failed. Redirect to login page.");
            response.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {}
}
