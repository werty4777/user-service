package com.sulluscocha.user_application.Imp;

import com.sulluscocha.types.types.RecordRequest;
import com.sulluscocha.user_application.RecordService;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;
import com.sulluscocha.user_persistence.persistence.repositorymongo.Imp.RecordRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImp implements RecordService {

    private final RecordRepositoryImp recordRepositoryImp;
    private final RecordedBuilderImp recordBuilderImp;

    @Autowired
    public RecordServiceImp(RecordRepositoryImp recordRepositoryImp, RecordedBuilderImp recordBuilderImp) {
        this.recordRepositoryImp = recordRepositoryImp;

        this.recordBuilderImp = recordBuilderImp;
    }

    @Override
    public RecordRequest obtenerRecord(String token) throws RecordNotFoundException {


        return this.recordBuilderImp.toRequest(this.recordRepositoryImp.buscarPorToken(token));


    }

    @Override
    public boolean guardarRecord(RecordRequest recordRequest) {


        try {
            this.recordRepositoryImp.registrarUsuario(this.recordBuilderImp.fromRecord(recordRequest));

            return true;
        } catch (Exception ex) {
            return false;
        }


    }
}
