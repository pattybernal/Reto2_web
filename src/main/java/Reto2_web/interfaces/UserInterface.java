/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.interfaces;

import Reto2_web.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-03
 */
public interface UserInterface extends MongoRepository <User, Integer> {

    Optional<User> findByEmail(String email);
    
    Optional<User> findByEmailAndPassword(String email, String password);


}
