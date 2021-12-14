package com.project.core.us.supplier;

import com.project.repository.mysql.connection.ConnectionFactory;
import com.project.core.ports.driven.email.EmailSender;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.project.core.domain.Supplier;
import com.project.core.domain.DiaApanha;
import com.project.core.confir.Confirmation;
import com.project.core.ports.driver.diaApanhaDriver.CreateTableDia;
import com.project.core.ports.driver.supplierDriver.CreateSupplierPort;
import org.springframework.stereotype.Service;

@Service
public record InsertSupplier(CreateTableDia dia) implements CreateSupplierPort
{
    @Override
    public Supplier apply(Supplier supplier)
    {
        if(Confirmation.supplierName(supplier.getName()))
        {
            Connection con = ConnectionFactory.getConnction();
            PreparedStatement stmt = null;
            try {
                stmt = con.prepareStatement("INSERT INTO suppliers (id, name, contato, password)VALUES(?,?,?,?)");
                stmt.setInt(1,supplier.getId());
                stmt.setString(2, supplier.getName());
                stmt.setString(3, supplier.getContato());
                stmt.setString(4, supplier.getPassword());

                
                dia.apply(supplier);
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
                EmailSender sender = new EmailSender();
                sender.apply(supplier.getContato(), "Voce foi registrado Com sucesso");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao salvar");
                Logger.getLogger(InsertSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                ConnectionFactory.closeConnection(con, stmt);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Falha ao salvar, Nome Não Pode Iniciar Com Um Numero");
        }
        return supplier;
    }

    
}
