/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Pedido;
import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author JFGIR
 */
public class PedidosDAO {

    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public PedidosDAO() {
        connection = Singleton.getInstancia().getConnection();
    }

    public void agregarPedido(Pedido pedido) throws SQLException {

        ps = connection.prepareStatement("INSERT INTO pedidos (fechaPedido, total, clienteID) VALUES(?,?,?)");
        ps.setString(1, pedido.getFechaPedido());
        ps.setInt(2, pedido.getTotal());
        ps.setString(3, pedido.getClienteID());

        ps.execute();

    }

    public boolean editarPedido(Pedido pedido) throws SQLException {

        ps = connection.prepareStatement("UPDATE pedidos SET total=? WHERE pedidoID=?");
        ps.setInt(1, pedido.getTotal());
        ps.setInt(2, pedido.getPedidoID());
        ps.executeUpdate();
        return true;
    }
    
    
     public boolean eliminarPedido(String pedidoID) throws SQLException {

         
        ps = connection.prepareStatement("DELETE FROM pedidos WHERE pedidoID=?");
        ps.setString(1, pedidoID);
        rs = ps.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;

    }
     
    

}
