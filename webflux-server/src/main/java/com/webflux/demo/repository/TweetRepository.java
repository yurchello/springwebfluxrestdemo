package com.webflux.demo.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.webflux.demo.model.Tweet;

@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {

}
