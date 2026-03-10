/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/**
 *
 * @author clebe
 */
public class TelaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
    }

    //Metodo Listar na tabela
    public void listar() {

        UsuarioDAO dao = new UsuarioDAO();

        List<Usuario> lista = dao.listarUsuarios();
        DefaultTableModel dados = (DefaultTableModel) jTblUsuario.getModel();
        dados.setNumRows(0);

        for (Usuario c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getSenha(),
                c.getPerfil(),
                c.getNomeCompleto(),
                c.getEmail(),});

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtNomeUsuario = new javax.swing.JTextField();
        jTxtNomeCompleto = new javax.swing.JTextField();
        jTxtEmail = new javax.swing.JTextField();
        jTxtSenha = new javax.swing.JPasswordField();
        jCbxPerfil = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblUsuario = new javax.swing.JTable();
        jBtnAdicionar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nome Usuário:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Senha: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Perfil Acesso:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nome Completo:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("E-mail:");

        jCbxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Administrador" }));

        jTblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdUsuario", "Nome Usuário", "Senha", "Perfil Acesso", "Nome Completo", "E-mail"
            }
        ));
        jTblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblUsuario);

        jBtnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/create.png"))); // NOI18N
        jBtnAdicionar.setToolTipText("Adiconar Usuário");
        jBtnAdicionar.setMaximumSize(new java.awt.Dimension(80, 80));
        jBtnAdicionar.setMinimumSize(new java.awt.Dimension(80, 80));
        jBtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdicionarActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        jBtnEditar.setToolTipText("Editar Usuário");
        jBtnEditar.setEnabled(false);
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        jBtnExcluir.setToolTipText("Excluir Usuário");
        jBtnExcluir.setEnabled(false);
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jMenu1.setMnemonic('a');
        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('s');
        jMenu2.setText("Sair");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jBtnEditar)
                        .addGap(127, 127, 127)
                        .addComponent(jBtnExcluir)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtNomeCompleto)
                                .addComponent(jTxtEmail)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTxtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtnEditar, jBtnExcluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jCbxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtnAdicionar, jBtnEditar, jBtnExcluir});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdicionarActionPerformed
        if ((jTxtNomeUsuario.getText().isEmpty()) || (jTxtSenha.getText().isEmpty())
                || (jTxtNomeCompleto.getText().isBlank()) || (jCbxPerfil.getSelectedItem().equals(" ")) || (jTxtEmail.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!");
        } else {

            String nome = jTxtNomeUsuario.getText();
            String senha = jTxtSenha.getText();
            String perfil = jCbxPerfil.getSelectedItem().toString();
            String nomeCompleto = jTxtNomeCompleto.getText();
            String email = jTxtEmail.getText();

            Usuario usuario = new Usuario(nome, senha, perfil, nomeCompleto, email);

            UsuarioDAO dao = new UsuarioDAO();
            dao.adicionarUsuario(usuario);
            jTxtNomeUsuario.setText("");
            jTxtEmail.setText(null);
            jTxtNomeCompleto.setText(null);
            jTxtSenha.setText(null);
            jCbxPerfil.setSelectedItem("Usuário");
            jBtnAdicionar.setEnabled(true);
            jBtnEditar.setEnabled(false);
            jBtnExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnAdicionarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void jTblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblUsuarioMouseClicked
//        jTxtNomeUsuario.setText(jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 0).toString());
        jTxtNomeUsuario.setText(jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 1).toString());
        jTxtSenha.setText(jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 2).toString());
        jCbxPerfil.setSelectedItem(jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 3).toString());
        jTxtNomeCompleto.setText(jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 4).toString());
        jTxtEmail.setText(jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 5).toString());
        jBtnAdicionar.setEnabled(false);
        jBtnEditar.setEnabled(true);
        jBtnExcluir.setEnabled(true);

    }//GEN-LAST:event_jTblUsuarioMouseClicked

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        if ((jTxtNomeUsuario.getText().isEmpty()) || (jTxtSenha.getText().isEmpty())
                || (jTxtNomeCompleto.getText().isBlank()) || (jCbxPerfil.getSelectedItem().equals(" ")) || (jTxtEmail.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!");
        } else {

            String nome = jTxtNomeUsuario.getText();
            String senha = jTxtSenha.getText();
            String perfil = jCbxPerfil.getSelectedItem().toString();
            String nomeCompleto = jTxtNomeCompleto.getText();
            String email = jTxtEmail.getText();
            int id = (int) jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 0);
            Usuario usuario = new Usuario(id, nome, senha, perfil, nomeCompleto, email);

            UsuarioDAO dao = new UsuarioDAO();
            dao.alterarUsuario(usuario);
            jTxtNomeUsuario.setText("");
            jTxtEmail.setText(null);
            jTxtNomeCompleto.setText(null);
            jTxtSenha.setText(null);
            jCbxPerfil.setSelectedItem("Usuário");
            jBtnAdicionar.setEnabled(true);
            jBtnEditar.setEnabled(false);
            jBtnExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if ((jTxtNomeUsuario.getText().isEmpty()) || (jTxtSenha.getText().isEmpty())
                || (jTxtNomeCompleto.getText().isBlank()) || (jCbxPerfil.getSelectedItem().equals(" ")) || (jTxtEmail.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!");
        } else {

            UsuarioDAO dao = new UsuarioDAO();
            int resp = JOptionPane.showConfirmDialog(null, "Confirma exclusão do Usuário\n" + jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 1));

            if (resp == 0) {
                dao.excluirUsuario((int) jTblUsuario.getValueAt(jTblUsuario.getSelectedRow(), 0));
            }
            jTxtNomeUsuario.setText("");
            jTxtEmail.setText(null);
            jTxtNomeCompleto.setText(null);
            jTxtSenha.setText(null);
            jCbxPerfil.setSelectedItem("Usuário");
            jBtnAdicionar.setEnabled(true);
            jBtnEditar.setEnabled(false);
            jBtnExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdicionar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JComboBox<String> jCbxPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblUsuario;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtNomeCompleto;
    private javax.swing.JTextField jTxtNomeUsuario;
    private javax.swing.JPasswordField jTxtSenha;
    // End of variables declaration//GEN-END:variables
}
