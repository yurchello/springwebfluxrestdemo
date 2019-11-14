package com.webflux.demo.client;

import com.webflux.demo.model.Tweet;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ReactiveClient {

    private WebClient webClient;

    public ReactiveClient() {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:8091")
                .build();
    }

    public Flux<Tweet> findAll() {
        return webClient.get()
                .uri("/tweets")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(Tweet.class));
    }
}
