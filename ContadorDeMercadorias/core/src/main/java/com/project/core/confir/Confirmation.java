package com.project.core.confir;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.project.core.domain.Supplier;
import com.project.core.ports.driver.supplierDriver.FindSupplier;

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
        Supplier dao = new Supplier();
        FindSupplier find = null;
        dao = find.apply(name);
        String pass = String.valueOf((dao.getPassword()));
        if(password.equals(pass))
        {
            System.out.println("validou");
            return true;
        }
        System.out.println("789");
        return false;
    }
}
