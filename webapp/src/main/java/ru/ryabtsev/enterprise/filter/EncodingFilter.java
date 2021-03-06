package ru.ryabtsev.enterprise.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Adds UTF-8 encoding information to each response.
 */
@WebFilter(filterName="EncodingFilter", urlPatterns="/*")
public class EncodingFilter implements Filter {

    private static final String RESPONSE_CONTENT_ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding(RESPONSE_CONTENT_ENCODING);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

