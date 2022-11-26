package com.ger.service;

public interface SpotifyService {
    
    public void beginAuthCodeFlow();
    public void beginClientCredentialAuthorizationFlow();
    public void getAlbum_Sync();
    public void searchArtists_Sync(String artistSearchRequest);

}
