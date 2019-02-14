/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Agendamento;
import entidade.Servico;
import entidade.Cliente;
import entidade.Funcionario;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mello_PC
 */
public class AgendamentoDAO extends DAOGenerico <Agendamento, Long>{
     dao.ClienteDAO objClienteDAO = new dao.ClienteDAO();
    Cliente objCliente = new Cliente();
    Funcionario objFuncionario = new Funcionario();
    dao.FuncionarioDAO objFuncionarioDAO = new dao.FuncionarioDAO();
    @Override
    public void gravar(Agendamento entidade)  {
        try
        {
            setSql("INSERT INTO agendamento(IdAgendamento, IdCliente, IdFuncionario, DataAgendamento, HoraInicial, HoraFinal, ValorAgendamento, Status)"+
                    " VALUES ("+entidade.getCodigo()+","+entidade.getCliente().getCodigo()+","+entidade.getFuncionario().getCodigo()+",'"+entidade.getData()+"','"+entidade.getHoraInicial()+"','"+entidade.getHoraFinal()+"',"+entidade.getValorAgendamento()+",'"+entidade.getStatus()+"')");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            for(Servico s: entidade.getServicos())
            {
                setSql("INSERT INTO itemagendamento(IdAgendamento, IdServico, Descricao, Quantidade, ValorMaoDeObra)"+
                        " VALUES ("+entidade.getCodigo()+","+s.getCodigo()+",'"+s.getDescricao()+"',"+s.getQuantidade()+","+s.getValorMaoDeObra()+")");
                setCommand(getConnection().prepareStatement(getSql()));
                getCommand().execute();
            }
            getConnection().commit();
        }
        catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
    }

