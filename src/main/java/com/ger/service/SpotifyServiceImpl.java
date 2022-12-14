package com.ger.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ger.dto.ArtistAndAlbumResponse;
import com.ger.security.SpotifyAuthorization;
import com.ger.security.SpotifyAuthorizationImpl;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;

@Service("spotifyServiceImpl")
public class SpotifyServiceImpl implements SpotifyService {

    @Autowired
    SpotifyAuthorization spotifyAuthService;
    @Autowired
    ArtistService artistService;
    @Autowired
    AlbumService albumService;
    @Autowired
    SearchService searchService;

    private static final String clientId = "02f111e6167141cc9d9395babef9cbc6";
    private static final String clientSecret = "7b2768355a4f443595eb92527183cd4c";
    private static final String redirectURI = "http://localhost:8787";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).build();

    public static SpotifyApi getSpotifyapi() {
        return spotifyApi;
    }

    @Override
    public void beginClientCredentialAuthorizationFlow() {
        spotifyAuthService.clientCredentialAuthorizationFlow(spotifyApi);
    }

    @Override
    public ArtistAndAlbumResponse getArtistById(String artistId) {
        return artistService.getArtistById(spotifyApi, artistId);
    }

    @Override
    public Album getAlbumById(String albumId) {
        return albumService.getAlbumById(spotifyApi, albumId);
    }

    @Override
    public Paging<TrackSimplified> getAlbumTracksById(String albumId) {
        return albumService.getAlbumTracksById(spotifyApi, albumId);
    }

    public List<Artist> searchArtists_Sync(String searchString) {
        return searchService.searchArtistsBySearchString(spotifyApi, searchString);
    }

}
