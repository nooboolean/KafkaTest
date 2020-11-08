package com.example.kafkaProducerTest.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestSerializerDomain {
    private long userId;
    private String name;
    private String note;
}
