/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mello_PC
 */
public class Frm_Cad_GrupoPro extends javax.swing.JFrame {

   private entidade.GrupoProdutos objGrupoProdutos;
   private dao.GrupoProdutosDAO objGrupoProdutosDAO = new dao.GrupoProdutosDAO();
    public Frm_Cad_GrupoPro() {
        initComponents();
        setLocationRelativeTo(null);
        this.objGrupoProdutos = new entidade.GrupoProdutos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tb_ncmGP = new javax.swing.JTextField();
        tb_descGP = new javax.swing.JTextField();
        bt_inserir = new javax.swing.JButton();
        bt_limpar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BeautySystem - Cadastro de Grupo de Prodtos");

        jLabel1.setText("Descrição:");

        jLabel2.setText("N.C.M:");

        bt_inserir.setText("Inserir");
        bt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inserirActionPerformed(evt);
            }
        });

        bt_limpar.setText("Limpar");
        bt_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparActionPerformed(evt);
            }
        });

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bt_limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_inserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tb_descGP))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tb_ncmGP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tb_descGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tb_ncmGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserir)
                    .addComponent(bt_limpar)
                    .addComponent(bt_cancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean validarCampos(){
        return (!tb_descGP.getText().equals("")) &&
                (!tb_ncmGP.getText().equals(""));
        }
    
    private void popularAtributos()
    {
        objGrupoProdutos.setDescricao(tb_descGP.getText());
        objGrupoProdutos.setNcm(tb_ncmGP.getText());
    }
    private void bt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inserirActionPerformed
     if(validarCampos()){
            try{
                popularAtributos();
                objGrupoProdutosDAO.gravar(objGrupoProdutos);
                JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (NumberFormatException | HeadlessException e){
                JOptionPane.showMessageDialog(this, "Erro"+e);
            }        // TODO add your handling code here:
        }
    }//GEN-LAST:event_bt_inserirActionPerformed
    private void cancelar(){  
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Cancelar a Operacao?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){  
            this.dispose();  
        }
    }
    private void limparCampos()
    {
        tb_descGP.setText("");
        tb_ncmGP.setText("");
    }
    private void bt_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparActionPerformed
    limparCampos();
    }//GEN-LAST:event_bt_limparActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Cad_GrupoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cad_GrupoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cad_GrupoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cad_GrupoPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cad_GrupoPro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_inserir;
    private javax.swing.JButton bt_limpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tb_descGP;
    private javax.swing.JTextField tb_ncmGP;
    // End of variables declaration//GEN-END:variables
}
