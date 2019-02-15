/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import entidade.Cliente;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mello_PC
 */
public class Frm_Alt_Clientes extends javax.swing.JFrame {

    /**
     * Creates new form frm_Alt_Clientes
     * @param cliente
     */
    Cliente objCliente = new Cliente();
    private dao.ClienteDAO objClienteDAO = new dao.ClienteDAO();
    Date date = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    
    public Frm_Alt_Clientes(Cliente cliente) throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
       formatador.setLenient(false);
       tb_codigoCli.setText(Integer.toString(cliente.getCodigo()));
       tb_nomeCli.setText(cliente.getNome());
       date = cliente.getDataNascCli();
       tb_dataNascCli.setText(formatador.format(date));
       tb_rgCli.setText(cliente.getRg());
       tb_cpfCli.setText(cliente.getCpf());
       tb_bairroCli.setText(cliente.getBairro());
       tb_logradouroCli.setText(cliente.getLogradouro());
       tb_numeroCli.setText(Integer.toString(cliente.getNumero()));
       tb_cidadeCli.setText(cliente.getCidade());
       cb_estadoCli.setSelectedItem(cliente.getEstado());
       tb_cepCli.setText(cliente.getCep());
       tb_telefoneCli.setText(cliente.getTelefone());
       tb_celularCli.setText(cliente.getCelular());
       cb_situacaoCli.setSelectedItem(cliente.getSituacao());
       at_observacaoCli.setText(cliente.getObservacaoCli());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        tb_cidadeCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cb_estadoCli = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb_situacaoCli = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        at_observacaoCli = new javax.swing.JTextArea();
        tb_nomeCli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bt_inserirCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bt_cancelarCliente = new javax.swing.JButton();
        tb_numeroCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tb_logradouroCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tb_bairroCli = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tb_cepCli = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tb_dataNascCli = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        tb_codigoCli = new javax.swing.JTextField();
        tb_cpfCli = new javax.swing.JFormattedTextField();
        tb_telefoneCli = new javax.swing.JFormattedTextField();
        tb_celularCli = new javax.swing.JFormattedTextField();
        tb_rgCli = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BeautySystem - Alteração de Clientes");

        jLabel7.setText("Cidade:");

        jLabel8.setText("Estado:");

        cb_estadoCli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AM", "AP", "RR", "RO", "TO", "PA", "MA", "CE", "PI", "RN", "PB", "PE", "AL", "SE", "BA", "MT", "MS", "GO", "DF", "ES", "MG", "RJ", "SP", "PR", "SC", "RS" }));

        jLabel9.setText("Telefone:");

        jLabel10.setText("Celular:");

        jLabel11.setText("Situação:");

        cb_situacaoCli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bloqueado", "Desbloqueado" }));

        jLabel1.setText("Nome:");

        jLabel12.setText("Observação:");

        at_observacaoCli.setColumns(20);
        at_observacaoCli.setRows(5);
        jScrollPane1.setViewportView(at_observacaoCli);

        jLabel2.setText("RG:");

        bt_inserirCliente.setText("Inserir");
        bt_inserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inserirClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF:");

        bt_cancelarCliente.setText("Cancelar");
        bt_cancelarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Logradouro:");

        jLabel5.setText("Número:");

        jLabel6.setText("Bairro:");

