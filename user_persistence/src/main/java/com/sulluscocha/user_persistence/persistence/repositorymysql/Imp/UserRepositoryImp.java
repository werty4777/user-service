package com.sulluscocha.user_persistence.persistence.repositorymysql.Imp;

import com.sulluscocha.user_domain.domain.User;
import com.sulluscocha.user_domain.exception.UserNotFoundException;
import com.sulluscocha.user_persistence.persistence.UserDO;
import com.sulluscocha.user_persistence.persistence.impl.UserBuilderImp;
import com.sulluscocha.user_persistence.persistence.repositorymysql.UserRepository;
import com.sulluscocha.user_persistence.persistence.repositorymysql.UserRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImp implements UserRepository {


    private final UserRepositoryMysql userRepositoryMysql;

    private final UserBuilderImp userBuilder;
    private final RolRepositoryImp rolRepositoryImp;
    private final AlmacenRepositoryImp almacenRepositoryImp;

    @Autowired
    public UserRepositoryImp(UserRepositoryMysql userRepositoryMysql, UserBuilderImp userBuilder, RolRepositoryImp rolRepositoryImp, AlmacenRepositoryImp almacenRepositoryImp) {
        this.userRepositoryMysql = userRepositoryMysql;
        this.userBuilder = userBuilder;
        this.rolRepositoryImp = rolRepositoryImp;
        this.almacenRepositoryImp = almacenRepositoryImp;
    }


    @Override
    public User guardarUsuario(User user) {


        UserDO userDO = this.userBuilder.fromUser(user);

        userDO.setRol(rolRepositoryImp.obtenerRol(1));
        userDO.setAlmacen(almacenRepositoryImp.obtenerAlmacen(1));
        UserDO usuarioGuardado = this.userRepositoryMysql.save(userDO);
        System.out.println("usuario guardado");
        return this.userBuilder.toUser(usuarioGuardado);


    }

    @Override
    public User buscarUsuario(String token) throws UserNotFoundException {


        UserDO byId = this.userRepositoryMysql.findById(token).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));


        return this.userBuilder.toUser(byId);

    }


}
