/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Produto;
import entidade.Venda;
import entidade.Cliente;
import entidade.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mello_PC
 */
public class VendaDAO extends DAOGenerico<Venda, Long>{
    Cliente objCliente = new Cliente();
    Funcionario objFuncionario = new Funcionario();
    dao.ClienteDAO objClienteDAO = new dao.ClienteDAO();
    dao.FuncionarioDAO objFuncionarioDAO = new dao.FuncionarioDAO();

    @Override
    public void gravar(Venda entidade) throws NullPointerException {
         try{
            //Para a Compra e Venda a chave primÃ¡ria nÃ£o Ã© auto-incremento!
            int codigo = retornaCodigo();
            setSql("INSERT INTO venda (IdVenda, IdFuncionario, DataVenda , ValorVenda, IdCliente, Estorno, MotivoEstorno)"+
                    "VALUES ("+entidade.getCodigo()+", "+entidade.getFuncionario().getCodigo()+", '"+entidade.getDataVenda()+"', '"+entidade.getValorVenda()+"', '"+entidade.getCliente().getCodigo()+"', '"+entidade.getEstorno()+"','"+entidade.getMotivo()+"');");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            for (Produto p:entidade.getProdutos()){
                setSql("INSERT INTO itemvenda (IdProduto, IdVenda, Descricao, ValorCompra, ValorVenda, Quantidade, Estorno) VALUES"+ 
                        " ("+p.getCodigo()+", "+codigo+", '"+p.getDescricao()+"','"+p.getValorCompra()+"','"+p.getValorVenda()+"', "+p.getQuantidade()+", '"+entidade.getEstorno()+"');");
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
    public void editar(Venda entidade) throws NullPointerException {
       try{
           setSql("UPDATE venda set Estorno ='"+entidade.getEstorno()+"', MotivoEstorno = '"+entidade.getMotivo()+
                   "' WHERE IdVenda = "+entidade.getCodigo());
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            getCommand().execute();
            setSql("UPDATE itemvenda set Estorno ='"+entidade.getEstorno()+
                   "' WHERE IdVenda = "+entidade.getCodigo());
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
    public void excluir(Venda entidade) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException {
        List<Venda> listaVenda = new ArrayList();
        try{
            setSql("SELECT * FROM venda WHERE "+campo+" like '%"+palavraChave+"%'");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaVenda.add(retornaResultado(result));
            }
            
            return listaVenda;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public List<Venda> consultarPorDataeCliente (String dataIni, String dataFin, int codiCli) throws NullPointerException {
        List<Venda> listaVenda = new ArrayList();
        try{
            setSql("SELECT * FROM venda WHERE Estorno = 'N' and (DataVenda between  '"+dataIni+"' and '"+dataFin+"') and IdCliente = "+codiCli+" ORDER BY DataVenda ");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaVenda.add(retornaResultado(result));
            }
            
            return listaVenda;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public List<Venda> consultarPorData(String dataIni, String dataFin) throws NullPointerException {
        List<Venda> listaVenda = new ArrayList();
        try{
            setSql("SELECT * FROM venda WHERE Estorno = 'N' and (DataVenda between  '"+dataIni+"' and '"+dataFin+"') ORDER BY DataVenda ");
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                listaVenda.add(retornaResultado(result));
            }
            
            return listaVenda;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
     public List<Produto> consultarItensVenda(String campo, int codipro ) throws NullPointerException {
       List<Produto> listaprodutos = new ArrayList();
        try{
            setSql("SELECT * FROM itemvenda WHERE "+campo+" ="+codipro+" and Estorno = 'N'");
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
            setSql("SELECT * FROM itemvenda WHERE "+campo+" ="+palavraChave);
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
    public Venda consultar(int codigo) throws NullPointerException {
         Venda venda = new Venda();
        try{
            setSql("SELECT * FROM venda WHERE IdVenda ="+codigo);
            abrirConexao();
            setCommand(getConnection().prepareStatement(getSql()));
            ResultSet result = getCommand().executeQuery();
            while (result.next()) {
                venda = retornaResultado(result);
            }
            
            return venda;
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } finally{
            fecharConexao();
        }
        return null;
    }
    public List<Produto> ConsultaItensVenda (int codiProduto)
    {
         List<Produto> listaprodutos = new ArrayList();
        try{
            setSql("SELECT * FROM itemvenda WHERE IdProduto ="+codiProduto+" and Estorno = 'N'");
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
    
    public int retornaCodigo(){
        int codigo = 0;
        setSql("SELECT MAX(IdVenda) FROM venda");
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
    private Venda retornaResultado(ResultSet result) throws NullPointerException{
        Venda temp = new Venda();
        try {
            temp.setCodigo(result.getInt("IdVenda"));
            temp.setDataVenda(result.getDate("DataVenda"));
            temp.setCliente(objClienteDAO.consultar(Long.parseLong(result.getString("IdCliente"))));
            int codiFunc = result.getInt("IdFuncionario");
            temp.setFuncionario(objFuncionarioDAO.consultar(Long.parseLong(Integer.toString(codiFunc))));
            temp.setValorVenda(result.getDouble("ValorVenda"));
            temp.setProdutos(consultarItens("IdVenda",Integer.toString(result.getInt("IdVenda"))));
            temp.setMotivo(result.getString("MotivoEstorno"));
            temp.setEstorno(result.getString("Estorno"));
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
            temp.setVenda(result.getInt("IdVenda"));
            return temp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
        return null;
}

    @Override
    public Venda consultar(Long codigo) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
