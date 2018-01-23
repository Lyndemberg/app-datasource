
package com.ifpb.datasource.web;

import com.ifpb.datasource.shared.Cliente;
import com.ifpb.datasource.shared.Clientes;
import com.ifpb.datasource.shared.ServiceLocator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author lyndemberg
 */
@Named
@RequestScoped
public class ControladorCliente {
    private Cliente cliente = new Cliente();
    private Clientes clientes;
    
    @PostConstruct
    public void init(){
        clientes = new ServiceLocator().lookup("java:global/core-datasource/ClientesOnline");
    }
    public String salvar(){
        if(clientes.cadastrar(cliente)){
            return "listar.xhtml";
        }else{
            return null;
        }
    }
    public List<Cliente> listar(){
        return clientes.list();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
