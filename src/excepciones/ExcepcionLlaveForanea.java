/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author JFGIR
 */
public class ExcepcionLlaveForanea  extends RuntimeException{

    public ExcepcionLlaveForanea() {
        super("""
              EL CLIENTE TIENE PEDIDOS REGISTRADOS
              No PUEDE SER ELIMINADO""");
    }
    
    
    
}
