package com.ger.dto;

import java.util.List;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;

//public class ArtistAndAlbumResponse extends Artist{}
public class ArtistAndAlbumResponse<Artist, List> {
    
    private final Artist artist;
    private final List albums;
    
    public ArtistAndAlbumResponse(Artist artist, List albums) {
        this.artist = artist;
        this.albums = albums;
    }
    
    public Artist getArtist() {
        return this.artist;
    }
    
    public List getAlbums(){
        return this.albums;
    }
    
    
}
