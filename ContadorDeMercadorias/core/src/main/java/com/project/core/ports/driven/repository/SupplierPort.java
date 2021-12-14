package com.project.core.ports.driven.repository;
import com.project.core.domain.Supplier;
import java.util.Optional;

public interface SupplierPort {
    Supplier save(Supplier supplier);
    Optional<Supplier> findByName(String id);
    void deleteByname(Supplier supplier);
}
