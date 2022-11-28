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

import com.ger.service.SpotifyService;

import se.michaelthelin.spotify.model_objects.specification.Artist;

@CrossOrigin
@RestController
@RequestMapping(value = "/ger")
public class SpotifyAPI {
    
    @Autowired
    @Qualifier("spotifyServiceImpl")
    SpotifyService spotifyService;

    @GetMapping(value="/test")
    public ResponseEntity<String> getAuthorization(){
        
        spotifyService.getAlbum_Sync();
        
        return new ResponseEntity<>("Here I AM!", HttpStatus.OK);
    }
    
    
    /*
     * Searches for an artist by name
     */
    @GetMapping(value="/search/{artist_name}")
    public ResponseEntity<List<Artist>> searchArtist(@PathVariable String artist_name){
        
        System.out.println(artist_name);
        List<Artist> artistList = spotifyService.searchArtists_Sync(artist_name);
        
        return new ResponseEntity<>(artistList, HttpStatus.OK);
    }
    


}






