package com.ger.service;

import com.ger.dto.UserDTO;
import com.ger.exception.UserException;

import java.util.List;

public interface UserService {
    
    public UserDTO getUser(Integer userId) throws UserException;
    public List<UserDTO> getAllUsers() throws UserException;
    public Integer postNewUser(UserDTO userDTO) throws UserException;
    public void updateUser(Integer userId, String firstName) throws UserException;
    public void deleteUser(Integer userId) throws UserException;

}

