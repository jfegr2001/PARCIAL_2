/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JFGIR
 */
public class Pedido {

    private int pedidoID;
    private String fechaPedido;
    private int total;
    private String clienteID;

    public Pedido(int pedidoID, String fechaPedido, int total, String clienteID) {
        this.pedidoID = pedidoID;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.clienteID = clienteID;
    }

    public Pedido(String fechaPedido, int total, String clienteID) {
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.clienteID = clienteID;
    }

    public Pedido(int pedidoID, int total) {
        this.pedidoID = pedidoID;
        this.total = total;
    }
    

    public int getPedidoID() {
        return pedidoID;
    }


    public Pedido(int total) {
        this.total = total;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

}
