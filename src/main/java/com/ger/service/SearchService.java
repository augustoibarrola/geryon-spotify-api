package com.ger.service;

import java.util.List;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.specification.Artist;

public interface SearchService {
    
    public List<Artist> searchArtistsBySearchString(SpotifyApi spotifyApi, String searchString);

}
