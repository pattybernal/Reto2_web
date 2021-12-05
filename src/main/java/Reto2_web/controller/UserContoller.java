/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.controller;

import Reto2_web.model.User;
import Reto2_web.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-03
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
/**
 * Clase publica Usercontroller
 */
public class UserContoller {
    @Autowired
    private UserService userService;
     
    @GetMapping("/all")
     /**
     * Hacer llamados get
     */
    public List<User> getAll() {
        return userService.getAll();
    }
     /**
     * Hacer llamados get por Id
     */
    @PostMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
     /*
     * peticion new (POST)
     */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
     
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
     /**
     * peticion update para actualizar (PUT)
     */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
     /**
     * peticion delete 
     */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    @GetMapping("/{email}/{password}")
     /**
     * Clase autenticar usuario
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    @GetMapping("/emailexist/{email}")
     /**
     * clase vverificar email
     */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
