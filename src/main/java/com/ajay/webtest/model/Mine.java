package com.ajay.webtest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

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
