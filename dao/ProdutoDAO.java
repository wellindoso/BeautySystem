/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Produto;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO extends DAOGenerico<Produto, Long> {

    @Override
    public void gravar(Produto entidade) throws NullPointerException {
       try{
            setSql("INSERT INTO produto(Descricao, ValorCompra, ValorVenda, IdGrupoProduto, DataCadastro) VALUES"+ 
                    "('"+entidade.getDescricao()+"', "+entidade.getValorCompra()+","+entidade.getValorVenda()+","+entidade.getGrupoProdutos()+",'"+entidade.getDataCadastro()+"')");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            getConnection().commit();
        } catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        } 
    }

    @Override
    public void editar(Produto entidade) throws NullPointerException {
        try{
           setSql("UPDATE `produto` SET `Descricao`='"+entidade.getDescricao()+"',`ValorCompra`="+entidade.getValorCompra()+",`ValorVenda`="+entidade.getValorVenda()+",`IdGrupoProduto`="+entidade.getGrupoProdutos()+" WHERE IdProduto="+entidade.getCodigo());
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            getConnection().commit();
        } catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
    }

    @Override
    public void excluir(Produto entidade) throws NullPointerException {
    try{
            setSql("DELETE FROM produto WHERE IdProduto = "+entidade.getCodigo()+";");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            getConnection().commit();
        } catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }   
    }

    @Override
    public List<Produto> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
       List<Produto> listaprodutos = new ArrayList();
        try{
            setSql("SELECT * FROM produto WHERE "+campo+" like '%"+palavraChave+"%' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaprodutos.add(retornaResultado(result));
            }
            
            return listaprodutos;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
     public List<Produto> selecionarTodos()  {
       List<Produto> listaprodutos = new ArrayList();
        try{
            setSql("SELECT * FROM produto");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaprodutos.add(retornaResultado(result));
            }
            
            return listaprodutos;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
     

     
    @Override
    public Produto consultar(Long codigo) throws NullPointerException {
         Produto produto = new Produto();
        try{
            setSql("SELECT * FROM produto WHERE IdProduto ="+codigo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                produto=retornaResultado(result);
            }
            
            return produto;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    private Produto retornaResultado(ResultSet result) throws NullPointerException{
        Produto temp = new Produto();
        try {
            temp.setCodigo(result.getInt("IdProduto"));
            temp.setDescricao(result.getString("Descricao"));
            temp.setValorCompra(result.getDouble("ValorCompra"));
            temp.setValorVenda(result.getDouble("ValorVenda"));
            temp.setGrupoProdutos(result.getInt("IdGrupoProduto"));
            temp.setDataCadastro(result.getDate("DataCadastro"));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
}
