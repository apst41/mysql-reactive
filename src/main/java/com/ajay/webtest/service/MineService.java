package com.ajay.webtest.service;

import com.ajay.webtest.model.Mine;
import com.ajay.webtest.repository.MineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Min;
import java.util.List;

@Service
@Slf4j
public class MineService {

    @Autowired
    MineRepository mineRepository;
    public Mono<Mine> save(Mine mine){
        return mineRepository.save(mine);
    }

    public Mono<Mine> findByName(String name){
        log.info("request Data");
        return mineRepository.findByName(name);
    }

    public Flux<Mine> findByAge(List<Long> age) {
    return mineRepository.findByAgeIn(age);
    }

}
