package com.sulluscocha.user_application.Imp;


import com.sulluscocha.types.types.RecordRequest;
import com.sulluscocha.user_application.RecordedBuilder;
import com.sulluscocha.user_domain.domain.RecordUser;
import org.springframework.stereotype.Component;

@Component("builder")
public class RecordedBuilderImp implements RecordedBuilder {


    @Override
    public RecordRequest toRequest(RecordUser recordUser) {
        RecordRequest request = new RecordRequest();
        request.setToken(recordUser.getToken());
        request.setSub(recordUser.getSub());
        request.setAud(recordUser.getAud());
        request.setScope(recordUser.getScope());
        request.setExp(recordUser.getExp());
        request.setEmail(recordUser.getEmail());
        request.setAccess_type(recordUser.getAccess_type());
        return request;
    }

    @Override
    public RecordUser fromRecord(RecordRequest recordRequest) {

        RecordUser recordUser = new RecordUser();

        recordUser.setToken(recordRequest.getToken());
        recordUser.setSub(recordRequest.getSub());
        recordUser.setAud(recordRequest.getAud());
        recordUser.setScope(recordRequest.getScope());
        recordUser.setExp(recordRequest.getExp());
        recordUser.setEmail(recordRequest.getEmail());
        recordUser.setAccess_type(recordRequest.getAccess_type());

        return recordUser;

    }
}
