package com.ajay.webtest.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Operators;

@Configuration
@ConditionalOnWebApplication(
        type = Type.REACTIVE
)
public class ReactorLoggingHookConfig {
    private static final String MDC_HOOK_KEY = "mdc";

    public ReactorLoggingHookConfig() {
    }

    @PostConstruct
    void contextOperatorHook() {
        Hooks.onEachOperator("mdc", Operators.lift(($, coreSubscriber) -> new MDCContextLifter(coreSubscriber)));
    }

    @PreDestroy
    void cleanupHook() {
        Hooks.resetOnEachOperator("mdc");
    }
}

