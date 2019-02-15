/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;
import entidade.Fornecedor;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
/**
 *
 * @author Mello_PC
 */
public class Frm_Alt_For extends javax.swing.JFrame {

    Fornecedor objFornecedor = new Fornecedor();
    private dao.FornecedorDAO objClienteDAO = new dao.FornecedorDAO();
    
    public Frm_Alt_For(Fornecedor fornecedor) {
        initComponents();
        setLocationRelativeTo(null);
        tb_codigoFor.setText(Integer.toString(fornecedor.getCodigo()));
        tb_razaoFor.setText(fornecedor.getRazaoSocial());
        tb_fantasiaFor.setText(fornecedor.getNomeFantasia());
        tb_cnpjFor.setText(fornecedor.getCNPJ());
        tb_ieFor.setText(fornecedor.getIe());
        tb_logradouroFor.setText(fornecedor.getLogradouro());
        tb_numeroFor.setText(Integer.toString(fornecedor.getNumero()));
        tb_bairroFor.setText(fornecedor.getBairro());
        tb_cepFor.setText(fornecedor.getCEP());
        tb_cidadeFor.setText(fornecedor.getCidade());
        cb_estadoFor.setSelectedItem(fornecedor.getEstado());
        tb_paisFor.setText(fornecedor.getPais());
        cb_situacaoFor.setSelectedItem(fornecedor.getSituacao());
        tb_descricaoFor.setText(fornecedor.getDescricao());
    }
     private boolean validarCampos(){
        return (!tb_bairroFor.getText().equals("")) &&
                (!tb_cepFor.getText().equals("")) &&
                (!tb_cidadeFor.getText().equals("")) &&
                (!tb_cnpjFor.getText().equals("")) &&
                (!tb_descricaoFor.getText().equals("")) &&
                (!tb_fantasiaFor.getText().equals("")) &&
                (!tb_logradouroFor.getText().equals("")) &&
                (!tb_numeroFor.getText().equals("")) &&
                (!tb_ieFor.getText().equals("")) &&
                (!tb_razaoFor.getText().equals(""));
                         
    }
    private void cancelar(){  
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Cancelar a Operacao?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){  
            this.dispose();  
        }
    }  
     private void popularAtributos(){
        objFornecedor.setRazaoSocial(tb_razaoFor.getText());
        objFornecedor.setIe(tb_ieFor.getText());
        objFornecedor.setNomeFantasia(tb_fantasiaFor.getText());
        objFornecedor.setCNPJ(tb_cnpjFor.getText());
        objFornecedor.setLogradouro(tb_logradouroFor.getText());
        objFornecedor.setNumero(Integer.parseInt(tb_numeroFor.getText()));
        objFornecedor.setBairro(tb_bairroFor.getText());
        objFornecedor.setCidade(tb_cidadeFor.getText());
        objFornecedor.setEstado(String.valueOf(cb_estadoFor.getSelectedItem()));
        objFornecedor.setPais(tb_paisFor.getText());
        objFornecedor.setCEP(tb_cepFor.getText());
        objFornecedor.setDescricao(tb_descricaoFor.getText());
        objFornecedor.setSituacao(String.valueOf(cb_situacaoFor.getSelectedItem()));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tb_descricaoFor = new javax.swing.JTextField();
        cb_situacaoFor = new javax.swing.JComboBox();
        bt_inserir = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        tb_razaoFor = new javax.swing.JTextField();
        tb_fantasiaFor = new javax.swing.JTextField();
        tb_logradouroFor = new javax.swing.JTextField();
        tb_numeroFor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tb_bairroFor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tb_cidadeFor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_estadoFor = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tb_ieFor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tb_paisFor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tb_codigoFor = new javax.swing.JTextField();
        tb_cnpjFor = new javax.swing.JFormattedTextField();
        tb_cepFor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BeautySystem - Alteração de Fornecedores");

        jLabel6.setText("Bairro:");

        jLabel7.setText("CEP:");

        cb_situacaoFor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bloqueado", "Desbloqueado" }));

        bt_inserir.setText("Inserir");
        bt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inserirActionPerformed(evt);
            }
        });

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Razão Social:");

        jLabel2.setText("Nome Fantasia:");

        jLabel3.setText("CNPJ:");

        jLabel4.setText("Logradouro:");

        jLabel5.setText("Número:");

        jLabel8.setText("Cidade:");

        cb_estadoFor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AM", "AP", "RR", "RO", "TO", "PA", "MA", "CE", "PI", "RN", "PB", "PE", "AL", "SE", "BA", "MT", "MS", "GO", "DF", "ES", "MG", "RJ", "SP", "PR", "SC", "RS" }));

        jLabel11.setText("Descrição:");

        jLabel9.setText("Estado:");

        jLabel10.setText("Situação:");

        jLabel12.setText("Inscr. Estadual:");

        jLabel13.setText("País:");

        jLabel14.setText("Código:");

        tb_codigoFor.setEditable(false);

        try {
            tb_cnpjFor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tb_cepFor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_codigoFor))
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_fantasiaFor, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_razaoFor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_cnpjFor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_ieFor))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_cidadeFor))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_bairroFor, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_estadoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_cepFor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_situacaoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_logradouroFor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 40, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_numeroFor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tb_descricaoFor))
                                .addGap(15, 15, 15)))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_inserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_cancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_paisFor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tb_razaoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tb_codigoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tb_fantasiaFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addComponent(tb_ieFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tb_cnpjFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tb_logradouroFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tb_numeroFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(tb_bairroFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tb_cepFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_estadoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tb_cidadeFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tb_paisFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cb_situacaoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tb_descricaoFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserir)
                    .addComponent(bt_cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inserirActionPerformed
     if(validarCampos()){
            try{
                popularAtributos();
                objFornecedor.setCodigo(Integer.parseInt(tb_codigoFor.getText()));
                objClienteDAO.editar( objFornecedor);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException | HeadlessException e){
                JOptionPane.showMessageDialog(this, "Erro"+e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Informe todos os campos corretamente!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bt_inserirActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
    cancelar();
    }//GEN-LAST:event_bt_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Alt_For.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Alt_For.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Alt_For.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Alt_For.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_inserir;
    private javax.swing.JComboBox cb_estadoFor;
    private javax.swing.JComboBox cb_situacaoFor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tb_bairroFor;
    private javax.swing.JFormattedTextField tb_cepFor;
    private javax.swing.JTextField tb_cidadeFor;
    private javax.swing.JFormattedTextField tb_cnpjFor;
    private javax.swing.JTextField tb_codigoFor;
    private javax.swing.JTextField tb_descricaoFor;
    private javax.swing.JTextField tb_fantasiaFor;
    private javax.swing.JTextField tb_ieFor;
    private javax.swing.JTextField tb_logradouroFor;
    private javax.swing.JTextField tb_numeroFor;
    private javax.swing.JTextField tb_paisFor;
    private javax.swing.JTextField tb_razaoFor;
    // End of variables declaration//GEN-END:variables
}
