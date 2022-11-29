package com.ger.service;

import java.util.List;

import se.michaelthelin.spotify.model_objects.specification.Artist;

public interface SpotifyService {
    
    public void beginClientCredentialAuthorizationFlow();
    public void getAlbum_Sync();
    public List<Artist> searchArtists_Sync(String artistSearchRequest);

}
