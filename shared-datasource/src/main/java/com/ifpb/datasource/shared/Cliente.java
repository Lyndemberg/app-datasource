
package com.ifpb.datasource.shared;

import java.io.Serializable;

/**
 *
 * @author lyndemberg
 */
public class Cliente implements Serializable{
    private String cpf;
    private String nome;

    public Cliente(){
        
    }
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
