package com.ger.security;

import se.michaelthelin.spotify.SpotifyApi;

public interface SpotifyAuthorization {
    
    public void clientCredentialAuthorizationFlow(SpotifyApi spotifyApi);
    public void authorizationCodePKCEFlow();

}
