package com.project.api.controler;
import com.project.api.controler.request.SupplierRequest;
import com.project.api.controler.response.SupplierResponse;
import com.project.core.ports.driver.supplierDriver.CreateSupplierPort;
import com.project.core.ports.driver.supplierDriver.DeleteSupplierPort;
import org.springframework.web.bind.annotation.*;
import com.project.core.ports.driver.supplierDriver.FindSupplier;

@RestController
@RequestMapping("supplier")
public record SupplierController (
        CreateSupplierPort createSuppier,
        DeleteSupplierPort deleteSupplier,
        FindSupplier find)
{
    @PostMapping
    public SupplierResponse post(@RequestBody SupplierRequest request){
        var supplier = request.toSupplier();
        supplier = createSuppier.apply(supplier);
        return new SupplierResponse().fromSupplier(supplier);
    }
    @DeleteMapping
    public void delete(@PathVariable String id)
    {
        this.findById(id);
    }
    
    @GetMapping
    public SupplierResponse findById(@PathVariable String id)
    {
        var supplier = find.apply(id);
        return new SupplierResponse().fromSupplier(supplier);
    }
}
