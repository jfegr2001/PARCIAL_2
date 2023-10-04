/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.ClientesDAO;
import dao.PedidosDAO;
import java.sql.SQLException;
import modelo.Pedido;

/**
 *
 * @author JFGIR
 */
public class ControladorPedidos {

    PedidosDAO pedidosDAO;

    public ControladorPedidos() {
        pedidosDAO = new PedidosDAO();
    }

    public void agregarPedido(Pedido pedido) throws SQLException {

        pedidosDAO.agregarPedido(pedido);
    }

    public boolean editarPedido(Pedido pedido) throws SQLException {
        return pedidosDAO.editarPedido(pedido);

    }

    public boolean eliminarPedido(String pedidoID) throws SQLException {
        return pedidosDAO.eliminarPedido(pedidoID);
    }

}
