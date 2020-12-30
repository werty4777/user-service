package com.sulluscocha.user_web.infrastructure.api;

import com.sulluscocha.types.types.UserRequest;
import com.sulluscocha.user_application.Imp.UserServiceImp;
import com.sulluscocha.user_domain.domain.User;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;
import com.sulluscocha.user_domain.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    // falta hacer los metodos que consumira el gateway solo eso y probar listo

    private final UserServiceImp userService;


    @Autowired
    public userController(UserServiceImp userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public ResponseEntity<User> getUser(@RequestHeader("Authorization") String token) {


        try {
            return new ResponseEntity<>(this.userService.obtenerUsuario(token), HttpStatus.OK);
        } catch (UserNotFoundException | RecordNotFoundException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }

    @PostMapping("")
    public ResponseEntity<?> guardarUsuario(@RequestBody UserRequest userRequest) {

        User user = this.userService.ingresoUsuario(userRequest);

        if (user==null) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

        return new ResponseEntity<>(user,HttpStatus.OK);


    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
