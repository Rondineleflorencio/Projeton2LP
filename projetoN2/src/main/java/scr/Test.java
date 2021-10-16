package scr;

import model.Supplier;
import model.dao.SupplierDao;

public class Test {
   public static void main(String[] args) 
   {
       Supplier supplier = new Supplier();
       SupplierDao sup = new SupplierDao();
       supplier.setId(1234);
       supplier.setName("rondinele");
       sup.insert(supplier);
       sup.delete(supplier);
       System.out.println("scr.Test.main()");
   }
    
}
