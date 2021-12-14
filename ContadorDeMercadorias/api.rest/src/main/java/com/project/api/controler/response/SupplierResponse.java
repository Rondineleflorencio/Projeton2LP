package com.project.api.controler.response;
import com.project.core.domain.Supplier;
import lombok.Getter;

@Getter
public class SupplierResponse {
    private int id;
    private String name;
    private String contato;
    private String password;
    
    public SupplierResponse fromSupplier(Supplier supplier){
        this.id = supplier.getId();
        this.name = supplier.getName();
        this.contato = supplier.getContato();
        this.password = supplier.getPassword();
        
        return this;
    }
}
