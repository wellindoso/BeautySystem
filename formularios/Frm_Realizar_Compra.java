
package formularios;

import entidade.Fornecedor;
import entidade.Funcionario;
import entidade.Compra;
import entidade.Produto;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_Realizar_Compra extends javax.swing.JFrame {

   Produto objProduto = new entidade.Produto();
   Compra objCompra = new Compra();
   Fornecedor objFornecedor = new Fornecedor();
   Funcionario objFuncionario = new Funcionario();
   private dao.FuncionarioDAO objFuncionarioDAO = new dao.FuncionarioDAO();
    int operador;
   private dao.FornecedorDAO objFornecedorDAO = new dao.FornecedorDAO();
    private dao.ProdutoDAO objProdutoDAO = new dao.ProdutoDAO();
    private dao.CompraDAO objCompraDAO = new dao.CompraDAO();
     private DefaultTableModel modelo = new DefaultTableModel();
     private entidade.ItemCompra objItemCompra = new entidade.ItemCompra();
     private List <entidade.ItemCompra> itemcompra= new ArrayList(); 
     private List <entidade.Produto> produtos = new ArrayList();     
     Calendar calendar = new GregorianCalendar();  
    Date date = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    public Frm_Realizar_Compra(Compra objCompraPesq, int op) {
        initComponents();
        setLocationRelativeTo(null);
        operador = op;
        if(op==1)
        {
            tb_codigoCompra.setText(Integer.toString(objCompraPesq.getCodigo()));
            objCompra.setCodigo(objCompraPesq.getCodigo());
            date = objCompraPesq.getDataCompra();
            tb_dataCompra.setText(formatador.format(date));
            tb_fornecedorCompra.setText(Integer.toString(objCompraPesq.getFornecedor().getCodigo()));
            tb_funcionarioCompra.setText(Integer.toString(objCompraPesq.getFuncionario().getCodigo()));
            objCompra.setValorCompra(objCompraPesq.getValorCompra());
            lb_valorParcialCompra.setText(Double.toString(objCompraPesq.getValorCompra()));
            produtos = objCompraPesq.getProdutos();
            objCompra.setProdutos(produtos);
            bt_cancelar.setText("Cancelar Alteração");
            if(produtos.size()>0)
            {
             modelo = (DefaultTableModel)tblprodutos.getModel();
                    while(modelo.getRowCount()>0){
                        modelo.removeRow(0);
         }
                    produtos.stream().forEach((p) -> {
                        modelo.addRow(new Object[] {p.getCodigo(),p.getDescricao(), p.getQuantidade(),p.getValorCompra()});
                    });
            }     
        }
        else{
        calendar.setTime(date); 
        tb_dataCompra.setText(formatador.format(calendar.getTime()));
        tb_codigoCompra.setText(Integer.toString(objCompraDAO.retornaCodigo()));
        objCompra.setCodigo(objCompraDAO.retornaCodigo());
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lb_valorParcialCompra = new javax.swing.JLabel();
        tb_fornecedorCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tb_funcionarioCompra = new javax.swing.JTextField();
        bt_pesquisarFor = new javax.swing.JButton();
        bt_pesquisarFunc = new javax.swing.JButton();
        bt_inserir = new javax.swing.JButton();
        bt_finalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblprodutos = new javax.swing.JTable();
        bt_cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tb_dataCompra = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_descFor = new javax.swing.JLabel();
        lb_funcCompra = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tb_codigoCompra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        bt_cancelar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tb_codigoPro = new javax.swing.JTextField();
        bt_pesquisaPro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tb_quantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tb_valorItem = new javax.swing.JTextField();
        bt_inserirItem = new javax.swing.JButton();
        lb_Descricao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BeautySystem - Realizar Compra");

        lb_valorParcialCompra.setText("0,00");

        tb_fornecedorCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_fornecedorCompraFocusLost(evt);
            }
        });

        jLabel4.setText("Lista de Ítens");

        jLabel5.setText("Funcionário:");

        tb_funcionarioCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_funcionarioCompraFocusLost(evt);
            }
        });

        bt_pesquisarFor.setText("Pesquisar...");
        bt_pesquisarFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarForActionPerformed(evt);
            }
        });

        bt_pesquisarFunc.setText("Pesquisar...");
        bt_pesquisarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarFuncActionPerformed(evt);
            }
        });

        bt_inserir.setText("Inserir Ítem");
        bt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inserirActionPerformed(evt);
            }
        });

        bt_finalizar.setText("Finalizar Compra");
        bt_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_finalizarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setToolTipText("");

        tblprodutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblprodutos);

        bt_cancelar.setText("Cancelar Compra");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Data da Compra:");

        tb_dataCompra.setEditable(false);
        tb_dataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel3.setText("Valor Parcial da Compra(R$):");

        jLabel2.setText("Fornecedor:");

        jButton1.setText("Excluir Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Código da Compra:");

        tb_codigoCompra.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_inserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_finalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_valorParcialCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_funcionarioCompra))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tb_fornecedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_pesquisarFunc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_funcCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bt_pesquisarFor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_descFor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_codigoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_dataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tb_dataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tb_codigoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_descFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tb_fornecedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisarFor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_funcCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tb_funcionarioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisarFunc)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_valorParcialCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserir)
                    .addComponent(bt_finalizar)
                    .addComponent(bt_cancelar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        JTab.addTab("Compra", jPanel1);

        bt_cancelar1.setText("Cancelar");
        bt_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Código do Produto:");

        tb_codigoPro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_codigoProFocusLost(evt);
            }
        });

        bt_pesquisaPro.setText("Pesquisar...");
        bt_pesquisaPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisaProActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantidade:");

        tb_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_quantidadeFocusLost(evt);
            }
        });

        jLabel8.setText("Valor da Compra:");

        tb_valorItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_valorItemFocusLost(evt);
            }
        });

        bt_inserirItem.setText("Inserir");
        bt_inserirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inserirItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tb_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_valorItem))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tb_codigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pesquisaPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_Descricao, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_inserirItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar1)))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tb_codigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_pesquisaPro))
                    .addComponent(lb_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tb_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tb_valorItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserirItem)
                    .addComponent(bt_cancelar1))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        JTab.addTab("Inserção de Itens", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTab, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cancelar()
    {
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Cancelar a Operacao?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION)==0)
        {
            dispose();
        }
    }
    private void bt_pesquisarForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarForActionPerformed
        Frm_Cons_For2 f1 = new Frm_Cons_For2(Frm_Realizar_Compra.this);
        f1.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarForActionPerformed

    private void bt_pesquisarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarFuncActionPerformed
        Frm_Cons_Func_Compra f2 = new Frm_Cons_Func_Compra(Frm_Realizar_Compra.this);
        f2.setVisible(true);
    }//GEN-LAST:event_bt_pesquisarFuncActionPerformed

    private void bt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inserirActionPerformed
     if (tb_fornecedorCompra.getText().equals("") || tb_funcionarioCompra.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Preencha os campos relacionados a compra!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
     else 
     {
         JTab.setSelectedIndex(1);
     }
    }//GEN-LAST:event_bt_inserirActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar1ActionPerformed
    JTab.setSelectedIndex(0);
        tb_codigoPro.setText("");
        tb_quantidade.setText("");
        tb_valorItem.setText("");
        lb_Descricao.setText("");
    }//GEN-LAST:event_bt_cancelar1ActionPerformed
    void setTb_Fornecedor(String conteudo, Fornecedor fornecedor)
    {
        tb_fornecedorCompra.setText(conteudo);
        tb_fornecedorCompra.requestFocus();
    }
    void setTb_Funcionario(String conteudo, Funcionario funcionario)
    {
        tb_funcionarioCompra.setText(conteudo);
        tb_funcionarioCompra.requestFocus();
    }
    void setProduto(String conteudo, Produto produto)
    {
        tb_codigoPro.setText(conteudo);
        objProduto = produto;
    }
    
   void setlb_DescPro(String conteudo)
    {
        lb_Descricao.setText(conteudo);
        
    }
    void setTb_ValorItem(String conteudo)
    {
        tb_valorItem.setText(conteudo);
    }
    
    private void bt_pesquisaProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisaProActionPerformed
        Frm_Cons_Pro2 f1 = new Frm_Cons_Pro2(Frm_Realizar_Compra.this,1);
        f1.setVisible(true);
    }//GEN-LAST:event_bt_pesquisaProActionPerformed

    private void bt_inserirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inserirItemActionPerformed
    if (tb_fornecedorCompra.getText().equals("") || tb_funcionarioCompra.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, "Preencha os campos relacionados ao produto!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
        if(Double.valueOf(tb_valorItem.getText().replace(",", "."))!= objProduto.getValorCompra())
                {
                    objProduto.setValorCompra(Double.valueOf(tb_valorItem.getText().replace(",", ".")));
                    objProdutoDAO.editar(objProduto);
                }
        objCompra.getProdutos().add(objProduto);
        modelo = (DefaultTableModel)tblprodutos.getModel();
        modelo.addRow(new Object[]{objProduto.getCodigo(), objProduto.getDescricao(), objProduto.getQuantidade(), objProduto.getValorCompra()});
        objCompra.setValorCompra(objCompra.getValorCompra()+((objProduto.getQuantidade())* Double.valueOf(tb_valorItem.getText().replace(",", "."))));
        lb_valorParcialCompra.setText(Double.toString(objCompra.getValorCompra()));
        JTab.setSelectedIndex(0);
        tb_codigoPro.setText("");
        tb_quantidade.setText("");
        tb_valorItem.setText("");
        lb_Descricao.setText("");
    }
    }//GEN-LAST:event_bt_inserirItemActionPerformed

    private void tb_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_quantidadeFocusLost
     objProduto.setQuantidade(Integer.parseInt(tb_quantidade.getText()));
    }//GEN-LAST:event_tb_quantidadeFocusLost

    private void tb_valorItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_valorItemFocusLost
    objProduto.setQuantidade(Integer.parseInt(tb_valorItem.getText()));
    }//GEN-LAST:event_tb_valorItemFocusLost
 
    private void bt_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_finalizarActionPerformed

        if(operador == 1)
        {
            try{
            popularAtributos();
            objCompraDAO.editar(objCompra);
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            }
            catch (NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(this, "Erro"+e);
        } catch (ParseException ex) {
            Logger.getLogger(Frm_Realizar_Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
        try{
            popularAtributos();
            objCompraDAO.gravar(objCompra);
            JOptionPane.showMessageDialog(this, "Registro inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(this, "Erro"+e);
        } catch (ParseException ex) {
            Logger.getLogger(Frm_Realizar_Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_bt_finalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int index = tblprodutos.getSelectedRow();
    modelo = (DefaultTableModel)tblprodutos.getModel();
     double valorProdutoRemocao = objCompra.getProdutos().get(index).getValorCompra();
      int quantValorRemov = objCompra.getProdutos().get(index).getQuantidade();
     modelo.removeRow(index);
     objCompra.getProdutos().remove(index);
     objCompra.setValorCompra(objCompra.getValorCompra()-(quantValorRemov * valorProdutoRemocao));
     lb_valorParcialCompra.setText(Double.toString(objCompra.getValorCompra()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_fornecedorCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_fornecedorCompraFocusLost
        objFornecedor = objFornecedorDAO.consultar(Long.parseLong(tb_fornecedorCompra.getText()));
        if(objFornecedor.getDescricao()== null)
        {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            tb_fornecedorCompra.requestFocus();
            tb_fornecedorCompra.setText("");
        }
        else if(objFornecedor.getSituacao().equals("Bloqueado"))
        {
            JOptionPane.showMessageDialog(this, "Fornecedor "+objFornecedor.getNomeFantasia()+" Bloqueado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            tb_fornecedorCompra.requestFocus();
            tb_fornecedorCompra.setText("");
            lb_descFor.setText("");
            bt_inserir.setEnabled(false);
        }
        else{
        lb_descFor.setText(objFornecedor.getNomeFantasia());
        tb_funcionarioCompra.requestFocus();
        objCompra.setFornecedor(objFornecedor);
        bt_inserir.setEnabled(true);
        }
    }//GEN-LAST:event_tb_fornecedorCompraFocusLost

    private void tb_funcionarioCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_funcionarioCompraFocusLost
    objFuncionario = objFuncionarioDAO.consultar(Long.parseLong(tb_funcionarioCompra.getText()));
    if(objFuncionario.getNome() == null)
    {
        JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        tb_funcionarioCompra.requestFocus();
        tb_funcionarioCompra.setText("");
    }
    else
    {
    lb_funcCompra.setText(objFuncionario.getNome());    
    objCompra.setFuncionario(objFuncionario);
    bt_inserir.requestFocus();
    }
    }//GEN-LAST:event_tb_funcionarioCompraFocusLost

    private void tb_codigoProFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_codigoProFocusLost
    objProduto = objProdutoDAO.consultar(Long.parseLong(tb_codigoPro.getText()));
    if(objProduto.getDescricao()!= null)
    {
    setlb_DescPro(objProduto.getDescricao());
    setTb_ValorItem(Double.toString(objProduto.getValorCompra()));
    tb_quantidade.requestFocus();
    }
    else
    {
        JOptionPane.showMessageDialog(this, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        tb_codigoPro.requestFocus();
        tb_codigoPro.setText("");
    }
    }//GEN-LAST:event_tb_codigoProFocusLost
    
    private void popularAtributos() throws ParseException
    {
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
        objCompra.setCodigo(Integer.parseInt(tb_codigoCompra.getText()));
        java.sql.Date data = new java.sql.Date(format.parse(tb_dataCompra.getText()).getTime()); 
        objCompra.setDataCompra(data);
       objCompra.setFuncionario(objFuncionarioDAO.consultar(Long.parseLong(tb_funcionarioCompra.getText())));
       objCompra.setFornecedor(objFornecedorDAO.consultar(Long.parseLong(tb_fornecedorCompra.getText())));
    }    
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
            java.util.logging.Logger.getLogger(Frm_Realizar_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Realizar_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Realizar_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Realizar_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Realizar_Compra(null, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTab;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_cancelar1;
    private javax.swing.JButton bt_finalizar;
    private javax.swing.JButton bt_inserir;
    private javax.swing.JButton bt_inserirItem;
    private javax.swing.JButton bt_pesquisaPro;
    private javax.swing.JButton bt_pesquisarFor;
    private javax.swing.JButton bt_pesquisarFunc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Descricao;
    private javax.swing.JLabel lb_descFor;
    private javax.swing.JLabel lb_funcCompra;
    private javax.swing.JLabel lb_valorParcialCompra;
    private javax.swing.JTextField tb_codigoCompra;
    private javax.swing.JTextField tb_codigoPro;
    private javax.swing.JFormattedTextField tb_dataCompra;
    private javax.swing.JTextField tb_fornecedorCompra;
    private javax.swing.JTextField tb_funcionarioCompra;
    private javax.swing.JTextField tb_quantidade;
    private javax.swing.JTextField tb_valorItem;
    private javax.swing.JTable tblprodutos;
    // End of variables declaration//GEN-END:variables
}