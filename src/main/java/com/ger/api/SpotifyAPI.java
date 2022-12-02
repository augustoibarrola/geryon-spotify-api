package com.ger.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ger.dto.ArtistAndAlbumResponse;
import com.ger.service.SpotifyService;

import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class SpotifyAPI {

    @Autowired
    @Qualifier("spotifyServiceImpl")
    SpotifyService spotifyService;


    /*
     * Searches for an artist by a their Spotify ID
     */
    @GetMapping(value = "/artists/{artistId}")
    public ResponseEntity<ArtistAndAlbumResponse> readArtistById(@PathVariable String artistId) {

        System.out.println(artistId);
        ArtistAndAlbumResponse artist = spotifyService.getArtistById(artistId);

        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    /*
     * Searches for an album by its Spotify ID
     */
    @GetMapping(value = "/albums/{albumId}")
    public ResponseEntity<Album> readAlbumById(@PathVariable String albumId) {

        Album album = spotifyService.getAlbumById(albumId);

        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @GetMapping(value = "/albums/tracks/{albumId}")
    public ResponseEntity<Paging<TrackSimplified>> readAlbumTracksById(@PathVariable String albumId) {

        System.out.println(albumId);

        Paging<TrackSimplified> trackSimplifiedPaging = spotifyService.getAlbumTracksById(albumId);

        return new ResponseEntity<>(trackSimplifiedPaging, HttpStatus.OK);
    }

    /*
     * Searches for an artist by a string representation of their name
     */
    @GetMapping(value = "/search/{artist_name}")
    public ResponseEntity<List<Artist>> searchArtistByName(@PathVariable String artist_name) {
        
        System.out.println(artist_name);
        List<Artist> artistList = spotifyService.searchArtists_Sync(artist_name);
        
        return new ResponseEntity<>(artistList, HttpStatus.OK);
    }
}
