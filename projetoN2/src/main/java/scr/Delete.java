package scr;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Supplier;
import model.bean.supplier.DeleteSupplier;

public class Delete {
    public static void delete(String supplier)
    {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        
        
        try {
            
            stmt = con.prepareStatement("DROP TABLE "+supplier);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tabela "+supplier+" Deletada com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(DeleteSupplier.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
