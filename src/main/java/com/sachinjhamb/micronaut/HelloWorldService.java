package com.sachinjhamb.micronaut;

import io.micronaut.context.annotation.Value;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class HelloWorldService {

    @Value("${hello.service.greeting}")
    private String greetings;

    private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

    @EventListener
    public void onAppStart(StartupEvent startupEvent){
        log.debug("Application Starting...");
    }

    public String sayHi(){
        return greetings;
    }
}
