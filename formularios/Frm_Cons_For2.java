/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import entidade.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Mello_PC
 */
public class Frm_Cons_For2 extends javax.swing.JFrame {

    private JFrame parent;
    Fornecedor objFornecedor = new Fornecedor();
    private dao.FornecedorDAO objFornecedorDAO = new dao.FornecedorDAO();
    private DefaultTableModel modelo = new DefaultTableModel();
    private List<entidade.Fornecedor> fornecedores = new ArrayList();
    public Frm_Cons_For2(JFrame fCompra) {
        initComponents();
        setLocationRelativeTo(null);
        this.parent = fCompra;
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
        bt_sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblresultado = new javax.swing.JTable();
        bt_inserir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tb_txtPesquisa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rb_forRazao = new javax.swing.JRadioButton();
        rb_forCodigo = new javax.swing.JRadioButton();
        rb_forCNPJ = new javax.swing.JRadioButton();
        rb_forFantasia = new javax.swing.JRadioButton();
        bt_pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BeautySystem - Pesquisa de Fornecedores");

        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        tblresultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Razão Social", "CNPJ", "Cidade", "Descrição", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblresultado);

        bt_inserir.setText("Inserir");
        bt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inserirActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisa:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa por:"));

        buttonGroup1.add(rb_forRazao);
        rb_forRazao.setText("Razão Social");

        buttonGroup1.add(rb_forCodigo);
        rb_forCodigo.setText("Código");

        buttonGroup1.add(rb_forCNPJ);
        rb_forCNPJ.setText("CNPJ");

        buttonGroup1.add(rb_forFantasia);
        rb_forFantasia.setText("Nome Fantasia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_forCodigo)
                    .addComponent(rb_forCNPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_forFantasia)
                    .addComponent(rb_forRazao))
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_forCodigo)
                    .addComponent(rb_forFantasia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_forCNPJ)
                    .addComponent(rb_forRazao)))
        );

        bt_pesquisar.setText("Pesquisar");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_inserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_sair))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_pesquisar)))
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
                    .addComponent(jLabel1)
                    .addComponent(tb_txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_pesquisar))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserir)
                    .addComponent(bt_sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inserirActionPerformed
        int index = tblresultado.getSelectedRow();
        objFornecedor.setCodigo(fornecedores.get(index).getCodigo());
        objFornecedor.setDescricao(fornecedores.get(index).getDescricao());
        Frm_Realizar_Compra f2 = (Frm_Realizar_Compra)parent;
        f2.setTb_Fornecedor(Integer.toString(fornecedores.get(index).getCodigo()),  objFornecedor);
        f2.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt_inserirActionPerformed

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
        if (!tb_txtPesquisa.getText().equals("")){
            if(rb_forCodigo.isSelected())
            {
                fornecedores = objFornecedorDAO.consultar("IdFornecedor", tb_txtPesquisa.getText(), 1);
                if (fornecedores.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    fornecedores.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getRazaoSocial(), p.getCNPJ(), p.getCidade(), p.getDescricao(),p.getSituacao()});
                    });
                }
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if(rb_forFantasia.isSelected())
            {
                fornecedores = objFornecedorDAO.consultar("NomeFantasia", tb_txtPesquisa.getText(), 1);
                if (fornecedores.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    fornecedores.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getRazaoSocial(), p.getCNPJ(), p.getCidade(), p.getDescricao(),p.getSituacao()});
                    });
                }

            }
            else if(rb_forCNPJ.isSelected())
            {
                fornecedores = objFornecedorDAO.consultar("CNPJ", tb_txtPesquisa.getText(), 1);
                if (fornecedores.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    fornecedores.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getRazaoSocial(), p.getCNPJ(), p.getCidade(), p.getDescricao(),p.getSituacao()});
                    });
                }
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else if(rb_forRazao.isSelected())
            {
                fornecedores = objFornecedorDAO.consultar("RazaoSocial", tb_txtPesquisa.getText(), 1);
                if (fornecedores.size()>0){
                    modelo = (DefaultTableModel)tblresultado.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
                    }
                    fornecedores.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getRazaoSocial(), p.getCNPJ(), p.getCidade(), p.getDescricao(),p.getSituacao()});
                    });
                }
                else {
                    JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Selecione um dos Filtros de Pesquisa","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Informe o valor da pesquisa!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_pesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Cons_For2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_For2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_For2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cons_For2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cons_For2(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_inserir;
    private javax.swing.JButton bt_pesquisar;
    private javax.swing.JButton bt_sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_forCNPJ;
    private javax.swing.JRadioButton rb_forCodigo;
    private javax.swing.JRadioButton rb_forFantasia;
    private javax.swing.JRadioButton rb_forRazao;
    private javax.swing.JTextField tb_txtPesquisa;
    private javax.swing.JTable tblresultado;
    // End of variables declaration//GEN-END:variables
}
