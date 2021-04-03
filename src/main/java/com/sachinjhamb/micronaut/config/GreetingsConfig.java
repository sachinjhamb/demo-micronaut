package com.sachinjhamb.micronaut.config;

import io.micronaut.context.annotation.ConfigurationInject;
import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("hello.config.greeting")
public class GreetingsConfig {

    @Getter
    private final String en;
    @Getter
    private final String de;

    @ConfigurationInject
    public GreetingsConfig(@NotBlank final String en, @NotBlank final String de) {
        this.en = en;
        this.de = de;
    }
}
