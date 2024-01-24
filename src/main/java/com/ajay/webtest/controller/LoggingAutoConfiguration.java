package com.ajay.webtest.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.ajay.webtest"})
@ConditionalOnWebApplication(
        type = ConditionalOnWebApplication.Type.REACTIVE
)
public class LoggingAutoConfiguration {
    public LoggingAutoConfiguration() {
    }
}
