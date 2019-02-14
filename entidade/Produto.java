/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Produto {
private int codigo;
private String descricao;
private double valorCompra;
private double valorVenda;
private int grupoProdutos;
private int quantidade;
private int compra;
private int venda;
private Date dataCadastro;
dao.CompraDAO objCompraDAO = new dao.CompraDAO();
dao.VendaDAO objVendaDAO = new dao.VendaDAO();
List<Produto> produtosCompra = new ArrayList();
List<Produto> produtosVenda = new ArrayList(); 
List<Venda> vendas = new ArrayList();  
dao.ProdutoDAO objProdutoDAO = new dao.ProdutoDAO();
 Calendar calendar = new GregorianCalendar(); 
    Date date = new Date();



    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getGrupoProdutos() {
        return grupoProdutos;
    }

    public void setGrupoProdutos(int grupoProdutos) {
        this.grupoProdutos = grupoProdutos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
public int retornaEstoque()
{
    int quantCompra=0;
    int quantVenda=0;
   produtosCompra = objCompraDAO.consultarItensCompra("IdProduto", codigo);
   produtosVenda = objVendaDAO.consultarItensVenda("IdProduto", codigo);
   for(Produto p: produtosCompra)
   {
       quantCompra = quantCompra + p.getQuantidade();
   }
   for(Produto p: produtosVenda)
   {
       quantVenda = quantVenda + p.getQuantidade();
   }
   return quantCompra - quantVenda;
} 
public int quantSugerida(int dias, String margem)
{
    List<Produto> produtos = new ArrayList();
    int quantidadevenda=0;
    double porcentagem = Double.parseDouble("0."+margem);
    produtos = objVendaDAO.ConsultaItensVenda(codigo);
    for(Produto p: produtos)
    {
        quantidadevenda = quantidadevenda + p.getQuantidade();
    }
    calendar.setTime(date); 
    long quantdias = diasVenda(objProdutoDAO.consultar((long)codigo).getDataCadastro(),calendar.getTime());
    double quantPorDia = (double)quantidadevenda/quantdias;
   double quantSugerida = quantPorDia*dias +(1*(quantPorDia*dias)*porcentagem);
   if((int)quantSugerida>retornaEstoque())
   {
       return (int) quantSugerida-retornaEstoque();
   }
   else 
   {
       return 0;
   }
}
public long diasVenda(Date dataIni, Date dataFin)
{
      Long dt = (dataFin.getTime()-dataIni.getTime())+3600000;
      long dias = (dt/86400000L);
      return dias;
}

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
