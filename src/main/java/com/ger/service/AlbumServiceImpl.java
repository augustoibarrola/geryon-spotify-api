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
            
            albumSimplifiedList = trimAlbumSimplifiedPagingResponse(albumSimplifiedPaging);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return albumSimplifiedList;

    }

    private List<AlbumSimplified> trimAlbumSimplifiedPagingResponse(Paging<AlbumSimplified> albumSimplifiedPaging) {
        
        List<AlbumSimplified> albums = Arrays.asList(albumSimplifiedPaging.getItems());
        
        albums.forEach(album -> {
            //trim album properties "availableMarkets" to "externalUrls"
            new Album.JsonUtil().createModelObject(trimAlbumName(album)).toString();   
        });
        
        return albums;
        
    }
    
    private String trimAlbumName(AlbumSimplified album) {
        
   
        String albumString = album.toString();
        System.out.println("ALBUM AS STRING: " + albumString);
//      AlbumSimplified(artists=[ArtistSimplified(name=ABBA, externalUrls=ExternalUrl(externalUrls={spotify=https://open.spotify.com/artist/0LcJLqbBmaGUft1e9Mm8HV}), href=https://api.spotify.com/v1/artists/0LcJLqbBmaGUft1e9Mm8HV, id=0LcJLqbBmaGUft1e9Mm8HV, type=ARTIST, uri=spotify:artist:0LcJLqbBmaGUft1e9Mm8HV)], name=Voyage, albumGroup=ALBUM, albumType=ALBUM, availableMarkets=[AD, AE, AG, AL, AM, AO, AR, AT, AU, AZ, BA, BB, BD, BE, BF, BG, BH, BI, BJ, BN, BO, BR, BS, BT, BW, BY, BZ, CA, CD, CG, CH, CI, CL, CM, CO, CR, CV, CW, CY, CZ, DE, DJ, DK, DM, DO, DZ, EC, EE, EG, ES, FI, FJ, FM, FR, GA, GB, GD, GE, GH, GM, GN, GQ, GR, GT, GW, GY, HK, HN, HR, HT, HU, ID, IE, IL, IN, IQ, IS, IT, JM, JO, JP, KE, KG, KH, KI, KM, KN, KR, KW, KZ, LA, LB, LC, LI, LK, LR, LS, LT, LU, LV, LY, MA, MC, MD, ME, MG, MH, MK, ML, MN, MO, MR, MT, MU, MV, MW, MX, MY, MZ, NA, NE, NG, NI, NL, NO, NP, NR, NZ, OM, PA, PE, PG, PH, PK, PL, PS, PT, PW, PY, QA, RO, RS, RW, SA, SB, SC, SE, SG, SI, SK, SL, SM, SN, SR, ST, SV, SZ, TD, TG, TH, TJ, TL, TN, TO, TR, TT, TV, TW, TZ, UA, UG, US, UY, UZ, VC, VE, VN, VU, WS, XK, ZA, ZM, ZW], externalUrls=ExternalUrl(externalUrls={spotify=https://open.spotify.com/album/0uUtGVj0y9FjfKful7cABY}), href=https://api.spotify.com/v1/albums/0uUtGVj0y9FjfKful7cABY, id=0uUtGVj0y9FjfKful7cABY, images=[Image(height=640, url=https://i.scdn.co/image/ab67616d0000b273225d9c1b06ca69aec9b08381, width=640), Image(height=300, url=https://i.scdn.co/image/ab67616d00001e02225d9c1b06ca69aec9b08381, width=300), Image(height=64, url=https://i.scdn.co/image/ab67616d00004851225d9c1b06ca69aec9b08381, width=64)], releaseDate=2021-11-05, releaseDatePrecision=DAY, restrictions=null, type=ALBUM, uri=spotify:album:0uUtGVj0y9FjfKful7cABY)

        int albumAMIndex = albumString.indexOf("AD, AE, AG, AL,");
        System.out.println("available markets index : " + albumAMIndex ); // 354
        int albumEUIndex = albumString.indexOf("], externalUrls=");
        System.out.println("externalUrls index : " + albumEUIndex ); // 1103

        System.out.println();
        
        String newAlbumStringStart = albumString.substring(0, albumAMIndex+18);
        System.out.println("newAlbumStringStart : " + newAlbumStringStart);



        String newAlbumStringFinish = albumString.substring(albumEUIndex, albumString.length()-1);
        System.out.println("newAlbumStringFinish : " + newAlbumStringFinish);

        System.out.println("NEW NAME: " + newAlbumStringStart + newAlbumStringFinish);

        System.out.println();
        return new String(newAlbumStringStart + newAlbumStringFinish);
        
    }

}
