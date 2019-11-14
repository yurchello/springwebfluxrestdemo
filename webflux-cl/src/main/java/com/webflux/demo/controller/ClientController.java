package com.webflux.demo.controller;

import com.webflux.demo.client.ReactiveClient;
import com.webflux.demo.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ReactiveClient reactiveClient;

    @GetMapping("/tweets")
    public void getAllTweets() {
        Flux<Tweet> tweetFlux = reactiveClient.findAll();
        tweetFlux.subscribe(x -> System.out.println(x));
    }

}
