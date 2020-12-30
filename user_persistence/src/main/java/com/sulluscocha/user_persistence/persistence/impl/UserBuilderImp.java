package com.sulluscocha.user_persistence.persistence.impl;

import com.sulluscocha.types.types.Profile;
import com.sulluscocha.types.types.Rol;
import com.sulluscocha.types.types.Store;
import com.sulluscocha.user_domain.domain.User;
import com.sulluscocha.user_persistence.persistence.UserBuilder;
import com.sulluscocha.user_persistence.persistence.UserDO;
import com.sulluscocha.user_persistence.persistence.repositorymysql.UserRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBuilderImp implements UserBuilder {


    private final UserRepositoryMysql userRepositoryMysql;

    @Autowired
    public UserBuilderImp(UserRepositoryMysql userRepositoryMysql) {
        this.userRepositoryMysql = userRepositoryMysql;
    }

    @Override
    public UserDO fromUser(User user) {


        UserDO usuario = new UserDO();
        usuario.setId(user.getProfile().getId());
        usuario.setEmail(user.getProfile().getEmail());
        return usuario;


    }

    @Override
    public User toUser(UserDO user) {


        User usuario = new User();
        usuario.setProfile(new Profile(user.getId(), user.getEmail()));
        usuario.setRol(new Rol(user.getRol().getRol()));
        usuario.setAlmacen(new Store(user.getAlmacen().getAlmacen()));


        return usuario;

    }


}
