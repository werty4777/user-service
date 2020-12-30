package com.sulluscocha.user_persistence.persistence.repositorymysql.Imp;

import com.sulluscocha.user_persistence.persistence.AlmacenDO;
import com.sulluscocha.user_persistence.persistence.repositorymysql.AlmacenRepository;
import com.sulluscocha.user_persistence.persistence.repositorymysql.AlmacenRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlmacenRepositoryImp implements AlmacenRepository {

    private final AlmacenRepositoryMysql almacenRepositoryMysql;

    @Autowired
    public AlmacenRepositoryImp(AlmacenRepositoryMysql almacenRepositoryMysql) {
        this.almacenRepositoryMysql = almacenRepositoryMysql;
    }

    @Override
    public AlmacenDO obtenerAlmacen(int idAlmacen) {


        return this.almacenRepositoryMysql.findById(idAlmacen).orElseThrow(RuntimeException::new);

    }
}
