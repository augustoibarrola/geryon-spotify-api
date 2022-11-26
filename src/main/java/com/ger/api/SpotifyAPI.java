package com.ger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ger.dto.UserDTO;
import com.ger.exception.UserException;
import com.ger.service.SpotifyService;
import com.ger.service.SpotifyServiceImpl;
import com.ger.service.UserService;

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
    
    @GetMapping(value="/search/{artist_name}")
    public ResponseEntity<String> searchArtist(@PathVariable String artist_name){
        
        spotifyService.searchArtists_Sync(artist_name);
        
        return new ResponseEntity<>("Here I AM!", HttpStatus.OK);
    }

}






