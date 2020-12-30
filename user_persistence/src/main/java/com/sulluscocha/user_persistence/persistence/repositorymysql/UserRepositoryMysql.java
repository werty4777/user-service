package com.sulluscocha.user_persistence.persistence.repositorymysql;

import com.sulluscocha.user_persistence.persistence.UserDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMysql extends JpaRepository<UserDO, String> {




}
