package com.ger.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;

@Service("searchServiceImpl")
public class SearchServiceImpl implements SearchService {

    @Override
    public List<Artist> searchArtistsBySearchString(SpotifyApi spotifyApi, String searchString) {
        final SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(searchString)
                .limit(50)
                .build();

        List<Artist> artistList = new ArrayList<>();

        try {
            final Paging<Artist> artistPaging = searchArtistsRequest.execute();

            artistList = organizeSearchedArtistsByTotalFollowers(artistPaging);
            
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return artistList;
    }
    
    private List<Artist> organizeSearchedArtistsByTotalFollowers(Paging<Artist> artistPaging ){
        
        List<Artist> artistsResults = new ArrayList<>(Arrays.asList(artistPaging.getItems()));

        Collections.sort(artistsResults, new Comparator<Artist>() {
            public int compare(Artist artist1, Artist artist2) {
                return artist2.getFollowers().getTotal().compareTo(artist1.getFollowers().getTotal());
            }
        });

        //        Uncomment to see the returned list of Searched Artists in the console
        //        for (Artist artist : artistsResults) {System.out.println(artist.toString());}
        
        return artistsResults;
    }

}
