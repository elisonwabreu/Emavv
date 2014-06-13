/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import org.entities.classes.tb_disciplinas;
import Model.Gravar;
import Model.Validacoes;
import Funcao.Limpar;
import Model.Deletar;
import Funcao.InsereNumeros;
import Model.Selecionar;
import Theme.Tema;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author suporte
 */
public class CadDisciplinas extends javax.swing.JFrame {

    tb_disciplinas diciplina = new tb_disciplinas(0, null, null);
    Gravar novoDisciplina = new Gravar();
    Validacoes val = new Validacoes();
    Limpar limpa = new Limpar();
    Deletar deleta = new Deletar();
    Selecionar select = new Selecionar();

    private JFormattedTextField textoF3;
    private MaskFormatter fmtCpf;
    private MaskFormatter fmtDtNascimento;
    private Object fmtTelefone;
    private MaskFormatter fmtCelular;
    private MaskFormatter fmtFone;

    /**
     * Creates new form Form_Principal
     */
    public CadDisciplinas() {
        initComponents();
        txtCodDisciplina.setDocument(new InsereNumeros());
        setIcon();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        txtCodDisciplina = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtDisciplina = new javax.swing.JTextField();
        comboStatus = new javax.swing.JComboBox();
        lblCodigo = new javax.swing.JLabel();
        lblDisciplina = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        bntRelatorio = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox();
        lblStatus1 = new javax.swing.JLabel();
        lblDisciplina1 = new javax.swing.JLabel();
        lblCodigo1 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EMAVV");
        setResizable(false);

        txtCodDisciplina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodDisciplinaActionPerformed(evt);
            }
        });
        txtCodDisciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodDisciplinaKeyPressed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa_16x16.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtDisciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDisciplinaKeyReleased(evt);
            }
        });

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Ativo", "Inativo" }));

        lblCodigo.setText("Cod.");

        lblDisciplina.setText("Discipliana");

        lblStatus.setText("Status");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/confirma_16x16.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/deletar_16x16.png"))); // NOI18N
        btnExcluir.setText("Deletar");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        bntRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/relatorio_16x16.png"))); // NOI18N
        bntRelatorio.setText("Relatório");

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vassoura_16x16.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

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

        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa_16x16.png"))); // NOI18N
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        txtDescricao.setEditable(false);
        txtDescricao.setEnabled(false);
        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyReleased(evt);
            }
        });

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Ativo", "Inativo" }));
        cbStatus.setEnabled(false);

        lblStatus1.setText("Status");

        lblDisciplina1.setText("Curso");

        lblCodigo1.setText("Cod. Curso");

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
                                .addComponent(txtCodDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisciplina))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(114, 114, 114)
                        .addComponent(bntRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCodigo1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisciplina1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus1)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo1)
                    .addComponent(lblDisciplina1)
                    .addComponent(lblStatus1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblDisciplina)
                    .addComponent(lblStatus))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDisciplina, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        limpa.LimpaDisciplina(this);

    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtCodDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodDisciplinaActionPerformed
    }//GEN-LAST:event_txtCodDisciplinaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        val.clickBtPesquisa(5, txtCodDisciplina, "tb_disciplinas");
        txtCodDisciplina.setEnabled(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (val.ValidaGravacaoDisciplina(this) == true) {
            try {
                novoDisciplina.DisciplinaGravar(this);
                limpa.LimpaDisciplina(this);
            } catch (SQLException ex) {
                Logger.getLogger(CadDisciplinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            deleta.Delete(this);
            limpa.LimpaDisciplina(this);
            val.ButtonClick(this);
        } catch (SQLException ex) {
            Logger.getLogger(CadDisciplinas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtCodDisciplinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodDisciplinaKeyPressed
       
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                if (val.KeyPressedText(this) == false){
                    select.ListarDisciplinas(this);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadDisciplinas.class.getName()).log(Level.SEVERE, null, ex);
            }
              txtCodDisciplina.setEnabled(true);
        }
    }//GEN-LAST:event_txtCodDisciplinaKeyPressed

    private void txtDisciplinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDisciplinaKeyReleased
       val.setTextUp(this);
    }//GEN-LAST:event_txtDisciplinaKeyReleased

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(this.txtCodigo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o Código do Curso"/*,JOptionPane.ERROR_MESSAGE*/);
            }else{
            try {
                select.ListarCursos(this);
                 } catch (SQLException ex) {
                Logger.getLogger(CadDisciplinas.class.getName()).log(Level.SEVERE, null, ex);
            }
                       
                } 
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        val.clickBtPesquisa(4, txtCodigo, "tb_cursos");
        txtCodigo.setEnabled(true);
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoKeyReleased

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
            java.util.logging.Logger.getLogger(CadDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadDisciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tema.Tema();
                new CadDisciplinas().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bntRelatorio;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnBuscar1;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnLimpar;
    public javax.swing.JButton btnSalvar;
    public javax.swing.JComboBox cbStatus;
    public javax.swing.JComboBox comboStatus;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JLabel lblDisciplina1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    public javax.swing.JTextField txtCodDisciplina;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDescricao;
    public javax.swing.JTextField txtDisciplina;
    // End of variables declaration//GEN-END:variables
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Img/pc.png")));
    }
}