    @Override
    public void editar(Agendamento entidade) throws NullPointerException {
        try{
            
            setSql("UPDATE agendamento SET IdCliente="+entidade.getCliente().getCodigo()+", IdFuncionario = "+entidade.getFuncionario().getCodigo()+"," +
                     "HoraInicial= '"+entidade.getHoraInicial()+"',HoraFinal= '"+entidade.getHoraFinal()+"', DataAgendamento = '"+entidade.getData()+"',"+ 
                    "ValorAgendamento = "+entidade.getValorAgendamento()+", Status = '"+entidade.getStatus()+"', Observacao = '"+entidade.getObservacao()+"' WHERE IdAgendamento = "+entidade.getCodigo()+";");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            setSql("DELETE FROM itemagendamento WHERE IdAgendamento = "+entidade.getCodigo()+";");
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            for (Servico s:entidade.getServicos()){
                setSql("INSERT INTO itemagendamento(IdAgendamento, IdServico, Descricao, Quantidade, ValorMaoDeObra)"+
                        " VALUES ("+entidade.getCodigo()+","+s.getCodigo()+",'"+s.getDescricao()+"',"+s.getQuantidade()+","+s.getValorMaoDeObra()+")");
                setCommand(getConnection().prepareStatement(getSql()));
                getCommand().execute();
            }
            getConnection().commit();
        }
         catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } 
        finally
        {
            fecharConexao();
        }
    }

    
    public void excluirTemp(Agendamento entidade) throws NullPointerException {
        try{
            
            setSql("UPDATE agendamento SET HoraInicial= null,HoraFinal= null WHERE IdAgendamento = "+entidade.getCodigo()+";");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            getConnection().commit();
        }
         catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } 
        finally
        {
            fecharConexao();
        }
    }
    public List<Agendamento> consultarAgendamentoEnvioSMS(String dataAtual, String horaAtual)
    {
         List<Agendamento> listaAgendamento = new ArrayList();
        try{
            setSql("SELECT * FROM agendamento WHERE DataAgendamento = '"+dataAtual+"' and TIMEDIFF(`HoraInicial`,'"+horaAtual+"')<='00:30'");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaAgendamento.add(retornaResultado(result));
            }
            
            return listaAgendamento;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    
    public void retornaHorarioAgendamento(String horaInicial, String horaFinal, Agendamento entidade)
   {
        try{
            
            setSql("UPDATE agendamento SET HoraInicial= '"+horaInicial+"',HoraFinal= '"+horaFinal+"' WHERE IdAgendamento = "+entidade.getCodigo()+";");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            getConnection().commit();
        }
         catch (SQLException e){
            cancelarTransação();
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } 
        finally
        {
            fecharConexao();
        }
    }
    public List<Agendamento> verificarAgenda(String campo, String palavraChave, int codiFunc, int tipoPesquisa) throws NullPointerException {
        List<Agendamento> listaAgendamento = new ArrayList();
        try{
            setSql("SELECT * FROM agendamento WHERE "+campo+" like '%"+palavraChave+"%' and IdFuncionario = "+codiFunc+" and Status like '%Agendado%' ORDER BY DataAgendamento, HoraInicial");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaAgendamento.add(retornaResultado(result));
            }
            
            return listaAgendamento;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    
    public List<Agendamento> consultarDisponibiblidade (String HoraInicial, String HoraFinal, int codiFunc, Agendamento entidade)
    {
        List<Agendamento> listaAgendamento = new ArrayList();
        try{
            setSql("SELECT * FROM agendamento WHERE (((HoraInicial > '"+HoraInicial+"' and HoraInicial < '"+HoraFinal+"') or"+
                    "(HoraFinal > '"+HoraInicial+"' and HoraFinal < '"+HoraFinal+"') or (HoraInicial < '"+HoraInicial+"' and HoraFinal > '"+HoraFinal+"') or (HoraInicial like '%"+HoraInicial+"%' and HoraFinal like '%"+HoraFinal+"%'))and DataAgendamento = '"+entidade.getData()+"') and "+
                    "IdFuncionario = "+codiFunc+" and Status like '%Agendado%' and IdAgendamento != "+entidade.getCodigo()+" ORDER BY DataAgendamento, HoraInicial");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaAgendamento.add(retornaResultado(result));
            }
           return listaAgendamento;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }

    @Override
    public Agendamento consultar(Long codigo) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Agendamento retornaResultado(ResultSet result) throws NullPointerException{
        Agendamento temp = new Agendamento();
        try {
            temp.setCodigo(result.getInt("IdAgendamento"));
            temp.setData(result.getDate("DataAgendamento"));
            temp.setCliente(objClienteDAO.consultar(Long.parseLong(Integer.toString(result.getInt("IdCliente")))));
            int codiFunc = result.getInt("IdFuncionario");
            temp.setFuncionario(objFuncionarioDAO.consultar(Long.parseLong(Integer.toString(codiFunc))));
            temp.setValorAgendamento(result.getDouble("ValorAgendamento"));
            temp.setHoraInicial(result.getString("HoraInicial"));
            temp.setHoraFinal(result.getString("HoraFinal"));
            temp.setStatus(result.getString("Status"));
            temp.setEnvioSMS(result.getString("StatusSMS"));
            temp.setServicos(consultarItens("IdAgendamento",Integer.toString(result.getInt("IdAgendamento"))));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
    public List<Servico> consultarItens(String campo, String palavraChave) throws NullPointerException {
        List<Servico> listaItem = new ArrayList();
        try{
            setSql("SELECT * FROM itemagendamento WHERE "+campo+" = "+palavraChave);
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
    
    private Servico retornaResultadoItem(ResultSet result) throws NullPointerException{
        Servico temp = new Servico();
        try {
            temp.setCodigo(result.getInt("IdServico"));
            temp.setDescricao(result.getString("Descricao"));
            temp.setQuantidade(result.getInt("Quantidade"));
            temp.setValorMaoDeObra(result.getDouble("ValorMaoDeObra"));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
    }
    
    public int retornaCodigo(){
        int codigo = 0;
        setSql("SELECT MAX(IdAgendamento) FROM Agendamento");
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
    public List<Agendamento> consultarPorData(String campo, String palavraChave, String dataIni, String dataFin) throws NullPointerException {
    List<Agendamento> listaAgendamento = new ArrayList();
        
             try{
            setSql("SELECT * FROM agendamento WHERE "+campo+" = "+palavraChave+" and (DataAgendamento between '"+dataIni+"' and '"+dataFin+"') and Status like '%Realizado%' ORDER BY DataAgendamento, HoraInicial");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaAgendamento.add(retornaResultado(result));
            }
            
            return listaAgendamento;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }    
         return null;
   }
    
    public List<Agendamento> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
         List<Agendamento> listaAgendamento = new ArrayList();
        
        try{
            setSql("SELECT * FROM agendamento WHERE "+campo+" = "+palavraChave+" and Status like '%Agendado%' ORDER BY DataAgendamento, HoraInicial");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaAgendamento.add(retornaResultado(result));
            }
            
            return listaAgendamento;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        
        return null;
    }
     public List<Agendamento> consultarDataRetro(String data) throws NullPointerException {
         List<Agendamento> listaAgendamento = new ArrayList();
        
        try{
            setSql("SELECT * FROM `agendamento` WHERE `DataAgendamento` <  '"+data+"' and Status = 'Agendado' ORDER BY DataAgendamento");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaAgendamento.add(retornaResultado(result));
            }
            
            return listaAgendamento;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        
        return null;
    }
    public List<Agendamento> consultarPorDataeCliente(String dataIni, String dataFin, int codiCli) throws NullPointerException {
         List<Agendamento> listaAgendamento = new ArrayList();
        
        try{
            setSql("SELECT * FROM agendamento WHERE IdCliente = "+codiCli+" and (DataAgendamento between '"+dataIni+"' and '"+dataFin+"') ORDER BY DataAgendamento");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaAgendamento.add(retornaResultado(result));
            }
            
            return listaAgendamento;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        
        return null;
    }

    @Override
    public void excluir(Agendamento entidade) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
