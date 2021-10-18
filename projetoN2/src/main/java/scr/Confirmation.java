package scr;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        if(s.substring(0, 0).matches("0-9*"));
            System.out.println("tem numero");
        return true;
    }
}
