package com.sulluscocha.user_application;

import com.sulluscocha.types.types.RecordRequest;
import com.sulluscocha.user_domain.domain.RecordUser;

public interface RecordedBuilder {

    RecordRequest toRequest(RecordUser recordUser);
    RecordUser  fromRecord(RecordRequest recordRequest);
}
