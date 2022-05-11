package com.example;

import javax.annotation.Nullable;

import lombok.Builder;
import lombok.Getter;

/**
 * Model for a person.
 */
@Builder
public class Person {
    @Getter
    @Nullable
    private final String name;
    @Getter
    private final int age;
}
