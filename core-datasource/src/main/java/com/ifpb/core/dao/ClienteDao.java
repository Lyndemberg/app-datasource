package com.ifpb.core.dao;

import com.ifpb.datasource.shared.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author lyndemberg
 */

@Stateless
public class ClienteDao {
    @Resource(name="java:app/jdbc/myDatasource")
    private DataSource dataSource;
    
    public boolean create(Cliente novo){
        try(Connection con = dataSource.getConnection()) {
            PreparedStatement st = con.prepareStatement("INSERT INTO cliente (cpf,nome) VALUES (?,?)");
            st.setString(1, novo.getCpf());
            st.setString(2, novo.getNome());
            int retorno = st.executeUpdate();
            st.close();
            return retorno>0;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Cliente read(String cpf){
        Cliente c = null;
        try(Connection con = dataSource.getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM cliente WHERE cpf=?");
            st.setString(1, cpf);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                c = new Cliente(rs.getString("cpf"), rs.getString("nome"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    public List<Cliente> list(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try(Connection con = dataSource.getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                clientes.add(new Cliente(rs.getString("cpf"), rs.getString("nome")));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
