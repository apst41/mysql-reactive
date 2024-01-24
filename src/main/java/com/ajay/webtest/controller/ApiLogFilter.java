package com.ajay.webtest.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.slf4j.MDC;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Configuration
@ConditionalOnWebApplication(
        type = ConditionalOnWebApplication.Type.REACTIVE
)
public class ApiLogFilter implements WebFilter {
    public ApiLogFilter() {
    }

    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        List<String> headers = exchange.getRequest().getHeaders().get("correlation-id");
        String correlationId = (String) Optional.ofNullable((String) CollectionUtils.firstElement(headers)).orElseGet(() -> {
            return UUID.randomUUID().toString();
        });
        MDC.put("correlation-id", correlationId);
        return chain.filter(exchange).contextWrite((context) -> {
            return context.put("correlation-id", correlationId);
        }).doFinally((data) -> {
            MDC.remove("correlation-id");
        });
    }
}

