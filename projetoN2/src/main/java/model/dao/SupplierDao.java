package model.dao;
import java.util.ArrayList;
import java.util.List;
import model.Supplier;
import model.bean.supplier.ReadBD;
import model.bean.supplier.DeleteSupplier;
import model.bean.supplier.InsertSupplier;
import model.bean.supplier.ReadByName;
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
     public Supplier readForName(String name)
     {
        return ReadByName.readname(name);
     }
}
