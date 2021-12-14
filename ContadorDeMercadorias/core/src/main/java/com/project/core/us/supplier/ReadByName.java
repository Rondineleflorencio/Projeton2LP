package com.project.core.us.supplier;

import com.project.repository.mysql.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.project.core.domain.Supplier;
import com.project.core.ports.driver.supplierDriver.FindSupplier;
import org.springframework.stereotype.Service;

@Service
public record ReadByName() implements FindSupplier
{
    @Override
    public Supplier apply(String name)
    {
        Connection con = ConnectionFactory.getConnction();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Supplier repository = new Supplier();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM suppliers WHERE Name = ?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                repository.setName(rs.getString("Name"));
                repository.setContato(rs.getString("contato"));
                repository.setId(rs.getInt("Id"));
                repository.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadByName.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return repository;
    }
}
