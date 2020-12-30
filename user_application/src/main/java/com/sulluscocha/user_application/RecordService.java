package com.sulluscocha.user_application;

import com.sulluscocha.types.types.RecordRequest;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;

public interface RecordService {


    RecordRequest obtenerRecord(String token) throws RecordNotFoundException;

    boolean guardarRecord(RecordRequest recordRequest);
}
