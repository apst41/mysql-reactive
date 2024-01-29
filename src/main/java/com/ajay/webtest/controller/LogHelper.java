package com.ajay.webtest.controller;

import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

import java.util.logging.Level;



public class LogHelper<T>  {
    public final Mono<T> logInfoLevel(Mono<T> mono,@Nullable String category) {
        return mono.log(category, Level.INFO);
    }

}
