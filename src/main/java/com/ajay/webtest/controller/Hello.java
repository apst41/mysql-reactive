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

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
public class Hello {
    @Autowired
    MineService mineService;

    @Autowired
    HelloService helloService;

    @PostMapping("/mine")
    public Mono<Mine> save(@RequestBody Mine mine){
     return mineService.save(mine);
    }

    @PostMapping("/getAge")
    public Flux<Mine> save(@RequestBody List<Long> list){
        return mineService.findByAge(list);
    }

   @GetMapping("/mine/{name}")
    public Mono<Mine> findByName(@PathVariable  String name){
        return mineService.findByName(name);
   }

}
