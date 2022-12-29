package com.example.demo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class preFilter extends OncePerRequestFilter {
    protected static final Logger log = LoggerFactory.getLogger(preFilter.class);
    private final ObjectMapper objectMapper;

    public preFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        log.info("init MyFilter");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String queryString = request.getQueryString();
        final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;

        log.info("Request : {} uri=[{}] content-type=[{}] body=[{}]",
                request.getMethod(),
                queryString == null ? request.getRequestURI() : request.getRequestURI() + queryString,
                request.getContentType(),
                objectMapper.readTree(cachingRequest.getContentAsByteArray())
        );
    }
}
