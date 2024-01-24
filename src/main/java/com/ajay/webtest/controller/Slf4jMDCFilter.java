package com.ajay.webtest.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)

public class Slf4jMDCFilter implements WebFilter {

    private final String correlationId ="correlation-id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        final String token;
        if (exchange.getRequest().getHeaders().containsKey(correlationId)) {
            token = exchange.getRequest().getHeaders().getFirst(correlationId);
        } else {
            token = java.util.UUID.randomUUID().toString().toUpperCase().replace("-", "");
        }

        MDC.put(correlationId, token);


        if (exchange.getRequest().getHeaders().containsKey(correlationId)) {
            exchange.getResponse().getHeaders().add(correlationId, token);
        }

        return chain.filter(exchange).doFinally(success -> {
            MDC.remove(correlationId);
        });
    }
}
