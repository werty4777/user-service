package com.sulluscocha.user_domain.domain.services;

import com.sulluscocha.types.types.Rol;
import com.sulluscocha.user_domain.domain.User;

public interface UserService {

    void cambiarRol(Rol rol, User usuario);

}
