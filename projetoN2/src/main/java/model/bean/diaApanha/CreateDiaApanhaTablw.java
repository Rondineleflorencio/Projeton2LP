package model.bean.diaApanha;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Supplier;

public class CreateDiaApanhaTablw 
{
    public static void createTable(Supplier f)
    {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("CREATE TABLE `dbsafra`.`"+f.getName()+"` (\n" +
"  `Data` DATE NOT NULL,\n" +
"  `CajuBom` DOUBLE NULL,\n" +
"  `PBom` DOUBLE NULL,\n" +
"  `CajuPoupa` DOUBLE NULL,\n" +
"  `PPoupa` DOUBLE NULL,\n" +
"  `Pago` TINYINT NULL,\n" +
"  PRIMARY KEY (`Data`));");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CreateDiaApanhaTablw.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
