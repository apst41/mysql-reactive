package com.ajay.webtest.controller;

import com.ajay.webtest.dtos.TestOptionalDtos;
import com.ajay.webtest.model.Mine;
import com.ajay.webtest.service.HelloService;
import com.ajay.webtest.service.MineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.util.annotation.Nullable;

import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;


@RestController
@Slf4j
public class Hello {
    @Autowired
    MineService mineService;

    @Autowired
    HelloService helloService;




    @Autowired
    Gsonhelper gsonhelper;

    @PostMapping("/mine")
    public Mono<Mine> save(@RequestBody Mine mine){
     return mineService.save(mine);
    }

    @PostMapping("/getAge")
    public Flux<Mine> save(@RequestBody List<Long> list){
        log.info("fetching result");
        return mineService.findByAge(list);
    }

   @GetMapping("/mine/{name}")
    public Mono<Mine> findByName(@PathVariable  String name){
       log.info("fetched result");
        return   mineService.findByName(name).log("meow",Level.INFO);
   }

   @GetMapping
    public Mono<String> hello(){
        return Mono.just("hello");

   }


}
