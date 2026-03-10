package controller;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdbc.ModuloConexao;
import model.Usuario;
import view.TelaLogin;
import view.TelaPrincipal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author clebe
 */
public class UsuarioDAO {

    //Conexao
    private Connection con;

    public UsuarioDAO() {
        this.con = ModuloConexao.conectar();
    }

    /**
     * Método para realizar o login do Usuário no Sistema
     *
     * @param usuario String
     * @param senha String
     * @return true or false
     */
    public boolean logar(String usuario, String senha) {

        try {
            //1 passo - SQL
            String sql = "select * from usuarios where nome = ? and senha = md5(?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
               String perfil = rs.getString("perfil");
                
                if(perfil.equals("Administrador")){
                
                JOptionPane.showMessageDialog(null, "Acesso ao Sistema");
                TelaPrincipal tela = new TelaPrincipal();
                tela.setVisible(true);
                tela.jMnItmUsuario.setEnabled(true);
                tela.jMnRelatorio.setEnabled(true);
                tela.jLlbUsuario.setText(rs.getString("nome"));
                tela.jLlbUsuario.setForeground(Color.red);
                }else{
                JOptionPane.showMessageDialog(null, "Acesso ao Sistema");
                TelaPrincipal tela = new TelaPrincipal();
                tela.setVisible(true);
                tela.jMnItmUsuario.setVisible(false);
                tela.jMnRelatorio.setVisible(false);
                tela.jLlbUsuario.setText(rs.getString("nome"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválido!!!!");
                new TelaLogin().setVisible(true);
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    /**
     * Método responsável por adicionar um novo usuário
     */
    public void adicionarUsuario(Usuario obj) {

        try {
            //1 passo - criar o sql
            String sql = "insert into usuarios(nome, senha, perfil, nome_completo, email) values(?,md5(?),?,?,?)";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getPerfil());
            stmt.setString(4, obj.getNomeCompleto());
            stmt.setString(5, obj.getEmail());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!!");

        } catch (SQLIntegrityConstraintViolationException e1) {
            JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    /**
     * Método responsável por alterar um usuário
     *
     * @param Objeto do tipo Usuario
     *
     */
    public void alterarUsuario(Usuario obj) {

        try {
            //1 passo - criar o sql
            String sql = "update usuarios set nome=?, senha=md5(?), perfil=?, nome_completo=?, email=? where id_usuario=?";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getPerfil());
            stmt.setString(4, obj.getNomeCompleto());
            stmt.setString(5, obj.getEmail());
            stmt.setInt(6, obj.getId());
            System.out.println(stmt);
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!!");

        } catch (SQLIntegrityConstraintViolationException e1) {
            JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login.");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    /**
     * método responsável por deletar usuário
     *
     * @param int id
     */
    public void excluirUsuario(int id) {
        try {
            //1 passo - criar o sql
            String sql = "delete from usuarios where id_usuario = ?";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!!");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    /**
     * Método Listar Todos Usuários
     *
     * @param Usuário
     * @return Lista de Usuários Cadastrados na Base de Dados.
     */
    public List<Usuario> listarUsuarios() {
        try {

            //1 passo criar a lista
            List<Usuario> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from usuarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario obj = new Usuario();

                obj.setId(rs.getInt("id_usuario"));
                obj.setNome(rs.getString("nome"));
                obj.setSenha(rs.getString("senha"));
                obj.setPerfil(rs.getString("perfil"));
                obj.setNomeCompleto(rs.getString("nome_completo"));
                obj.setEmail(rs.getString("email"));
                obj.setDataCadastro(rs.getDate("data_cadastro"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

}
