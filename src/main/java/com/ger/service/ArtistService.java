package com.ger.service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.specification.Artist;

public interface ArtistService {
    public Artist getArtistById(SpotifyApi spotifyApi, String artistId);

}
