package model.bean.diaApanha;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaApanha;

public class ReadByTableNameDao 
{
    public static List<DiaApanha> readForName(String name) {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DiaApanha> apanhas = new ArrayList<>();

        try {
           
                stmt = con.prepareStatement("SELECT * FROM dbsafra. " + name);
                rs = stmt.executeQuery();
                while (rs.next()) 
                {
                    DiaApanha apanha = new DiaApanha();
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String dataFormatada = dateFormat.format(rs.getDate("Data"));
                    apanha.setData(dataFormatada);
                    apanha.setQtdBom(rs.getDouble("CajuBom"));
                    apanha.setPrecoBom(rs.getDouble("PBom"));
                    apanha.setQtdPoupa(rs.getDouble("CajuPoupa"));
                    apanha.setPrecoPoupa(rs.getDouble("PPoupa"));
                    apanha.setPago(rs.getBoolean("Pago"));
                    apanhas.add(apanha);
                }

        } catch (SQLException ex) {
            Logger.getLogger(ReadByTableNameDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return apanhas;
    }
}
