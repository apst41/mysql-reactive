package com.ajay.webtest.controller;

import org.reactivestreams.Subscription;
import org.slf4j.MDC;
import reactor.core.CoreSubscriber;
import reactor.util.context.Context;

import java.util.Map;
final  class MDCContextLifter<T> implements CoreSubscriber<T> {
    private final CoreSubscriber<T> coreSubscriber;

    public void onNext(T t) {
        this.setMdcContextOrClear();
        this.coreSubscriber.onNext(t);
    }

    public void onSubscribe(Subscription s) {
        this.setMdcContextOrClear();
        this.coreSubscriber.onSubscribe(s);
    }

    public void onComplete() {
        this.setMdcContextOrClear();
        this.coreSubscriber.onComplete();
    }

    public void onError(Throwable t) {
        this.setMdcContextOrClear();
        this.coreSubscriber.onError(t);
    }

    public Context currentContext() {
        return this.coreSubscriber.currentContext();
    }

    private void setMdcContextOrClear() {
        Context context = this.currentContext();
        if (!context.isEmpty() && context.hasKey("correlation-id")) {
            MDC.setContextMap(Map.of("correlation-id", (String)context.get("correlation-id")));
        } else {
            MDC.clear();
        }

    }

    public MDCContextLifter(final CoreSubscriber<T> coreSubscriber) {
        this.coreSubscriber = coreSubscriber;
    }
}
