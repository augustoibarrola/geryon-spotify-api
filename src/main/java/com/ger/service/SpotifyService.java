package com.ger.service;

import java.util.List;

import com.ger.dto.ArtistAndAlbumResponse;

import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

public interface SpotifyService {

    public void beginClientCredentialAuthorizationFlow();
    public List<Artist> searchArtists_Sync(String artistSearchRequest);
    public ArtistAndAlbumResponse getArtistById(String artistId);
    public Album getAlbumById(String albumId);
    public Paging<TrackSimplified> getAlbumTracksById(String albumId);
    void beginAuthorizationCodePKCEFlow();

}
