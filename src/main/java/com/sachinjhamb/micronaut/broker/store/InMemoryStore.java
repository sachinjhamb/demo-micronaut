package com.sachinjhamb.micronaut.broker.store;

import com.sachinjhamb.micronaut.broker.model.Quote;
import com.sachinjhamb.micronaut.broker.model.Symbol;
import io.micronaut.runtime.context.scope.ThreadLocal;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class InMemoryStore {

    private final List<Symbol> symbols;
    private ThreadLocalRandom current = ThreadLocalRandom.current();

    public InMemoryStore(){
        this.symbols = Stream.of("ONE")

                .map(Symbol::new)
                .collect(Collectors.toList());
    }

    public List<Symbol> getAllSymbols() {
        return symbols;
    }

    public Quote fetchQuote(final String symbol) {
        return Quote.builder().symbol(symbol)
                .bid(randomValue())
                .ask(randomValue())
                .lastPrice(randomValue())
                .volume(randomValue())
                .build();
    }

    private BigDecimal randomValue() {
        return BigDecimal.valueOf(current.nextDouble(1, 100));
    }
}
