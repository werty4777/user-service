package com.sulluscocha.user_persistence.persistence.repositorymysql;

import com.sulluscocha.user_persistence.persistence.RolesDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositoryMysql extends JpaRepository<RolesDO, Integer> {
}
