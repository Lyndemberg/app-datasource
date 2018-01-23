package com.ifpb.datasource.shared;

import java.util.List;

/**
 *
 * @author lyndemberg
 */
public interface Clientes {
    public boolean cadastrar(Cliente c);
    public Cliente read(String cpf);
    public List<Cliente> list();
}
