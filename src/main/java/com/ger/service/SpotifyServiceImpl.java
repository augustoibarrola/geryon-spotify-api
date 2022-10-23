package com.ger.service;

import java.net.URI;

import se.michaelthelin.spotify.SpotifyApi;

public class SpotifyServiceImpl implements SpotifyService {

    private static final String clientId = "02f111e6167141cc9d9395babef9cbc6";
    private static final String clientSecret = "7b2768355a4f443595eb92527183cd4c";
    private static final String redirectURI = "http://localhost:8787";
    public SpotifyApi spotifyApi;  

    public SpotifyServiceImpl() {

                this.spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(URI.create(redirectURI))
                .build();
    };

    @Override
    public void beginAuthCodeFlow() {

    }

}
