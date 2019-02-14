/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Fornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author jose carlos
 */
public class FornecedorDAO extends DAOGenerico<Fornecedor, Long> {

    @Override
    public void gravar(Fornecedor entidade) throws NullPointerException {
       try{
            setSql("INSERT INTO fornecedor(IE, RazaoSocial, NomeFantasia, CNPJ, Logradouro, Numero, Bairro, Cidade, Estado, Pais, CEP, Descricao, Situacao) "+
                    "VALUES ('"+entidade.getIe()+"', '"+entidade.getRazaoSocial()+"', '"+entidade.getNomeFantasia()+"', "+
                    "'"+entidade.getCNPJ()+"', '"+entidade.getLogradouro()+"', "+entidade.getNumero()+", '"+entidade.getBairro()+"', "+
                    "'"+entidade.getCidade()+"', '"+entidade.getEstado()+"', '"+entidade.getPais()+"', '"+entidade.getCEP()+"', '"+entidade.getDescricao()+"','"+entidade.getSituacao()+"')");
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
    public void editar(Fornecedor entidade) throws NullPointerException {
         try{
           setSql("UPDATE fornecedor set IE='"+entidade.getIe()+"', RazaoSocial='"+entidade.getRazaoSocial()+"', NomeFantasia='"+entidade.getNomeFantasia()+"', CNPJ='"+entidade.getCNPJ()+"', Logradouro='"+entidade.getLogradouro()+
                    "', Numero="+entidade.getNumero()+", Bairro='"+entidade.getBairro()+"', Cidade='"+entidade.getCidade()+"', Estado='"+entidade.getEstado()+"', Pais='"+entidade.getPais()+"'"+
                ", CEP='"+entidade.getCEP()+"' WHERE IdFornecedor = "+entidade.getCodigo());
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
    public void excluir(Fornecedor entidade) throws NullPointerException {
        try{
            setSql("DELETE FROM fornecedor WHERE IdFornecedor = "+entidade.getCodigo()+";");
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
    public List<Fornecedor> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
        List<Fornecedor> listaFornecedores = new ArrayList();
        try{
            setSql("SELECT * FROM fornecedor WHERE "+campo+" like '%"+palavraChave+"%' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaFornecedores.add(retornaResultado(result));
            }
            
            return listaFornecedores;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        
        
            
        return null;
    }

    @Override
    public Fornecedor consultar(Long codigo) throws NullPointerException {
        Fornecedor proprietario = new Fornecedor();
        try{
            setSql("SELECT * FROM fornecedor WHERE IdFornecedor = "+codigo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                proprietario = retornaResultado(result);
            }
            return proprietario;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public Fornecedor retornaResultado(ResultSet result) throws NullPointerException{
        Fornecedor temp = new Fornecedor();
        try {
            temp.setCodigo(result.getInt("IdFornecedor"));
            temp.setIe(result.getString("IE"));
            temp.setRazaoSocial(result.getString("RazaoSocial"));
            temp.setNomeFantasia(result.getString("NomeFantasia"));
            temp.setCNPJ(result.getString("CNPJ"));
            temp.setLogradouro(result.getString("Logradouro"));
            temp.setNumero(result.getInt("Numero"));
            temp.setBairro(result.getString("Bairro"));
            temp.setCidade(result.getString("Cidade"));
            temp.setEstado(result.getString("Estado"));
            temp.setPais(result.getString("Pais"));
            temp.setCEP(result.getString("CEP"));
            temp.setDescricao(result.getString("Descricao"));
            temp.setSituacao(result.getString("Situacao"));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
    
    
}
