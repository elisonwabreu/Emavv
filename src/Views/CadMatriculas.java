/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Metodos.GeraMatricula;
import Model.Gravar;
import Model.Selecionar;
import Model.Validacoes;
import Theme.Tema;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author elison
 */
public class CadMatriculas extends javax.swing.JFrame {

    Validacoes val = new Validacoes();
    Selecionar sel = new Selecionar();

    private MaskFormatter fmtDtCadastro;

    /**
     * Creates new form CadMatriculas
     */
    public CadMatriculas() {
        initComponents();
        setIcon();
        jGridMatricula.getColumnModel().getColumn(1).setMaxWidth(500);
        jGridMatricula.getColumnModel().getColumn(1).setMinWidth(450);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();  
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        jGridMatricula.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblCodigo1 = new javax.swing.JLabel();
        btnMatricula = new javax.swing.JButton();
        try {     
            fmtDtCadastro = new MaskFormatter("##/##/####");
        } catch (ParseException e) { 
            e.printStackTrace(); }
        txtDtCadastro = new javax.swing.JTextField();
        this.txtDtCadastro = new JFormattedTextField(fmtDtCadastro);
        lblCodigo2 = new javax.swing.JLabel();
        txtCodCurso = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtDescricaoCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jGridMatricula = new javax.swing.JTable();
        lblCodigo3 = new javax.swing.JLabel();
        lblCodigo4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa_16x16.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtNome.setEditable(false);
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        lblCodigo.setText("Cod.");

        lblNome.setText("Nome");

        txtMatricula.setEditable(false);
        txtMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });
        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyPressed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/confirma_16x16.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblCodigo1.setText("Matricula");

        btnMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Engrenagem.png"))); // NOI18N
        btnMatricula.setText("Gerar");
        btnMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculaActionPerformed(evt);
            }
        });

        txtDtCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDtCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDtCadastroActionPerformed(evt);
            }
        });
        txtDtCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDtCadastroKeyPressed(evt);
            }
        });

        lblCodigo2.setText("Data Matricula");

        txtCodCurso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodCursoKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa_16x16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDescricaoCurso.setEditable(false);

        jGridMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Disciplina"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jGridMatricula);

        lblCodigo3.setText("Cod.");

        lblCodigo4.setText("Curso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricaoCurso))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMatricula))
                            .addComponent(lblCodigo1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCodigo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDtCadastro))
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblCodigo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo3)
                                .addGap(84, 84, 84)
                                .addComponent(lblCodigo4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblNome))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo1)
                    .addComponent(lblCodigo2))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodigo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblCodigo4)
                        .addGap(8, 8, 8)
                        .addComponent(txtDescricaoCurso)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (val.KeyPressedText(this) == false) {
                try {
                    sel.ListarMAtricula(this);
                    val.ButtonClick(this); 
                } catch (SQLException ex) {
                    Logger.getLogger(CadMatriculas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        val.clickBtPesquisa(2, txtCodigo, "tb_alunos");
        txtCodigo.setEnabled(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaKeyPressed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Gravar novo = new Gravar();
        try {
            if(val.ValidaGravacaoMatricula(this)== true){
                novo.GravaMatricula(this);
            }
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(CadMatriculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtDtCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDtCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDtCadastroActionPerformed

    private void txtDtCadastroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDtCadastroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDtCadastroKeyPressed

    private void btnMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculaActionPerformed
        GeraMatricula novo = new GeraMatricula();
        novo.convertMatricula(this);
    }//GEN-LAST:event_btnMatriculaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        val.clickBtPesquisaa(4, this, "tb_cursos");
        txtCodigo.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodCursoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodCursoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                       sel.ListarCursos(this);
                       sel.ListarDisciplinas(this);
                        } catch (SQLException ex) {
                        Logger.getLogger(CadCursos.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }//GEN-LAST:event_txtCodCursoKeyPressed

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
            java.util.logging.Logger.getLogger(CadMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tema.Tema();
                new CadMatriculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnMatricula;
    public javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    public javax.swing.JTable jGridMatricula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblCodigo3;
    private javax.swing.JLabel lblCodigo4;
    private javax.swing.JLabel lblNome;
    public javax.swing.JTextField txtCodCurso;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDescricaoCurso;
    public javax.swing.JTextField txtDtCadastro;
    public javax.swing.JTextField txtMatricula;
    public javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/pc.png")));
    }
}
