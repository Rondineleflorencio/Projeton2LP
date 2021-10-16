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
}
