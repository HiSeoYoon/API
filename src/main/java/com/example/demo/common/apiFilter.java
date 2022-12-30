package com.example.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(urlPatterns= "/*")
public class apiFilter implements Filter {
    protected static final Logger log = LoggerFactory.getLogger(apiFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        String requestURI = req.getRequestURI();

        log.info("---Request(" + requestURI + ") Filter---");
        log.info("Request : " + messageBody);
        chain.doFilter(request, response);
        log.info("---Response(" + requestURI + ") Filter---");

    }
}
