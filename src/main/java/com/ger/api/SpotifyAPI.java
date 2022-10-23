package com.ger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ger.dto.UserDTO;
import com.ger.exception.UserException;
import com.ger.service.SpotifyServiceImpl;
import com.ger.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class SpotifyAPI {
    
    @Autowired
    SpotifyServiceImpl spotifyWebAPI;

//    1. The Application makes a request for authorization to access user data to the Spotify Accounts Service, which in term prompts the User to Login or otherwise approve the authorization of the Application to access their data. 
//
//    2. Once approved, the Applcation makes another request to the Spotify Accounts Service requesting access and refresh tokens. The Spotify Accounts Service returns a response with the access and refresh tokens. 
//
//    3. The Application can now use the access token in its requests to the Web API for user data. 
    
    
    
    //1. Make a request to the SAS 


}






