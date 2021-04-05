package com.sachinjhamb.micronaut;

import com.sachinjhamb.micronaut.config.GreetingsConfig;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("${hello.controller.path}")
public class HelloWorldController {

    private HelloWorldService service;
    private GreetingsConfig config;
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);


    public HelloWorldController(final HelloWorldService service, final GreetingsConfig config){
        log.info("Creating HelloWorldController");
        this.service=service;
        this.config=config;
    }

    @Get("/")
    public String index()
    {
        return service.sayHi();
    }

    @Get("/de")
    public String greetInDe()
    {
        return config.getDe();
    }

    @Get("/en")
    public String greetInEn()
    {
        return config.getEn();
    }
}
