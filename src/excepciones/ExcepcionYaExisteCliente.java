/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author JFGIR
 */
public class ExcepcionYaExisteCliente extends  RuntimeException{

    public ExcepcionYaExisteCliente() {
        super("EL UN CLIENTE CON EL DOCUMENTO INGRESADO");
    }
    
    
    
}
