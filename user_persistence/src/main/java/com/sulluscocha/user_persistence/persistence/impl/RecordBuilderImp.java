package com.sulluscocha.user_persistence.persistence.impl;

import com.sulluscocha.types.types.RecordRequest;
import com.sulluscocha.user_domain.domain.RecordUser;
import com.sulluscocha.user_persistence.persistence.RecordBuilder;
import com.sulluscocha.user_persistence.persistence.RecordDO;
import org.springframework.stereotype.Component;

@Component
public class RecordBuilderImp implements RecordBuilder {
    @Override
    public RecordDO fromRecord(RecordUser recordUser) {


        RecordDO record = new RecordDO();

        record.setToken(recordUser.getToken());
        record.setSub(recordUser.getSub());
        record.setAud(recordUser.getAud());
        record.setScope(recordUser.getScope());
        record.setExp(recordUser.getExp());
        record.setEmail(recordUser.getEmail());
        record.setAccess_type(recordUser.getAccess_type());
        return record;


    }

    @Override
    public RecordUser toRecord(RecordDO recordDO) {


        RecordUser recordUser = new RecordUser();

        recordUser.setToken(recordDO.getToken());
        recordUser.setSub(recordDO.getSub());
        recordUser.setAud(recordDO.getAud());
        recordUser.setScope(recordDO.getScope());
        recordUser.setExp(recordDO.getExp());
        recordUser.setEmail(recordDO.getEmail());
        recordUser.setAccess_type(recordDO.getAccess_type());
        return recordUser;
    }



}
