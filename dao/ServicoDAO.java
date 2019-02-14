/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Servico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Mello_PC
 */
public class ServicoDAO extends DAOGenerico<Servico, Long>{

    @Override
    public void gravar(Servico entidade) throws NullPointerException {
       try{
            setSql("INSERT INTO `servico`(`Descricao`, `ValorMaoDeObra`) VALUES ('"+entidade.getDescricao()+"', '"+entidade.getValorMaoDeObra()+"')");
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
    public void editar(Servico entidade) throws NullPointerException {
        try{
           setSql("UPDATE servico SET Descricao= '"+entidade.getDescricao()+"',ValorMaoDeObra='"+entidade.getValorMaoDeObra()+"' WHERE IdServico = "+entidade.getCodigo());
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
    public void excluir(Servico entidade) throws NullPointerException {
        try{
            setSql("DELETE FROM servico WHERE IdServico = "+entidade.getCodigo()+";");
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
    public List<Servico> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
        List<Servico> listaservicos = new ArrayList();
        try{
            setSql("SELECT * FROM servico WHERE "+campo+" like '%"+palavraChave+"%' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaservicos.add(retornaResultado(result));
            }
            
            return listaservicos;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }

    @Override
    public Servico consultar(Long codigo) throws NullPointerException {
        Servico servico = new Servico();
        try
        {
            setSql("SELECT * FROM servico WHERE IdServico ="+codigo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                servico=retornaResultado(result);
            }
            
            return servico;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
         return null;       
    }
    
    private Servico retornaResultado(ResultSet result) throws NullPointerException{
        Servico temp = new Servico();
        try {
            temp.setCodigo(result.getInt("IdServico"));
            temp.setDescricao(result.getString("Descricao"));
           temp.setValorMaoDeObra(result.getDouble("ValorMaoDeObra"));
           
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
    
}
