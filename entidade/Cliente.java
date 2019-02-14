/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.Date;

/**
 *
 * @author Mello_PC
 */
public class Cliente extends Pessoa {
    private int codigo;
    private String nome;
    private String cpf;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String celular;
    private String situacao;
    private Date dataNascCli;
    private String observacaoCli;
    private String cep;

    public Date getDataNascCli() {
        return dataNascCli;
    }

    public void setDataNascCli(Date dataNascCli) {
        this.dataNascCli = dataNascCli;
    }

  
   
    
    public String getObservacaoCli() {
        return observacaoCli;
    }

    public void setObservacaoCli(String observacaoCli) {
        this.observacaoCli = observacaoCli;
    }
    
   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    
    
}
