package scr;

import connection.email.EmailSender;
import model.Supplier;
import model.dao.SupplierDao;

public class Test {
   public static void main(String[] args) 
   {
       Supplier da = new Supplier();
       da.setContato("rondynelif@gmail.com");
       da.setName("rondinele");
       SupplierDao dao = null;
       dao.insert(da);
   }
    
}
