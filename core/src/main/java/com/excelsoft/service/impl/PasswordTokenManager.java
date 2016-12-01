package com.excelsoft.service.impl;

import com.excelsoft.model.Mstuser;


public interface PasswordTokenManager {

    /**
     * {@inheritDoc}
     */
    String generateRecoveryToken(Mstuser user);

    /**
     * {@inheritDoc}
     */
    boolean isRecoveryTokenValid(Mstuser user, String token);

    void invalidateRecoveryToken(Mstuser user, String token);
}