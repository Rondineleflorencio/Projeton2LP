package com.project.core.us.diaApanha;

import com.project.repository.mysql.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.project.core.domain.DiaApanha;
import com.project.core.confir.Confirmation;
import com.project.core.ports.driver.diaApanhaDriver.DeleteDate;

public record DeleteDiaApanha() implements DeleteDate
{
    @Override
    public void apply(DiaApanha a, String supplier) 
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
            stmt = con.prepareStatement("DELETE FROM "+supplier+" where Data = ?");
            stmt.setDate(1, dt);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "Falha ao Remover");
        } catch (ParseException ex) {
            Logger.getLogger(DeleteDiaApanha.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }    
}
