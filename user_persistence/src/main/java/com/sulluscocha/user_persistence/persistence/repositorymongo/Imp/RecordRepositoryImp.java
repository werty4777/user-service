package com.sulluscocha.user_persistence.persistence.repositorymongo.Imp;


import com.sulluscocha.user_domain.domain.RecordUser;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;
import com.sulluscocha.user_persistence.persistence.RecordDO;
import com.sulluscocha.user_persistence.persistence.impl.RecordBuilderImp;
import com.sulluscocha.user_persistence.persistence.repositorymongo.RecordRepository;
import com.sulluscocha.user_persistence.persistence.repositorymongo.RecordRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RecordRepositoryImp implements RecordRepository {

    private final MongoTemplate mongoTemplate;
    private final RecordBuilderImp recordBuilderImp;
    private final RecordRepositoryMongo recordRepositoryMongo;

    @Autowired
    public RecordRepositoryImp(MongoTemplate mongoTemplate, RecordBuilderImp recordBuilderImp, RecordRepositoryMongo recordRepositoryMongo) {
        this.mongoTemplate = mongoTemplate;
        this.recordBuilderImp = recordBuilderImp;
        this.recordRepositoryMongo = recordRepositoryMongo;
    }


    @Override
    public void registrarUsuario(RecordUser recordUser) throws RuntimeException {


        RecordDO recordDO = this.recordBuilderImp.fromRecord(recordUser);


        this.recordRepositoryMongo.save(recordDO);


    }

    @Override
    public void limpiarHistorial() {
        this.recordRepositoryMongo.deleteAll();
        System.out.println("historial limpiado");
    }

    @Override
    public RecordUser buscarPorToken(String token) throws RecordNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("token").is(token));

        RecordDO one = this.mongoTemplate.findOne(query, RecordDO.class);
        Optional<RecordDO> op = Optional.ofNullable(one);
        return this.recordBuilderImp.toRecord(op.orElseThrow(() -> new RecordNotFoundException("Error token invalido")));


    }
}
