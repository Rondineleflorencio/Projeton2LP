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
import com.project.core.ports.driver.diaApanhaDriver.InsertDate;

public record InsertDiaApanha() implements InsertDate 
{
    @Override
    public DiaApanha apply(DiaApanha a, String supplier) {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        try {
            Confirmation c = new Confirmation();
            SimpleDateFormat data = c.correctFormat(a.getData());
            java.util.Date dat = data.parse(a.getData());
            java.sql.Date dt = new java.sql.Date(dat.getTime());
            Calendar cl = Calendar.getInstance();
            cl.setTime(dat);
            stmt = con.prepareStatement("INSERT INTO " + supplier + " (Data, CajuBom, PBom, CajuPoupa, PPoupa, Pago)VALUES(?,?,?,?,?,?)");
            stmt.setDate(1, dt);
            stmt.setDouble(2, a.getQtdBom());
            stmt.setDouble(3, a.getPrecoBom());
            stmt.setDouble(4, a.getQtdPoupa());
            stmt.setDouble(5, a.getPrecoPoupa());
            stmt.setBoolean(6, a.isPago());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "Falha ao salvar");
        } catch (ParseException ex) {
            Logger.getLogger(InsertDiaApanha.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex + "\n\n\n");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return a;
    }
}
