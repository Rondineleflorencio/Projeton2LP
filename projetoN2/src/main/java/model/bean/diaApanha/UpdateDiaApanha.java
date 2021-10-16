package model.bean.diaApanha;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DiaApanha;
import scr.Confirmation;

public class UpdateDiaApanha 
{
    public static void update(DiaApanha a, String f) 
    {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        try {
            Confirmation c = new Confirmation();
            SimpleDateFormat data = c.correctFormat(a.getData());
            java.util.Date dat = data.parse(a.getData());
            java.sql.Date dt = new java.sql.Date(dat.getTime());
            Calendar cl = Calendar.getInstance();
            cl.setTime(dat);
            stmt = con.prepareStatement("UPDATE "+f+" SET CajuBom = ?, PBom = ?, CajuPoupa = ?, PPoupa = ?, Pago = ? WHERE Data = ?");
         
            stmt.setDouble(1, a.getQtdBom());
            stmt.setDouble(2, a.getPrecoBom());
            stmt.setDouble(3, a.getQtdPoupa());
            stmt.setDouble(4, a.getPrecoPoupa());
            stmt.setBoolean(6, true);
            stmt.setDate(5, dt);
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "Falha ao Atualizar");
        } catch (ParseException ex) {
            Logger.getLogger(UpdateDiaApanha.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }    
}
