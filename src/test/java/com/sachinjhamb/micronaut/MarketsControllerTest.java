package com.sachinjhamb.micronaut;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@MicronautTest
public class MarketsControllerTest {

    @Inject
    EmbeddedApplication application;

    @Inject
    @Client("/")
    RxHttpClient client;


    @Test
    void testItWorks() {

        assertTrue(application.isRunning());
    }

    @Test
    void testNumberOfMarketSymbols(){
        final List result = client.toBlocking().retrieve("/markets", List.class);
        assertEquals(1, result.size());
    }
}
