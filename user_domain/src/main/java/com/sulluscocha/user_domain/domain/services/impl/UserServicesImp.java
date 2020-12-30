package com.sulluscocha.user_domain.domain.services.impl;

import com.sulluscocha.types.types.Rol;
import com.sulluscocha.user_domain.domain.User;

import com.sulluscocha.user_domain.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserService {



    @Override
    public void cambiarRol(Rol rol, User usuario) {

        usuario.establecerRol(rol);
        System.out.println("rol establecido :" + rol);

    }
}
