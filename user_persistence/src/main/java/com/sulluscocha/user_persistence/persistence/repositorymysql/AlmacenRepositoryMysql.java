package com.sulluscocha.user_persistence.persistence.repositorymysql;

import com.sulluscocha.user_persistence.persistence.AlmacenDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepositoryMysql  extends JpaRepository<AlmacenDO,Integer> {
}
