package com.ajay.webtest.repository;

import com.ajay.webtest.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Repository
public interface MineRepository extends R2dbcRepository<Mine,Long> {
    Mono<Mine>  findByName(String name);

    Flux<Mine> findByAgeIn(List<Long> age);
}
