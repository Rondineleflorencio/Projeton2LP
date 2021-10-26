package scr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.Collectors;
import model.Supplier;
import model.dao.SupplierDao;

public class Confirmation 
{
    public SimpleDateFormat correctFormat(String s)
    {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dat;
        try {
            dat = data.parse(s);
        } catch (ParseException ex) {
            data = new SimpleDateFormat("dd-MM-yyyy");
        }
        return data;
    }
    public static boolean supplierName(String s)
    {
        return !s.substring(0, 0).matches("0-9*");
    }
    
    public static boolean loginValidation(String name, String password)
    {
        SupplierDao dao = new SupplierDao();
        System.out.println(password);
        String pass = String.valueOf((dao.readForName(name).getId()));
        if(password.equals(pass))
        {
            System.out.println("validou");
            return true;
        }
        System.out.println("789");
        return false;
    }
}
