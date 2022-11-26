package com.ger.service;

import java.io.IOException;

import javax.persistence.PersistenceContext;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;

@Service("spotifyAlbumService")
public class SpotifyAlbumService extends SpotifyServiceImpl{
    

//    @Autowired
//    @Qualifier("spotifyServiceImpl")
//    SpotifyService spotifyService;
    
    
//    public void getAlbum_Sync() {
//       final String id = "5zT1JLIj9E57p3e1rFm9Uq";
//
//        
//        final GetAlbumRequest getAlbumRequest = this.spotifyApi.getAlbum(id)
////              .market(CountryCode.SE)
//        .build();
//        try {
//          final Album album = getAlbumRequest.execute();
//
//          System.out.println("Name: " + album.getName());
//        } catch (IOException | SpotifyWebApiException | ParseException e) {
//          System.out.println("Error: " + e.getMessage());
//        }
//      }

}
