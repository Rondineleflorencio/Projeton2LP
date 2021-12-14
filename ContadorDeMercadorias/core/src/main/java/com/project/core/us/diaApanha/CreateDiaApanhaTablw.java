package com.project.core.us.diaApanha;

import com.project.repository.mysql.connection.ConnectionFactory;
import com.project.core.domain.Supplier;
import com.project.core.ports.driver.diaApanhaDriver.CreateTableDia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public record CreateDiaApanhaTablw() implements CreateTableDia
{
    @Override
    public Supplier apply(Supplier f)
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
        return f;
    }
}
