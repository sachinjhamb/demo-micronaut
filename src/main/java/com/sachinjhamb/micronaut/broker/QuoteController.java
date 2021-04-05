package com.sachinjhamb.micronaut.broker;

import com.sachinjhamb.micronaut.broker.error.CustomErrorQuote;
import com.sachinjhamb.micronaut.broker.model.Quote;
import com.sachinjhamb.micronaut.broker.store.InMemoryStore;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller("/quotes")
public class QuoteController {

    private InMemoryStore store;

    public QuoteController(InMemoryStore store) {
        this.store = store;
    }

    @Get("/{symbol}")
    public HttpResponse getQuote(@PathVariable String symbol){
        Quote quote = store.fetchQuote(symbol);
        return HttpResponse.ok(quote);
    }

    @Get("/{symbol}/error")
    public HttpResponse getQuoteError(@PathVariable String symbol){
        CustomErrorQuote errorQuote = CustomErrorQuote
                .builder()
                .error("Not Found, incorrect value sent")
                .message("Not Found, try something again")
                .path("/quote/" + symbol + "/error")
                .build();
        return HttpResponse.notFound(errorQuote);
    }
}
