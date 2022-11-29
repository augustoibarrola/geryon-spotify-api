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
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;

public interface AlbumService {
    public Album getAlbumById(SpotifyApi spotifyApi, String albumId);
    public Paging<TrackSimplified> getAlbumTracksById(SpotifyApi spotifyApi, String albumId);

}
