package com.ger.service;

import com.ger.dto.ArtistAndAlbumResponse;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.specification.Artist;

public interface ArtistService {
    public ArtistAndAlbumResponse getArtistById(SpotifyApi spotifyApi, String artistId);

}
