/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import excepciones.ExcepcionLlaveForanea;
import excepciones.ExcepcionYaExisteCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;

import org.mariadb.jdbc.Connection;
import singleton.Singleton;

/**
 *
 * @author JFGIR
 */
public class ClientesDAO {

    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ClientesDAO() {
        connection = Singleton.getInstancia().getConnection();

    }

    public boolean validarDocumento(Cliente cliente) throws SQLException {

        ps = connection.prepareStatement(" SELECT * FROM clientes WHERE clienteID =?");
        ps.setString(1, cliente.getClienteID());
        rs = ps.executeQuery();

        if (rs.next()) {
            return true;
        }

        return false;
    }

    public void agregarCliente(Cliente cliente) throws ExcepcionYaExisteCliente, SQLException {

        if (validarDocumento(cliente)) {

            throw new ExcepcionYaExisteCliente();
        }

        ps = connection.prepareStatement("INSERT INTO clientes (clienteID, nombre, email) VALUES (?,?,?)");
        ps.setString(1, cliente.getClienteID());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getEmail());

        ps.execute();

    }

    public boolean eliminarClienteConPedidos(String clienteID) throws SQLException {

        ps = connection.prepareStatement("DELETE FROM pedidos WHERE clienteID = ?");
        ps.setString(1, clienteID);
        rs = ps.executeQuery();

        ps = connection.prepareStatement("DELETE FROM clientes WHERE clienteID = ?");
        ps.setString(1, clienteID);
        ps.executeUpdate();

        if (rs.next()) {

            return true;

        }
        return false;

    }

    public boolean editarCliente(Cliente cliente) throws SQLException, ExcepcionYaExisteCliente {

        ps = connection.prepareStatement("SELECT * FROM clientes WHERE clienteID=? AND clienteID <> ?");
        ps.setString(1, cliente.getClienteID());
        ps.setString(2, cliente.getClienteID());
        rs = ps.executeQuery();

        if (rs.next()) {

            throw new ExcepcionYaExisteCliente();
        }

        ps = connection.prepareStatement("UPDATE  clientes SET clienteID=?, nombre=?, email=? WHERE clienteID=?");

        ps.setString(1, cliente.getClienteID());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getClienteID());
        ps.executeUpdate();
        return true;
    }

}
