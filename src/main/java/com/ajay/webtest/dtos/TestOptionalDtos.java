package com.ajay.webtest.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
@Builder
public class TestOptionalDtos {
    Optional<String> name ;
    Optional<Integer> tame;
}
