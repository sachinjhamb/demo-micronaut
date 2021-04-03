package com.sachinjhamb.micronaut;

import com.sachinjhamb.micronaut.config.GreetingsConfig;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("${hello.controller.path}")
public class HelloWorldController {

    private HelloWorldService service;
    private GreetingsConfig config;

    public HelloWorldController(final HelloWorldService service, final GreetingsConfig config){
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