        tb_bairroCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_bairroCliActionPerformed(evt);
            }
        });

        jLabel13.setText("CEP:");

        jLabel14.setText("Data de Nascimento:");

        try {
            tb_dataNascCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tb_dataNascCli.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tb_dataNascCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_dataNascCliFocusLost(evt);
            }
        });

        jLabel15.setText("Código:");

        tb_codigoCli.setEditable(false);
        tb_codigoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_codigoCliActionPerformed(evt);
            }
        });

        try {
            tb_cpfCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tb_telefoneCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tb_celularCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_inserirCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_cancelarCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_situacaoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_telefoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(108, 108, 108)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_celularCli)))
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tb_codigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tb_nomeCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tb_dataNascCli, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_cidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_logradouroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_rgCli, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_numeroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tb_bairroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_estadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_cepCli, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tb_nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tb_dataNascCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(tb_codigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(tb_cpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tb_rgCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tb_logradouroCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(tb_bairroCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tb_numeroCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tb_cidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cb_estadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tb_cepCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(tb_telefoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tb_celularCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_situacaoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserirCliente)
                    .addComponent(bt_cancelarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean validarCampos(){
        return (!tb_bairroCli.getText().equals("")) &&
                (!tb_celularCli.getText().equals("")) &&
                (!tb_cidadeCli.getText().equals("")) &&
                (!tb_cpfCli.getText().equals("")) &&
                (!tb_logradouroCli.getText().equals("")) &&
                (!tb_nomeCli.getText().equals("")) &&
                (!tb_numeroCli.getText().equals("")) &&
                (!tb_dataNascCli.getText().equals("")) &&
                (!tb_rgCli.getText().equals("")) &&
                (!tb_telefoneCli.getText().equals(""));
                         
    }
    private void popularAtributos() throws ParseException{
        objCliente.setBairro(tb_bairroCli.getText());
        objCliente.setCelular(tb_celularCli.getText());
        objCliente.setCidade(tb_cidadeCli.getText());
        objCliente.setLogradouro(tb_logradouroCli.getText());
        objCliente.setEstado(String.valueOf(cb_estadoCli.getSelectedItem()));
        objCliente.setNome(tb_nomeCli.getText());
        objCliente.setNumero(Integer.parseInt(tb_numeroCli.getText()));
        objCliente.setTelefone(tb_telefoneCli.getText());
        objCliente.setRg(tb_rgCli.getText());
        objCliente.setCpf(tb_cpfCli.getText());
        objCliente.setCep(tb_cepCli.getText());
        objCliente.setSituacao(String.valueOf(cb_situacaoCli.getSelectedItem()));
        java.sql.Date date1 = new java.sql.Date(formatador.parse(tb_dataNascCli.getText()).getTime());
        //date = sdf.parse(tb_dataNascCli.getText());
        objCliente.setDataNascCli(date1);
        objCliente.setObservacaoCli(String.valueOf(at_observacaoCli.getText()));
    }
    private void tb_bairroCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_bairroCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_bairroCliActionPerformed
    private void cancelar(){  
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Cancelar a Operacao?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){  
            this.dispose();  
        }
    }
    private void bt_inserirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inserirClienteActionPerformed
    if(validarCampos()){
            try{
                popularAtributos();
                objCliente.setCodigo(Integer.parseInt(tb_codigoCli.getText()));
                objClienteDAO.editar(objCliente);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException | HeadlessException e){
                JOptionPane.showMessageDialog(this, "Erro"+e);
            } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data Invalida", "Informação", JOptionPane.INFORMATION_MESSAGE);
        tb_dataNascCli.setText("");
        tb_dataNascCli.requestFocus();
        }
        } else {
            JOptionPane.showMessageDialog(this, "Informe todos os campos corretamente!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bt_inserirClienteActionPerformed

    private void tb_codigoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_codigoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_codigoCliActionPerformed

    private void bt_cancelarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarClienteActionPerformed
    cancelar();        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarClienteActionPerformed

    private void tb_dataNascCliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_dataNascCliFocusLost
    try
    {
        date = formatador.parse(tb_dataNascCli.getText());
    }
    catch(ParseException e)
    {
        JOptionPane.showMessageDialog(this, "Data Invalida", "Informação", JOptionPane.INFORMATION_MESSAGE);
        tb_dataNascCli.setText("");
        tb_dataNascCli.requestFocus();
    }
    }//GEN-LAST:event_tb_dataNascCliFocusLost

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
            java.util.logging.Logger.getLogger(Frm_Alt_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Alt_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Alt_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Alt_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea at_observacaoCli;
    private javax.swing.JButton bt_cancelarCliente;
    private javax.swing.JButton bt_inserirCliente;
    private javax.swing.JComboBox cb_estadoCli;
    private javax.swing.JComboBox cb_situacaoCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tb_bairroCli;
    private javax.swing.JFormattedTextField tb_celularCli;
    private javax.swing.JTextField tb_cepCli;
    private javax.swing.JTextField tb_cidadeCli;
    private javax.swing.JTextField tb_codigoCli;
    private javax.swing.JFormattedTextField tb_cpfCli;
    private javax.swing.JFormattedTextField tb_dataNascCli;
    private javax.swing.JTextField tb_logradouroCli;
    private javax.swing.JTextField tb_nomeCli;
    private javax.swing.JTextField tb_numeroCli;
    private javax.swing.JTextField tb_rgCli;
    private javax.swing.JFormattedTextField tb_telefoneCli;
    // End of variables declaration//GEN-END:variables
}
