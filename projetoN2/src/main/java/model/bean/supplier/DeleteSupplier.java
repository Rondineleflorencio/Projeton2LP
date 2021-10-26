package model.bean.supplier;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Supplier;

public class DeleteSupplier 
{
    public static void delete(Supplier supplier)
    {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("DELETE FROM suppliers where id = ? && name = ?");
            stmt.setInt(1, supplier.getId());
            stmt.setString(2, supplier.getName());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, supplier.getName()+"Deletado com Sucesso");
            stmt=null;
            stmt = con.prepareStatement("DROP TABLE "+supplier.getName());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tabela "+supplier.getName()+"Deletada com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(DeleteSupplier.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
