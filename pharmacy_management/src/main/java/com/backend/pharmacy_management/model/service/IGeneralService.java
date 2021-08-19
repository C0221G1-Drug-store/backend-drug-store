package com.backend.pharmacy_management.model.service;

import java.util.Optional;

public interface IGeneralService<T> {

    Optional<T> findById(Long id);

    void remove(Long id);
}
