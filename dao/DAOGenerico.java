/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import configuracao.Conexao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Mello_PC
 * @param <E>
 * @param <ID>

 */
public abstract class DAOGenerico <E, ID extends Serializable> {

    private Connection connection;  
    private PreparedStatement command;   
    private String sql;
    
    public abstract void gravar(E entidade) throws NullPointerException;
    
    public abstract void editar(E entidade) throws NullPointerException;
    
    public abstract void excluir(E entidade) throws NullPointerException;
    
    public abstract List<E> consultar(String campo, String palavraChave, int tipoPesquisa) throws NullPointerException;
    
    public abstract E consultar(Long codigo) throws NullPointerException;
    
    public void abrirConexao() throws NullPointerException{
        connection = Conexao.Conexao();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
    }
    
    public void fecharConexao() throws NullPointerException{
        try {  
            command.close();  
            connection.close();  
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        } 
    }
    
    public void cancelarTransação() throws NullPointerException{
        try {
            connection.rollback();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro!: "+e);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public PreparedStatement getCommand() {
        return command;
    }

    public void setCommand(PreparedStatement command) {
        this.command = command;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    
}
