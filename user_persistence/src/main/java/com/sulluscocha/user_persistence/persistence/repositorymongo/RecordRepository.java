package com.sulluscocha.user_persistence.persistence.repositorymongo;

import com.sulluscocha.user_domain.domain.RecordUser;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;

public interface RecordRepository {
    void registrarUsuario(RecordUser recordUser);

    void limpiarHistorial();

    RecordUser buscarPorToken(String token) throws RecordNotFoundException;
}
