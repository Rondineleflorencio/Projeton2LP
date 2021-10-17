package model.bean.supplier;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Supplier;

public class UpdateSupplier 
{
    public static void update(Supplier fornecedor)
    {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("Update Supplier set name = ?, contato, ? where name = ? && id = ?");
            stmt.setString(1, fornecedor.getName());
            stmt.setString(2, fornecedor.getContato());
            stmt.setString(3, fornecedor.getName());
            stmt.setInt(2, fornecedor.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
        } catch (SQLException ex) {
            System.out.print(ex);
            JOptionPane.showMessageDialog(null, "Falha ao Atualizar");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
