package model.bean.diaApanha;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateJbox 
{
    public static List<String> jBoxTables()
    {
        {
            Connection con = ConnectionFactory.getConnction();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<String> tab = new ArrayList<>();

            try {
                stmt = con.prepareStatement("show tables;");
                rs = stmt.executeQuery();
                while(rs.next())
                {
                    if(rs.getString("Tables_in_dbsafra")!="suppliers"){
                         tab.add(rs.getString("Tables_in_dbsafra"));
                    }
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(CreateJbox.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
        }
    }   
}