package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory 
{
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/dbsafra"; 
    private final static String USER = "root";
    private final static String PASS = "DDDoblivion8";
    
        public static Connection getConnction()
    {
        try 
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) 
        {
            throw new RuntimeException("Erro na conexão", ex);
        }        
    }
    
    public static void closeConnection(Connection con)
    {
        if(con!=null)
        {
            try 
            {
                con.close();
            } catch (SQLException ex) 
            {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection con,  PreparedStatement stmt)
    {
        closeConnection(con);
        if(stmt!=null)
        {
            try 
            {
                stmt.close();
            } catch (SQLException ex) 
            {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection con,  PreparedStatement stmt, ResultSet rs)
    {
        closeConnection(con, stmt);
        if(rs!=null)
        {
            try 
            {
                rs.close();
            } catch (SQLException ex) 
            {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
