package model.bean.supplier;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaApanha;
import model.Supplier;

public class ReadBD 
{
     public static List<Supplier> read()
     {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Supplier repository = new Supplier();
        List<Supplier> suppliers = new ArrayList<>();
        
         try {
             stmt = con.prepareStatement("SELECT * FROM dbsafra.suppliers;");
             rs = stmt.executeQuery();
             
             while(rs.next())
            {
                repository.setName(rs.getString("name"));
                repository.setContato(rs.getString("contato"));
                repository.setId(rs.getInt("id"));
                
                suppliers.add(repository);
            }
         } catch (SQLException ex) {
             Logger.getLogger(ReadBD.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return suppliers;
     }
}
