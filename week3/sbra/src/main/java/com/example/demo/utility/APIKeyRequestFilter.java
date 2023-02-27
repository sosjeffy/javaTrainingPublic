package com.example.demo.utility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class APIKeyRequestFilter extends OncePerRequestFilter {
    // Note that it is not best practice to just have an API key hardcoded in here, but this is here for simplicity
    private final String API_KEY = "abc1234567890";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!request.getRequestURI().startsWith("/api")) {
            String error = "INVALID URI FOR REQUEST: must start with '/api'";
            response.reset();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentLength(error.length());
            response.getWriter().write(error);
            return;
        }

        if (request.getHeader("Authorization") != null && request.getHeader("Authorization").equals(API_KEY)) {
            filterChain.doFilter(request, response);
        } else {
            String error = "INVALID API KEY";
            response.reset();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentLength(error.length());
            response.getWriter().write(error);
        }
    }
}
