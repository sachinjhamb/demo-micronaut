package com.sachinjhamb.micronaut.broker;

import com.sachinjhamb.micronaut.broker.model.Symbol;
import com.sachinjhamb.micronaut.broker.store.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/markets")
public class MarketsController {

    private final InMemoryStore store;

    public MarketsController(final InMemoryStore store) {
        this.store = store;
    }

    @Get("/")
    private List<Symbol> all(){
        return store.getAllSymbols();
    }
}
