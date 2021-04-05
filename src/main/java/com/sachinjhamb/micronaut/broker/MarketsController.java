package com.sachinjhamb.micronaut.broker;

import com.sachinjhamb.micronaut.broker.model.Symbol;
import com.sachinjhamb.micronaut.broker.store.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/markets")
public class MarketsController {

    private InMemoryStore service;
    private static final Logger log = LoggerFactory.getLogger(MarketsController.class);


    public MarketsController(final InMemoryStore service){
        log.info("Creating MarketsController");
        this.service=service;
    }

    @Get("/")
    public List<Symbol> index()
    {

        return service.getAllSymbols();
    }

}
