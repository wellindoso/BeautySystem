
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO extends DAOGenerico<Cliente, Long>{
   
      @Override
    public void gravar(Cliente entidade) throws NullPointerException{
        try{
            setSql("INSERT INTO clientes (Nome, CPF, Telefone, Logradouro, Numero, Bairro, Cidade, Estado, Situacao, Celular, RG, DataNascCli, Observacao,CEP) "+
                    "VALUES ('"+entidade.getNome()+"', '"+entidade.getCpf()+"', '"+entidade.getTelefone()+"', "+
                    "'"+entidade.getLogradouro()+"', "+entidade.getNumero()+", '"+entidade.getBairro()+"', '"+entidade.getCidade()+"', "+
                    "'"+entidade.getEstado()+"', '"+entidade.getSituacao()+"', '"+entidade.getCelular()+"', '"+entidade.getRg()+"', '"+entidade.getDataNascCli()+"','"+entidade.getObservacaoCli()+"','"+entidade.getCep()+"')");
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
    public void editar(Cliente entidade) throws NullPointerException {
         try{
           setSql("UPDATE clientes set Nome='"+entidade.getNome()+"', RG='"+entidade.getRg()+"', CPF='"+entidade.getCpf()+"', Logradouro='"+entidade.getLogradouro()+"', Numero="+entidade.getNumero()+
                    ", Bairro='"+entidade.getBairro()+"', Cidade='"+entidade.getCidade()+"', Estado='"+entidade.getEstado()+"', Situacao='"+entidade.getSituacao()+"', Telefone='"+entidade.getTelefone()+"'"+
                ", Celular='"+entidade.getCelular()+"', DataNascCli='"+entidade.getDataNascCli()+"', CEP='"+entidade.getCep()+"', Observacao='"+entidade.getObservacaoCli()+"' WHERE IdCliente = "+entidade.getCodigo());
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
    public void excluir(Cliente entidade) throws NullPointerException {
        try{
            setSql("DELETE FROM clientes WHERE IdCliente = "+entidade.getCodigo()+";");
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
    public List<Cliente> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
        List<Cliente> listaClientes = new ArrayList();
        if(tipoPesquisa==1){
        try{
            setSql("SELECT * FROM clientes WHERE "+campo+" like '%"+palavraChave+"%' and Situacao = 'Bloqueado' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaClientes.add(retornaResultado(result));
            }
            
            return listaClientes;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        }
        else if (tipoPesquisa==2)
        {
            try{
            setSql("SELECT * FROM clientes WHERE "+campo+" like '%"+palavraChave+"%' and Situacao = 'Desbloqueado' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaClientes.add(retornaResultado(result));
            }
            
            return listaClientes;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        }
        else if (tipoPesquisa==3)
        {
            try{
            setSql("SELECT * FROM clientes WHERE "+campo+" like '%"+palavraChave+"%' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaClientes.add(retornaResultado(result));
            }
            
            return listaClientes;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        }
            
        return null;
    }

    @Override
    public Cliente consultar(Long codigo) throws NullPointerException {
        Cliente cliente= new Cliente();
        try{
            setSql("SELECT * FROM clientes WHERE IdCliente = "+codigo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                cliente = retornaResultado(result);
            }
            
            return cliente;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    private Cliente retornaResultado(ResultSet result) throws NullPointerException{
        Cliente temp = new Cliente();
        try {
            temp.setCodigo(result.getInt("IdCliente"));
            temp.setNome(result.getString("Nome"));
            temp.setRg(result.getString("RG"));
            temp.setCpf(result.getString("CPF"));
            temp.setLogradouro(result.getString("Logradouro"));
            temp.setNumero(result.getInt("Numero"));
            temp.setBairro(result.getString("Bairro"));
            temp.setCidade(result.getString("Cidade"));
            temp.setEstado(result.getString("Estado"));
            temp.setSituacao(result.getString("Situacao"));
            temp.setTelefone(result.getString("Telefone"));
            temp.setCelular(result.getString("Celular"));
            temp.setDataNascCli(result.getDate("DataNascCli"));
            temp.setObservacaoCli(result.getString("Observacao"));
            temp.setCep(result.getString("CEP"));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
}
