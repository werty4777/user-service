package com.sulluscocha.user_application;


import com.sulluscocha.types.types.UserRequest;
import com.sulluscocha.user_domain.domain.RecordUser;
import com.sulluscocha.user_domain.domain.User;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;
import com.sulluscocha.user_domain.exception.UserNotFoundException;
import com.sulluscocha.user_persistence.persistence.UserDO;


public interface UserService {

    User ingresoUsuario(UserRequest userRequest) throws UserNotFoundException;

    User obtenerUsuario(String token) throws UserNotFoundException, RecordNotFoundException;

    void limpiarHistorial();
}
