package com.ajay.webtest.service;

import com.ajay.webtest.dtos.TestOptionalDtos;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    public   TestOptionalDtos helloData(TestOptionalDtos dtos){
        dtos.getName().ifPresentOrElse(
                value
                        -> dtos.setName(Optional.of("value is present")),
                ()
                        -> dtos.setName(Optional.of("Value is not present")));

        return dtos;
    }

    }
