/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ModuloConexao;
import model.Cliente;
import model.Pedido;
import model.Usuario;
import model.WebServiceCep;

/**
 *
 * @author Luiza
 */
public class PedidoDAO {
    
    private Connection con;

    public PedidoDAO() {
        this.con = ModuloConexao.conectar();
    }
    
     ClienteDAO dao = new ClienteDAO();
    
    List<Cliente> lista = dao.listarClientes();
    
    
   /**
     * Método responsável por adicionar um novo Pedido
     */
    public void adicionarPedido(Pedido obj) {

        try {
            //1 passo - criar o sql
            String sql = "insert into pedidos(id_cliente, status, valor_total, observacoes ) values(?,?,?,?)";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getStatus());
            stmt.setDouble(3, obj.getTotal());
            stmt.setString(4, obj.getObservacoes());
            
            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!!");

        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void alterarPedido(Pedido obj) {

        try {
            //1 passo - criar o sql
            String sql = "update pedidos set data_pedido=?, status=?, valor_total=?, observacoes=? where id_pedido=?";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setTimestamp(1, new java.sql.Timestamp(obj.getData().getTime())); 
                stmt.setString(2, obj.getStatus());
                stmt.setDouble(3, obj.getTotal()); 
                stmt.setString(4, obj.getObservacoes()); 
                
                stmt.setInt(5, obj.getId());
                
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
    
    public void excluirPedido(int id) {
        try {
            //1 passo - criar o sql
            String sql = "delete from pedido where id_pedido = ?";
            //2 passo o conectar o banco de dados e organizar o comando sql
            con = ModuloConexao.conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "pedido excluído com sucesso!!");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
      

    
    
    
    
}
