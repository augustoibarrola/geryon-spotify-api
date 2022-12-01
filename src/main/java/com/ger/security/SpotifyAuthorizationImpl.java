package com.ger.security;

import java.io.IOException;
import java.net.URI;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.pkce.AuthorizationCodePKCERequest;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

@Service("spotifyAuthorizationImpl")
public class SpotifyAuthorizationImpl implements SpotifyAuthorization{
    
    @Override
    public void clientCredentialAuthorizationFlow(SpotifyApi spotifyApi) {
        
        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

        try {
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("Expires in: " + clientCredentials.getExpiresIn());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void authorizationCodePKCEFlow() {

        String clientId = "02f111e6167141cc9d9395babef9cbc6";
        URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:4200/");


        SpotifyApi spotifyApi2 = new SpotifyApi.Builder().setClientId(clientId).setRedirectUri(redirectUri).build();
        
        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi2.authorizationCodeUri(clientId, redirectUri).code_challenge_method("S256").build();
        
        URI test = authorizationCodeUriRequest.execute();
        
        System.out.println(test.toString());
        
        
        
//        AuthorizationCodePKCERequest authorizationCodePKCERequest = spotifyApi2.authorizationCodePKCE(code, codeVerifier).build();
//
//        
//          try {
//            AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodePKCERequest.execute();
//
//            // Set access and refresh token for further "spotifyApi" object usage
//            spotifyApi2.setAccessToken(authorizationCodeCredentials.getAccessToken());
//            spotifyApi2.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
//
//            System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
//          } catch (IOException | SpotifyWebApiException | ParseException e) {
//            System.out.println("Error: " + e.getMessage());
//          }

        
        
    }

}
