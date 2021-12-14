package com.project.core.ports.driver.supplierDriver;

import com.project.core.domain.Supplier;
public interface DeleteSupplierPort 
{
    void apply(Supplier supplier);
}
