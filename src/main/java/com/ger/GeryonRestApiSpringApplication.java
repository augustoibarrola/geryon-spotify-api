package com.ger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ger.service.SpotifyService;

@SpringBootApplication
public class GeryonRestApiSpringApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("spotifyServiceImpl")
    SpotifyService spotifyService;

    public static void main(String[] args) {
        SpringApplication.run(GeryonRestApiSpringApplication.class, args);
    }

    @Override
    public void run(String... args) {
        spotifyService.beginClientCredentialAuthorizationFlow();
    }

}