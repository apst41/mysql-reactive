package com.ajay.webtest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "mine")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Mine {
    @Id
    private Long id;

    private String name;

    private Long age;
}
