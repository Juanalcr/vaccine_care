/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.services;

import com.project1.vaccine_care.interfaces.UserInterface;
import com.project1.vaccine_care.models.User;
import com.project1.vaccine_care.repositories.UserRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;
    private long nik;
    
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void store(User user) {
        this.userRepository.save(user);
    }
    
    @Override
    public User getByNik(long id) {
    Optional < User > optional = userRepository.findByNik(nik);

    if (!optional.isPresent()) {
    throw new RuntimeException(" User not found for nik :: " + nik);
     }

    User user = optional.get();
     return user;
    }

@Override
public void delete(long id) {
  this.userRepository.deleteByNik(nik);
}

    @Override
    public User auth(String name, long phone_number) throws Exception {
        User user = userRepository.findByName(name);
    
        return user;
    
    }
    @Override
    public void register(User user) throws Exception {
        
         long nik = user.getNik();
         String name = user.getName();
         String home_address = user.getHome_address();
         long phone_number = user.getPhone_number();
         
        user.setNik(nik);
        user.setName(name);
        user.setHome_address(home_address);
        user.setPhone_number(phone_number);
        
        this.userRepository.save(user);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

   

}
