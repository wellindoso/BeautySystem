/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mello_PC
 */
public class Frm_Cons_Func extends javax.swing.JFrame {

    Funcionario objFuncionario = new Funcionario();
    Funcionario objFuncionarioPrincipal = new Funcionario();
    private dao.FuncionarioDAO objFuncionarioDAO = new dao.FuncionarioDAO();
    private List<entidade.Funcionario> funcionarios = new ArrayList();
    private DefaultTableModel modelo = new DefaultTableModel();
    public Frm_Cons_Func(Funcionario Principal) {
        initComponents();
        objFuncionarioPrincipal = Principal;
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        rb_funcNome = new javax.swing.JRadioButton();
        rb_funcCodigo = new javax.swing.JRadioButton();
        rb_cpfFunc = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblresultado = new javax.swing.JTable();
        bt_alterarFunc = new javax.swing.JButton();
        bt_excluirFunc = new javax.swing.JToggleButton();
        tb_txtPesquisa = new javax.swing.JTextField();
        bt_pesqisaFunc = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BeautySystem - Consulta de Funcionários");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa por:"));

        buttonGroup1.add(rb_funcNome);
        rb_funcNome.setText("Nome ");

        buttonGroup1.add(rb_funcCodigo);
        rb_funcCodigo.setText("Código");

        buttonGroup1.add(rb_cpfFunc);
        rb_cpfFunc.setText("CPF");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rb_funcNome)
                .addGap(90, 90, 90)
                .addComponent(rb_cpfFunc)
                .addGap(105, 105, 105)
                .addComponent(rb_funcCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_funcNome)
                    .addComponent(rb_funcCodigo)
                    .addComponent(rb_cpfFunc)))
        );

        tblresultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Celular", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblresultado);

        bt_alterarFunc.setText("Alterar");
        bt_alterarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarFuncActionPerformed(evt);
            }
        });

        bt_excluirFunc.setText("Excluir");
        bt_excluirFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirFuncActionPerformed(evt);
            }
        });

        bt_pesqisaFunc.setText("Pesquisa");
        bt_pesqisaFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesqisaFuncActionPerformed(evt);
            }
        });

        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tb_txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_pesqisaFunc))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_alterarFunc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_excluirFunc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_sair)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tb_txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesqisaFunc))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_alterarFunc)
                    .addComponent(bt_excluirFunc)
                    .addComponent(bt_sair))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cancelar() {
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Cancelar a Operacao?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){  
            this.dispose();
        }
    }
    private void bt_alterarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarFuncActionPerformed
     try
     {
          int index = tblresultado.getSelectedRow();
     objFuncionario.setCodigo(funcionarios.get(index).getCodigo());
     objFuncionario.setNome(funcionarios.get(index).getNome());
     objFuncionario.setBairro(funcionarios.get(index).getBairro());
     objFuncionario.setCelular(funcionarios.get(index).getCelular());;
     objFuncionario.setCep(funcionarios.get(index).getCep());
     objFuncionario.setCidade(funcionarios.get(index).getCidade());
     objFuncionario.setCpf(funcionarios.get(index).getCpf());
     objFuncionario.setEstado(funcionarios.get(index).getEstado());
     objFuncionario.setLogradouro(funcionarios.get(index).getLogradouro());
     objFuncionario.setNivelAcesso(funcionarios.get(index).getNivelAcesso());
     objFuncionario.setNomeUsuario(funcionarios.get(index).getNomeUsuario());
     objFuncionario.setNumero(funcionarios.get(index).getNumero());
     objFuncionario.setRepeticaoSenha(funcionarios.get(index).getRepeticaoSenha());
     objFuncionario.setRg(funcionarios.get(index).getRg());
     objFuncionario.setSenhaUsuario(funcionarios.get(index).getSenhaUsuario());
     objFuncionario.setTelefone(funcionarios.get(index).getTelefone());
     
     Frm_Alt_Func f1 = new Frm_Alt_Func(objFuncionario,objFuncionarioPrincipal);
     f1.setVisible(true);
     dispose();
     }
    catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "Registro não selecionado!", "Erro:", JOptionPane.INFORMATION_MESSAGE);
            }
    }//GEN-LAST:event_bt_alterarFuncActionPerformed

    private void bt_pesqisaFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesqisaFuncActionPerformed
        if (!tb_txtPesquisa.getText().equals(""))
        {
             if(rb_funcCodigo.isSelected())
            {
                funcionarios = objFuncionarioDAO.consultar("IdFuncionario", tb_txtPesquisa.getText(), 1);
                if (funcionarios.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    funcionarios.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getNome(), p.getCpf(), p.getCidade(), p.getTelefone(), p.getCelular()});
                    });
                }
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        
         
        else if (!tb_txtPesquisa.getText().equals(""))
        {
             if(rb_funcCodigo.isSelected())
            {
                funcionarios = objFuncionarioDAO.consultar("IdFuncionario", tb_txtPesquisa.getText(), 1);
                if (funcionarios.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    funcionarios.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getNome(), p.getCpf(), p.getCidade(), p.getTelefone(), p.getCelular()});
                    });
                }
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if(rb_cpfFunc.isSelected())
            {
                funcionarios = objFuncionarioDAO.consultar("CPF", tb_txtPesquisa.getText(), 1);
                if (funcionarios.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    funcionarios.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getNome(), p.getCpf(), p.getCidade(), p.getTelefone(), p.getCelular()});
                    });
                }
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
            }
             
             else if(rb_funcNome.isSelected())
            {
                funcionarios = objFuncionarioDAO.consultar("Nome", tb_txtPesquisa.getText(), 1);
                if (funcionarios.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    funcionarios.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getNome(), p.getCpf(), p.getCidade(), p.getTelefone(), p.getCelular()});
                    });
                }
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
        else {
            JOptionPane.showMessageDialog(this, "Informe o valor da pesquisa!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
         
        
    }//GEN-LAST:event_bt_pesqisaFuncActionPerformed

    private void bt_excluirFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirFuncActionPerformed
       if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Excluir o funcionário selecionado?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0)
        {
        try{
        int index = tblresultado.getSelectedRow();
        objFuncionario.setCodigo(funcionarios.get(index).getCodigo());
        objFuncionarioDAO.excluir(objFuncionario);
        JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        funcionarios.remove(index);
        modelo.removeRow(index);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Registro não selecionado!", "Erro:", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }//GEN-LAST:event_bt_excluirFuncActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_Func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cons_Func(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterarFunc;
    private javax.swing.JToggleButton bt_excluirFunc;
    private javax.swing.JButton bt_pesqisaFunc;
    private javax.swing.JButton bt_sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_cpfFunc;
    private javax.swing.JRadioButton rb_funcCodigo;
    private javax.swing.JRadioButton rb_funcNome;
    private javax.swing.JTextField tb_txtPesquisa;
    private javax.swing.JTable tblresultado;
    // End of variables declaration//GEN-END:variables

}
