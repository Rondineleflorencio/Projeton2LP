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

public class ReadByDate {
    public static List<DiaApanha> readForDate(int dat, String sql, String table) {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> tab = new ArrayList<>();
        List<DiaApanha> apanhas = new ArrayList<>();

        try {
                stmt = con.prepareStatement("SELECT * FROM " + table + " WHERE " + sql + " = ?");
                stmt.setInt(1, dat);
                rs = stmt.executeQuery();
                while (rs.next()) 
                {
                    DiaApanha apanha = new DiaApanha();
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String dataFormatada = dateFormat.format(rs.getDate("idDias_safra"));
                    apanha.setData(dataFormatada);
                    apanha.setQtdBom(rs.getDouble("CajuBom"));
                    apanha.setPrecoBom(rs.getDouble("PBom"));
                    apanha.setQtdPoupa(rs.getDouble("CajuPoupa"));
                    apanha.setPrecoPoupa(rs.getDouble("PPoupa"));
                    apanha.setPago(rs.getBoolean("Pago"));
                    apanhas.add(apanha);
                }
            

        } catch (SQLException ex) {
            Logger.getLogger(ReadByDate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return apanhas;
    }

}    

