/*("INSERT INTO `funcionario`(`Nome`, `NomeDeUsuario`, `Senha`, `NivelAcesso`, `CPF`, `Logradouro`,"+
              " Numero, `Bairro`, `CEP`, `Cidade`, `Estado`, `Telefone`, `Celular`, `RepeticaoSenha`, `RG`)"+
              " VALUES ('"+entidade.getNome()+"','"+entidade.getNomeUsuario()+"','"+entidade.getSenhaUsuario()+"','"+entidade.getNivelAcesso()+
              "','"+entidade.getCpf()+"','"+entidade.getLogradouro()+"',"+entidade.getNumero()+",'"+entidade.getBairro()+"','"+entidade.getCep()+
              "','"+entidade.getCidade()+"','"+entidade.getEstado()+"','"+entidade.getTelefone()+"','"+entidade.getCelular()+"','"+entidade.getRepeticaoSenha()+"','"+entidade.getRg()+"')");*/
package dao;

import entidade.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO extends DAOGenerico<Funcionario, Long>{

    @Override
    public void gravar(Funcionario entidade) throws NullPointerException {
    try{
            setSql("INSERT INTO funcionario(Nome, NomeDeUsuario, Senha, NivelAcesso, CPF, Logradouro, Numero, Bairro, CEP, Cidade, Estado, Telefone, Celular, RepeticaoSenha, RG) "+
              "VALUES ('"+entidade.getNome()+"', '"+entidade.getNomeUsuario()+"', '"+entidade.getSenhaUsuario()+"', '"+entidade.getNivelAcesso()+"', "+
              "'"+entidade.getCpf()+"','"+entidade.getLogradouro()+"',"+entidade.getNumero()+",'"+entidade.getBairro()+"','"+entidade.getCep()+"', "+
              "'"+entidade.getCidade()+"','"+entidade.getEstado()+"','"+entidade.getTelefone()+"','"+entidade.getCelular()+"','"+entidade.getRepeticaoSenha()+"','"+entidade.getRg()+"')");
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
    public void editar(Funcionario entidade) throws NullPointerException {
        try{
           setSql("UPDATE funcionario SET Nome='"+entidade.getNome()+"',NomeDeUsuario='"+entidade.getNomeUsuario()+"',Senha='"+entidade.getSenhaUsuario()+"',NivelAcesso='"+entidade.getNivelAcesso()+"',"+
                   "CPF='"+entidade.getCpf()+"',Logradouro='"+entidade.getLogradouro()+"',Numero="+entidade.getNumero()+",Bairro='"+entidade.getBairro()+"',CEP='"+entidade.getCep()+"',Cidade='"+entidade.getCidade()+"',Estado='"+entidade.getEstado()+"', Telefone='"+entidade.getTelefone()+"', "+
                   "`Celular`='"+entidade.getCelular()+"',`RepeticaoSenha`='"+entidade.getRepeticaoSenha()+"',`RG`='"+entidade.getRg()+"' WHERE IdFuncionario = "+entidade.getCodigo());
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
    public void excluir(Funcionario entidade) throws NullPointerException {
         try{
            setSql("DELETE FROM funcionario WHERE IdFuncionario = "+entidade.getCodigo()+";");
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
    public List<Funcionario> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
           List<Funcionario> listaFuncionario = new ArrayList();
        try{
            setSql("SELECT * FROM funcionario WHERE "+campo+" like '%"+palavraChave+"%' ORDER BY "+campo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaFuncionario.add(retornaResultado(result));
            }
            
            return listaFuncionario;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    
    @Override
    public Funcionario consultar(Long codigo) throws NullPointerException {
         Funcionario funcionario= new Funcionario();
        try{
            setSql("SELECT * FROM funcionario WHERE IdFuncionario = "+codigo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                funcionario = retornaResultado(result);
            }
            
            return funcionario;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public Funcionario validarUsuario(String nomeAcesso, String senha, int tipoPesquisa) throws NullPointerException {
         Funcionario funcionario= new Funcionario();
        try{
            setSql("SELECT * FROM funcionario WHERE NomeDeUsuario = '"+nomeAcesso+"' and Senha = '"+senha+"'");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                funcionario = retornaResultado(result);
            }
            
            return funcionario;
        }
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    
    private Funcionario retornaResultado(ResultSet result) throws NullPointerException
    {
        Funcionario temp = new Funcionario();
        try {
            temp.setCodigo(result.getInt("IdFuncionario"));
            temp.setNome(result.getString("Nome"));
            temp.setRg(result.getString("RG"));
            temp.setCpf(result.getString("CPF"));
            temp.setLogradouro(result.getString("Logradouro"));
            temp.setNumero(result.getInt("Numero"));
            temp.setBairro(result.getString("Bairro"));
            temp.setCidade(result.getString("Cidade"));
            temp.setEstado(result.getString("Estado"));
            temp.setTelefone(result.getString("Telefone"));
            temp.setCelular(result.getString("Celular"));
            temp.setCep(result.getString("CEP"));
            temp.setNomeUsuario(result.getString("NomeDeUsuario"));
            temp.setSenhaUsuario(result.getString("Senha"));
            temp.setRepeticaoSenha(result.getString("RepeticaoSenha"));
            temp.setNivelAcesso(result.getString("NivelAcesso"));
            
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
}
