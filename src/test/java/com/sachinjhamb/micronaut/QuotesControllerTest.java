package com.sachinjhamb.micronaut;

import com.sachinjhamb.micronaut.broker.error.CustomErrorQuote;
import com.sachinjhamb.micronaut.broker.model.Quote;
import com.sun.org.apache.xpath.internal.operations.Quo;
import io.micronaut.core.type.Argument;
import static io.micronaut.http.HttpRequest.GET;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class QuotesControllerTest {

    @Inject
    EmbeddedApplication application;

    static final Logger log = LoggerFactory.getLogger(QuotesControllerTest.class);

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void testQuotesPerSymbol(){
        final Quote result = client.toBlocking().retrieve("/quotes/APPL", Quote.class);
        log.info(String.valueOf(result));
    }

    @Test
    void testErrorQuote(){
        try {
            final Quote result = client.toBlocking().retrieve(
                    GET("/quotes/APPL/error"),
                    Argument.of(Quote.class),
                    Argument.of(CustomErrorQuote.class));
        }catch(HttpClientResponseException e){
            Optional<CustomErrorQuote> customErrorQuote = e.getResponse().getBody(CustomErrorQuote.class);

            log.info("caught exception: " + customErrorQuote);
        }
    }
}
