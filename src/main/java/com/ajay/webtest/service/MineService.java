package com.ajay.webtest.service;

import com.ajay.webtest.model.Mine;
import com.ajay.webtest.repository.MineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MineService {

    @Autowired
    MineRepository mineRepository;
    public Mono<Mine> save(Mine mine){
        return mineRepository.save(mine);
    }

    public Mono<Mine> findByName(String name){
        return mineRepository.findByName(name);
    }

}
