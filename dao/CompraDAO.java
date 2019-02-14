/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Compra;
import entidade.Produto;
import entidade.Fornecedor;
import entidade.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vanes
 */
public class CompraDAO extends DAOGenerico<Compra, Long>{
    dao.FornecedorDAO objFornecedorDAO = new dao.FornecedorDAO();
    Fornecedor objFornecedor = new Fornecedor();
    Funcionario objFuncionario = new Funcionario();
    dao.FuncionarioDAO objFuncionarioDAO = new dao.FuncionarioDAO();
    @Override
    public void gravar(Compra entidade) {
        try{
            //Para a Compra e Venda a chave primÃ¡ria nÃ£o Ã© auto-incremento!
            int codigo = retornaCodigo();
            setSql("INSERT INTO compra (IdCompra, IdFuncionario, DataCompra , ValorCompra, IdFornecedor) "+
                    "VALUES ("+entidade.getCodigo()+", "+entidade.getFuncionario().getCodigo()+", '"+entidade.getDataCompra()+"', '"+entidade.getValorCompra()+"', '"+entidade.getFornecedor().getCodigo()+"')");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            for (Produto p:entidade.getProdutos()){
                setSql("INSERT INTO itemcompra (IdProduto,IdCompra,Descricao, ValorCompra, ValorVenda, Quantidade) VALUES"
                        + " ("+p.getCodigo()+", "+codigo+",'"+p.getDescricao()+"', '"+p.getValorCompra()+"','"+p.getValorVenda()+"', '"+p.getQuantidade()+"');");
                setCommand(getConnection().prepareStatement(getSql()));
                getCommand().execute();
            }            
            getConnection().commit();
        } catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
    }

    @Override
    public void editar(Compra entidade) throws NullPointerException {
        try{
           setSql("UPDATE compra set IdFuncionario='"+entidade.getFuncionario().getCodigo()+"', IdFornecedor='"+entidade.getFornecedor().getCodigo()+"', DataCompra='"+entidade.getDataCompra()+"', ValorCompra='"+entidade.getValorCompra()+
                   "' WHERE IdCompra = "+entidade.getCodigo());
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            setSql("DELETE FROM itemcompra WHERE IdCompra = "+entidade.getCodigo()+";");
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            for (Produto p:entidade.getProdutos()){
                setSql("INSERT INTO itemcompra (IdProduto,IdCompra,Descricao, ValorCompra, ValorVenda, Quantidade) VALUES"
                        + " ("+p.getCodigo()+", "+entidade.getCodigo()+",'"+p.getDescricao()+"', '"+p.getValorCompra()+"','"+p.getValorVenda()+"', '"+p.getQuantidade()+"');");
                setCommand(getConnection().prepareStatement(getSql()));
                getCommand().execute();
            }
            getConnection().commit();
        } catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
    }

    @Override
    public void excluir(Compra entidade) throws NullPointerException {
        try{
            setSql("DELETE FROM itemcompra WHERE IdCompra = "+entidade.getCodigo()+";");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            setSql("DELETE FROM compra WHERE IdCompra = "+entidade.getCodigo()+";");
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            getConnection().commit();
        }
         catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
    }

    

    public List<Compra> consultar(String campo, String palavraChave) throws NullPointerException {
        List<Compra> listaCompra = new ArrayList();
        objFornecedor = objFornecedorDAO.consultar(Long.parseLong(palavraChave));
        try{
            setSql("SELECT * FROM compra WHERE "+campo+" like '%"+palavraChave+"%' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaCompra.add(retornaResultado(result));
            }
            
            return listaCompra;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public List<Compra> consultarPorData(String dataIni, String dataFin) throws NullPointerException {
        List<Compra> listaCompra = new ArrayList();
        try{
            setSql("SELECT * FROM compra WHERE DataCompra between '"+dataIni+"' and '"+dataFin+"' ORDER BY DataCompra");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaCompra.add(retornaResultado(result));
            }
            
            return listaCompra;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public List<Produto> consultarItensCompra(String campo, int codipro ) throws NullPointerException {
       List<Produto> listaprodutos = new ArrayList();
        try{
            setSql("SELECT * FROM itemcompra WHERE "+campo+" ="+codipro);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaprodutos.add(retornaResultadoItem(result));
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
 
    
    public List<Produto> consultarItens(String campo, String palavraChave) throws NullPointerException {
        List<Produto> listaItem = new ArrayList();
        try{
            setSql("SELECT * FROM itemcompra WHERE "+campo+" ="+palavraChave);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaItem.add(retornaResultadoItem(result));
            }
            
            return listaItem;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public int retornaCodigo(){
        int codigo = 0;
        setSql("SELECT MAX(IdCompra) FROM compra");
        abrirConexao();
        try {
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                codigo = result.getInt(1);
            }
        } catch (SQLException ex) {
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+ex);
        }finally{
            fecharConexao();
        }
        return ++codigo;
    }
    
    private Compra retornaResultado(ResultSet result) throws NullPointerException{
        Compra temp = new Compra();
        try {
            temp.setCodigo(result.getInt("IdCompra"));
            temp.setDataCompra(result.getDate("DataCompra"));
            temp.setFornecedor(objFornecedorDAO.consultar(Long.parseLong(result.getString("IdFornecedor"))));
            int codiFunc = result.getInt("IdFuncionario");
            temp.setFuncionario(objFuncionarioDAO.consultar(Long.parseLong(Integer.toString(codiFunc))));
            temp.setValorCompra(result.getDouble("ValorCompra"));
            temp.setProdutos(consultarItens("IdCompra",Integer.toString(result.getInt("IdCompra"))));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
    
    private Produto retornaResultadoItem(ResultSet result) throws NullPointerException{
        Produto temp = new Produto();
        try {
            temp.setCodigo(result.getInt("IdProduto"));
            temp.setDescricao(result.getString("Descricao"));
            temp.setQuantidade(result.getInt("Quantidade"));
            temp.setValorCompra(result.getDouble("ValorCompra"));
            temp.setValorVenda(result.getDouble("ValorVenda"));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
    @Override
    public List<Compra> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra consultar(Long codigo) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}