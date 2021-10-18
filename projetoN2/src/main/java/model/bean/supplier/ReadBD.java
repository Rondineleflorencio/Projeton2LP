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
import model.Supplier;

public class ReadBD 
{
     public static List<Supplier> read()
     {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Supplier> suppliers = new ArrayList<>();
        int i = 0;
         try {
             stmt = con.prepareStatement("SELECT * FROM suppliers");
             rs = stmt.executeQuery();
             
             while(rs.next())
            {
                Supplier repository = new Supplier();
                repository.setName(rs.getString("Name"));
                repository.setContato(rs.getString("contato"));
                repository.setId(rs.getInt("Id"));
                
                suppliers.add(repository);
                System.out.println(suppliers.get(i).getName());
            }
         } catch (SQLException ex) {
             Logger.getLogger(ReadBD.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             ConnectionFactory.closeConnection(con, stmt, rs);
         }
        for(Supplier a: suppliers){
            System.out.println(suppliers.get(i).getName());
            i++;
        }
        return suppliers;
     }
}
