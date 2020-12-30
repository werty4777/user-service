package com.sulluscocha.user_persistence.persistence.repositorymysql.Imp;

import com.sulluscocha.user_persistence.persistence.RolesDO;
import com.sulluscocha.user_persistence.persistence.repositorymysql.RolRepository;
import com.sulluscocha.user_persistence.persistence.repositorymysql.RolRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolRepositoryImp implements RolRepository {

    private final RolRepositoryMysql rolRepositoryMysql;

    @Autowired
    public RolRepositoryImp(RolRepositoryMysql rolRepositoryMysql) {
        this.rolRepositoryMysql = rolRepositoryMysql;
    }


    @Override
    public RolesDO obtenerRol(int idRol) {

        return this.rolRepositoryMysql.findById(idRol).orElseThrow(RuntimeException::new);


    }
}
