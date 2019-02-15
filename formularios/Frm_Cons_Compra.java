/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import entidade.Compra;
import entidade.Fornecedor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_Cons_Compra extends javax.swing.JFrame {

    Compra objCompra = new Compra();
    Fornecedor objFornecedor = new Fornecedor();
    dao.CompraDAO objCompraDAO = new dao.CompraDAO();
    private List <entidade.Compra> compras = new ArrayList();
    private DefaultTableModel modelo = new DefaultTableModel();
    Date date = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    public Frm_Cons_Compra() {
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        tb_txtpesquisa = new javax.swing.JTextField();
        bt_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblresultado = new javax.swing.JTable();
        bt_alterar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Beautysystem - Consulta/Alteração de Compras");

        jLabel1.setText("Código do Fornecedor:");

        bt_pesquisar.setText("Pesquisar...");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
            }
        });

        tblresultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data da Compra", "Fornecedor", "Codigo da Compra", "Valor de Compra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblresultado);

        bt_alterar.setText("Alterar");
        bt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarActionPerformed(evt);
            }
        });

        bt_excluir.setText("Excluir");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tb_txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(bt_pesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tb_txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_alterar)
                    .addComponent(bt_excluir)
                    .addComponent(bt_cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
     if(!tb_txtpesquisa.getText().equals("")){
         compras = objCompraDAO.consultar("IdFornecedor", tb_txtpesquisa.getText());
         if(compras.size()>0)
         {
             modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
         }
                    compras.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {formatador.format(p.getDataCompra()),p.getFornecedor().getDescricao(), p.getCodigo(),p.getValorCompra()});
                    });
    }//GEN-LAST:event_bt_pesquisarActionPerformed
 else
         {
             JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
         }
     }
     else
     {
         JOptionPane.showMessageDialog(this, "Preencha o Campo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
     }
    }
    private void bt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarActionPerformed
       int index = tblresultado.getSelectedRow();
       objCompra.setCodigo(compras.get(index).getCodigo());
       objCompra.setDataCompra(compras.get(index).getDataCompra());
       objCompra.setFornecedor(compras.get(index).getFornecedor());
       objCompra.setFuncionario(compras.get(index).getFuncionario());
       objCompra.setValorCompra(compras.get(index).getValorCompra());
       objCompra.setProdutos(compras.get(index).getProdutos());
       Frm_Realizar_Compra f1 = new Frm_Realizar_Compra(objCompra, 1);
       f1.setVisible(true);
       dispose();
    }//GEN-LAST:event_bt_alterarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
      dispose();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Excluir a compra selecionada?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0)
        {
            try{
                int index = tblresultado.getSelectedRow();
                objCompra.setCodigo(compras.get(index).getCodigo());
                objCompraDAO.excluir(objCompra);
                
        }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "Registro não selecionado!", "Erro:", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_excluirActionPerformed
        
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
            java.util.logging.Logger.getLogger(Frm_Cons_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cons_Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_pesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tb_txtpesquisa;
    private javax.swing.JTable tblresultado;
    // End of variables declaration//GEN-END:variables
}
