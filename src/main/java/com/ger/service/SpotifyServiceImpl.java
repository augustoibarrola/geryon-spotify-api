package com.ger.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchArtistsRequest;

@Service("spotifyServiceImpl")
public class SpotifyServiceImpl implements SpotifyService {

    private static final String clientId = "02f111e6167141cc9d9395babef9cbc6";
    private static final String clientSecret = "7b2768355a4f443595eb92527183cd4c";
    private static final String redirectURI = "http://localhost:8787";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId)
            .setClientSecret(clientSecret).build();

    public static SpotifyApi getSpotifyapi() {
        return spotifyApi;
    }

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

    @Override
    public void beginAuthCodeFlow() {

    }

    @Override
    public void beginClientCredentialAuthorizationFlow() {
        clientCredentials_Sync();
    }

    public static void clientCredentials_Sync() {
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("Expires in: " + clientCredentials.getExpiresIn());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getAlbum_Sync() {

        String id = "5zT1JLIj9E57p3e1rFm9Uq";

        GetAlbumRequest getAlbumRequest = spotifyApi.getAlbum(id)
//              .market(CountryCode.SE)
                .build();
        try {
            final Album album = getAlbumRequest.execute();

            System.out.println("Name: " + album.getName());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Artist> searchArtists_Sync(String artistSearchRequest) {
//        Example; Lady Gaga

        final SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(artistSearchRequest)
//              .market(CountryCode.SE)
//              .limit(10)
//              .offset(0)
//              .includeExternal("audio")
                .build();
        
        List<Artist> artistList = new ArrayList<>();


        try {
            final Paging<Artist> artistPaging = searchArtistsRequest.execute();

            Artist[] artistsResults = artistPaging.getItems();
 
            System.out.println("Total: " + artistPaging.getTotal()); // Total: 28
            System.out.println("Total: " + artistsResults.length);// Total: 20

            for (Artist artist : artistsResults) {
                System.out.println(artist.toString());// Artist(name=Lady Gaga,
                                                      // externalUrls=ExternalUrl(externalUrls={spotify=https://open.spotify.com/artist/1HY2Jd0NmPuamShAr6KMms}),
                                                      // followers=Followers(href=null, total=23840533), genres=[art
                                                      // pop, dance pop, pop],
                                                      // href=https://api.spotify.com/v1/artists/1HY2Jd0NmPuamShAr6KMms,
                                                      // id=1HY2Jd0NmPuamShAr6KMms, images=[Image(height=640,
                                                      // url=https://i.scdn.co/image/ab6761610000e5ebc8d3d98a1bccbe71393dbfbf,
                                                      // width=640), Image(height=320,
                                                      // url=https://i.scdn.co/image/ab67616100005174c8d3d98a1bccbe71393dbfbf,
                                                      // width=320), Image(height=160,
                                                      // url=https://i.scdn.co/image/ab6761610000f178c8d3d98a1bccbe71393dbfbf,
                                                      // width=160)], popularity=84, type=ARTIST,
                                                      // uri=spotify:artist:1HY2Jd0NmPuamShAr6KMms)
               artistList.add(artist);

            }
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return artistList;
    }

}
