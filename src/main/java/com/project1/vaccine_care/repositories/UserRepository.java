/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.repositories;

import com.project1.vaccine_care.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    public void deleteByNik(long nik);

    public Optional<User> findByNik(long nik);
    User findByName(String name);
    
}
