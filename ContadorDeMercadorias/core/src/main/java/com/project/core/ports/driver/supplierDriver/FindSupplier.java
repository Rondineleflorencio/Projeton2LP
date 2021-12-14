package com.project.core.ports.driver.supplierDriver;
import com.project.core.domain.Supplier;

public interface FindSupplier 
{
    Supplier apply(String name);
}
