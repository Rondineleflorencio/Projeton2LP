package com.project.api.controler.request;
import com.project.core.domain.Supplier;
import lombok.Setter;

@Setter
public class SupplierRequest {
    private int id;
    private String name;
    private String contato;
    private String password;
    
    public Supplier toSupplier()
    {
        var supplier = new Supplier();
        
        supplier.setContato(contato);
        supplier.setId(id);
        supplier.setName(name);
        supplier.setPassword(password);
        
        return supplier;
    }
}
