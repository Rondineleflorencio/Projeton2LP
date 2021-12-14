package com.project.api.controler;
import com.project.core.domain.Supplier;
import com.project.core.ports.driver.CreateSupplierPort;

public class NewMain {
    public static void main(String[] args) {
        CreateSupplierPort create = null;
        Supplier supplier = new Supplier();
        supplier.setId(7848);
        supplier.setContato("www");
        supplier.setName("fee");
        supplier.setPassword("qwqwq");
        create.apply(supplier);
    }
    
}
