/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.ClientesDAO;
import excepciones.ExcepcionYaExisteCliente;
import java.sql.SQLException;
import modelo.Cliente;

/**
 *
 * @author JFGIR
 */
public class ControladorClientes {

    ClientesDAO clientesDAO;

    public ControladorClientes() {
        clientesDAO = new ClientesDAO();

    }
    
     public void agregarCliente(Cliente cliente) throws ExcepcionYaExisteCliente, SQLException {
         
         clientesDAO.agregarCliente(cliente);
     }
     
      public boolean eliminarCliente(String clienteID) throws SQLException {
      
      return  clientesDAO.eliminarClienteConPedidos(clienteID);
      }
      
      
      public boolean editarCliente(Cliente cliente) throws SQLException, ExcepcionYaExisteCliente {
      
       return clientesDAO.editarCliente(cliente);
      }
      
      
      
     
     
     

}
