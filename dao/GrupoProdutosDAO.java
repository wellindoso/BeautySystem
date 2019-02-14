/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.GrupoProdutos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mello_PC
 */
public class GrupoProdutosDAO extends DAOGenerico<GrupoProdutos, Long>{

    @Override
    public void gravar(GrupoProdutos entidade) throws NullPointerException {
        try{
            setSql("INSERT INTO `grupoproduto`(`Descricao`, `NCM`) VALUES ('"+entidade.getDescricao()+"', '"+entidade.getNcm()+"')");
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
    public void editar(GrupoProdutos entidade) throws NullPointerException {
        try{
           setSql("UPDATE grupoproduto SET Descricao= '"+entidade.getDescricao()+"',NCM='"+entidade.getNcm()+"' WHERE IdGrupoProduto = "+entidade.getCodigo());
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
    public void excluir(GrupoProdutos entidade) throws NullPointerException {
        try{
            setSql("DELETE FROM grupoproduto WHERE IdGrupoProduto = "+entidade.getCodigo()+";");
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
    public List<GrupoProdutos> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
        List<GrupoProdutos> listaGrupoProdutos = new ArrayList();
        try{
            setSql("SELECT * FROM grupoproduto WHERE "+campo+" like '%"+palavraChave+"%' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaGrupoProdutos.add(retornaResultado(result));
            }
            
            return listaGrupoProdutos;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        
        
            
        return null;
    }

    @Override
    public GrupoProdutos consultar(Long codigo) throws NullPointerException {
         GrupoProdutos objGrupoProdutos = new GrupoProdutos();
        try{
            setSql("SELECT * FROM grupoproduto WHERE IdGrupoProduto ="+codigo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                objGrupoProdutos =retornaResultado(result);
            }
            
            return objGrupoProdutos;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        
        
            
        return null;
    }
    
    private GrupoProdutos retornaResultado(ResultSet result) throws NullPointerException{
        GrupoProdutos temp = new GrupoProdutos();
        try {
            temp.setCodigo(result.getInt("IdGrupoProduto"));
            temp.setDescricao(result.getString("Descricao"));
            temp.setNcm(result.getString("NCM"));
           
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
    
}
