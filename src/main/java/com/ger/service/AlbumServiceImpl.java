package com.ger.service;

import java.io.IOException;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;

@Service("albumServiceImpl")
public class AlbumServiceImpl implements AlbumService {


    @Override
    public Album getAlbumById(SpotifyApi spotifyApi, String albumId) {
        GetAlbumRequest getAlbumRequest = spotifyApi.getAlbum(albumId).build();
        Album album = null;
        
        try {
            album = getAlbumRequest.execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return album;
    }

    @Override
    public Paging<TrackSimplified> getAlbumTracksById(SpotifyApi spotifyApi, String albumId) {
        GetAlbumsTracksRequest getAlbumsTracksRequest = spotifyApi.getAlbumsTracks(albumId).build();
        
        Paging<TrackSimplified> trackSimplifiedPaging  = null;
        
        try {
            trackSimplifiedPaging = getAlbumsTracksRequest.execute();

            System.out.println("Total: " + trackSimplifiedPaging.getTotal());
          } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
          }
        
        return trackSimplifiedPaging;
    }

}
