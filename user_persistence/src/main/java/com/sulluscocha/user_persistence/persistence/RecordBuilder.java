package com.sulluscocha.user_persistence.persistence;

import com.sulluscocha.types.types.RecordRequest;
import com.sulluscocha.user_domain.domain.RecordUser;

public interface RecordBuilder {

    RecordDO fromRecord(RecordUser recordUser);

    RecordUser toRecord(RecordDO recordDO);


}
