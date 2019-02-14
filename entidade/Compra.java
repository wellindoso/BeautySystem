/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 *
 * @author Mello_PC
 */
public class Compra {
    private int codigo;
    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private Date dataCompra;
    private double valorCompra;
    private List<entidade.Produto> produtos = new ArrayList();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public List<entidade.Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<entidade.Produto> produtos) {
        this.produtos = produtos;
    }
    
}
