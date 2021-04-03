package com.sachinjhamb.micronaut.broker.store;

import com.sachinjhamb.micronaut.broker.model.Symbol;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class InMemoryStore {

    private final List<Symbol> symbols;

    public InMemoryStore(){
        this.symbols = Stream.of("ONE")
                .map(Symbol::new)
                .collect(Collectors.toList());
    }

    public List<Symbol> getAllSymbols() {
        return symbols;
    }
}
