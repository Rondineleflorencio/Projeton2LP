package model.dao;
import java.util.ArrayList;
import java.util.List;
import model.DiaApanha;
import model.Supplier;
import model.bean.supplier.ReadBD;
import model.bean.supplier.DeleteSupplier;
import model.bean.supplier.InsertSupplier;
public class SupplierDao 
{
    public void insert(Supplier supplier)
    {
        InsertSupplier.post(supplier);
    }
     public void delete(Supplier supplier)
    {
        DeleteSupplier.delete(supplier);
    }
     public List<Supplier> read()
    {
        List<Supplier> supplier = new ArrayList<>();
        supplier = ReadBD.read();
        
        return supplier;
    }
}
