/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Luiza
 */
public class Pedido {
     //atributos
    private int id;
    private Cliente cliente;
    private Date data;
    private String status;
    private double total;
    private String observacoes;

    //Construtor Default
    public Pedido() {
    }
    
    //Construtor Personificado

    public Pedido( Cliente cliente, String status, double total, String observacoes) {
        this.cliente = cliente;
        this.status = status;
        this.total = total;
        this.observacoes = observacoes;
    }

  
    
    // Encapsulamento - métodos geters e seters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
