package com.ger.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ger.dto.ArtistAndAlbumResponse;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;

@Service("artistServiceImpl")
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    AlbumService albumService;

    @Override
    public ArtistAndAlbumResponse getArtistById(SpotifyApi spotifyApi, String artistId) {
        GetArtistRequest getArtistRequest = spotifyApi.getArtist(artistId).build();
        Artist artist = null;
        List<AlbumSimplified> albums = null;
        Paging<AlbumSimplified> albumSimplifiedPaging = null;

        
        try {
            artist = getArtistRequest.execute();

            System.out.println("Name: " + artist.getName());

            albumSimplifiedPaging = albumService.getAlbumsByArtistId(spotifyApi, artist.getId());
            
            albums = Arrays.asList(albumSimplifiedPaging.getItems());
            
            return new ArtistAndAlbumResponse(artist, albums);

            
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

}
