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
import com.ger.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class SpotifyAPI {
//    
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private Environment environment;
//    
    
    
    
    
    
    
    
    
    
//    
//    @GetMapping(value = "/users")
//    public ResponseEntity<List<UserDTO>> getAllUsers() 
//            throws UserException {
//        
//        List<UserDTO> listOfUsers = userService.getAllUsers();
//        
//        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
//    }
//    
//    @GetMapping(value = "/user/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) 
//            throws UserException {
//        
//        UserDTO userDTO = userService.getUser(id);
//        
//        return new ResponseEntity<>(userDTO, HttpStatus.OK);
//    }
//    
//    /*
//     * POST
//     * http://localhost:8765/user/users
//     * {
//     *  "firstName": " ",
//     *  "lastName": " ",
//     *  "email": " ",
//     *  "dateOfBirth": "YYYY-MM-DD"
//     * }
//     */
//    @PostMapping(value = "/users")
//    public ResponseEntity<String> postNewUser(@RequestBody UserDTO userDTO) 
//            throws UserException {
//        
//        Integer newUserId = userService.postNewUser(userDTO);
//        String successMessage = environment.getProperty("API.ADD_NEW_USER_SUCCESS") + newUserId;
//        
//        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);  
//        
//    }
//    
//    /*
//     * PUT
//     * http://localhost:8765/user/user/{id}
//     * {
//     *  "firstName": " ",
//     *  "lastName": " ",
//     *  "email": " ",
//     *  "dateOfBirth": "YYYY-MM-DD"
//     * }
//     */
//    @PutMapping(value = "/user/{id}")
//    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) 
//            throws UserException {
//                
//        userService.updateUser(id, userDTO.getFirstName());
//        String successMessage = environment.getProperty("API.USER_UPDATE_SUCCESS");
//        
//        return new ResponseEntity<>(successMessage, HttpStatus.OK);
//        
//    }
//    
//    /*
//     * DELETE
//     * http://localhost:8765/user/user/{id}
//     */
//    @DeleteMapping(value = "/user/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable Integer id) 
//            throws UserException{
//        
//        userService.deleteUser(id);
//        
//        String successMessage = environment.getProperty("API.USER_DELETE_SUCCESS");
//        
//        return new ResponseEntity<>(successMessage, HttpStatus.OK);
//    }

}






