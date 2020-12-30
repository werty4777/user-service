package com.sulluscocha.user_persistence.persistence.repositorymysql;

import com.sulluscocha.user_domain.domain.User;
import com.sulluscocha.user_domain.exception.UserNotFoundException;
import com.sulluscocha.user_persistence.persistence.UserDO;

public interface UserRepository {


    User guardarUsuario(User user) throws UserNotFoundException;

    User buscarUsuario(String token) throws UserNotFoundException;


}
