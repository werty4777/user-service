package com.sulluscocha.user_persistence.persistence.repositorymongo;

import com.sulluscocha.user_persistence.persistence.RecordDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RecordRepositoryMongo extends MongoRepository<RecordDO, String> {


}
