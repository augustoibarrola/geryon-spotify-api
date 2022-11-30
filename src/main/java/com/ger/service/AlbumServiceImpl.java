package com.ger.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumsTracksRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistsAlbumsRequest;

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

        Paging<TrackSimplified> trackSimplifiedPaging = null;

        try {
            trackSimplifiedPaging = getAlbumsTracksRequest.execute();

            System.out.println("Total: " + trackSimplifiedPaging.getTotal());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return trackSimplifiedPaging;
    }

    @Override
    public List<AlbumSimplified> getAlbumsByArtistId(SpotifyApi spotifyApi, String artistId) {

        GetArtistsAlbumsRequest getArtistsAlbumsRequest = spotifyApi.getArtistsAlbums(artistId).build();
        Paging<AlbumSimplified> albumSimplifiedPaging = null;
        List<AlbumSimplified> albumSimplifiedList = null;
        try {
            albumSimplifiedPaging = getArtistsAlbumsRequest.execute();

            System.out.println("Total: " + albumSimplifiedPaging.getTotal());
            
            albumSimplifiedList = Arrays.asList(albumSimplifiedPaging.getItems());
            
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return albumSimplifiedList;

    }


}
