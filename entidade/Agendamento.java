/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mello_PC
 */
public class Agendamento {
    private int codigo;
    private Date data;
    private Funcionario funcionario;
    private Cliente cliente;
    private String horaInicial;
    private String horaFinal;
    private List<entidade.Servico> servicos = new ArrayList();
    private Double valorAgendamento;
    private String Status;
    private String observacao;
    private String envioSMS;
    
    
    

    public String getEnvioSMS() {
        return envioSMS;
    }

    public void setEnvioSMS(String envioSMS) {
        this.envioSMS = envioSMS;
    }
    
    

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public List<entidade.Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<entidade.Servico> servicos) {
        this.servicos = servicos;
    }

    public Double getValorAgendamento() {
        return valorAgendamento;
    }

    public void setValorAgendamento(Double valorAgendamento) {
        this.valorAgendamento = valorAgendamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
