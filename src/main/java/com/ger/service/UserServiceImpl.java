package com.ger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ger.dto.UserDTO;
import com.ger.entity.User;
import com.ger.exception.UserException;
import com.ger.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public UserDTO getUser(Integer userId) throws UserException {
        
        Optional<User> optionalUser = userRepo.findById(userId);
        
        User user = optionalUser.orElseThrow(() -> new UserException("Service.USER_NOT_FOUND"));
        
        UserDTO userDTO = this.entityToDTO(user);
        
        return userDTO;
    }
    
    @Override
    public List<UserDTO> getAllUsers() throws UserException{
        
        Iterable<User> users = userRepo.findAll();
        
        List<UserDTO> userDTOs = new ArrayList<>();
        
        users.forEach(user -> {
            UserDTO userDTO = this.entityToDTO(user);
            
            userDTOs.add(userDTO);
        });
        
        if(userDTOs.isEmpty()) throw new UserException("Service.USERS_NOT_FOUND");
        
        return userDTOs;
    }

    @Override
    public Integer postNewUser(UserDTO userDTO) throws UserException {
        
        User user = saveNewUserToDB(userDTO);
        
        
        return user.getId();
    }
    
    @Override
    public void updateUser(Integer userId, String firstName) throws UserException {
        
        Optional<User> optionalUser = userRepo.findById(userId);
        
        User user = optionalUser.orElseThrow(() -> new UserException("Service.USER_NOT_FOUND"));
        
        user.setFirstName(firstName);
        
    }

    @Override
    public void deleteUser(Integer userId) throws UserException {

        Optional<User> optionalUser = userRepo.findById(userId);
        
        optionalUser.orElseThrow(() -> new UserException("Service.USER_NOT_FOUND"));
        
        userRepo.deleteById(userId);
    }
    
    private UserDTO entityToDTO(User user) {
        
        UserDTO userDTO = new UserDTO();
        
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        
        return userDTO;
        
    }
    
    private User DTOtoEntity(UserDTO userDTO) {
        
        User user = new User();
        
//        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        
        
        return user;
    }
    
    private User saveNewUserToDB(UserDTO userDTO) {
        
        User user = DTOtoEntity(userDTO);
        
        User savedUser = userRepo.save(user);
        
        return savedUser;
    }



}
