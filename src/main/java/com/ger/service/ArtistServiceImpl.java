package com.ger.service;

import java.io.IOException;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;

@Service("artistServiceImpl")
public class ArtistServiceImpl implements ArtistService {

    @Override
    public Artist getArtistById(SpotifyApi spotifyApi, String artistId) {
        GetArtistRequest getArtistRequest = spotifyApi.getArtist(artistId).build();
        Artist artist = null;
        try {
            artist = getArtistRequest.execute();

            System.out.println("Name: " + artist.getName());
          } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
          }
        return artist;
    }

}
