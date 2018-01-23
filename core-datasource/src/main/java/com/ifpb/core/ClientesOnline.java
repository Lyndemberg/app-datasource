package com.ifpb.core;

import com.ifpb.core.dao.ClienteDao;
import com.ifpb.datasource.shared.Cliente;
import com.ifpb.datasource.shared.Clientes;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author lyndemberg
 */
@Stateless
@Remote(Clientes.class)
public class ClientesOnline implements Clientes{
    @EJB
    private ClienteDao dao;
    @Override
    public boolean cadastrar(Cliente c) {
        return dao.create(c);
    }

    @Override
    public Cliente read(String cpf) {
        return dao.read(cpf);
    }

    @Override
    public List<Cliente> list() {
        return Collections.unmodifiableList(dao.list());
    }
    
}
