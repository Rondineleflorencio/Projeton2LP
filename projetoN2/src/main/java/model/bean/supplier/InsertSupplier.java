package model.bean.supplier;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Supplier;
import model.dao.DiaApanhaDao;

public class InsertSupplier 
{
    public static void create(Supplier supplier)
    {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO suppliers (id, name, contato)VALUES(?,?,?)");
            stmt.setInt(1,supplier.getId());
            stmt.setString(2, supplier.getName());
            stmt.setString(3, supplier.getContato());
            
            stmt.executeUpdate();
            DiaApanhaDao daoapanha = new DiaApanhaDao();
            daoapanha.create(supplier);
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar");
            Logger.getLogger(InsertSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}