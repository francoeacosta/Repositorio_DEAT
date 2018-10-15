/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Octavio
 */
public class Pedido {

    private String nombreProducto;
    private String direccionEntrega;
    private String direccionBusqueda;
    private int precioEstimado;
    private Tarjeta tarjeta;
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setPrecioEstimado(int precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

  

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public Pedido(String nombreProducto, String direccionEntrega, String direccionBusqueda, int precioEstimado) {
        this.nombreProducto = nombreProducto;
        this.direccionEntrega = direccionEntrega;
        this.direccionBusqueda = direccionBusqueda;
        this.precioEstimado = precioEstimado;
    }

    
   

    public String getDireccionBusqueda() {
        return direccionBusqueda;
    }

    public void setDireccionBusqueda(String direccionBusqueda) {
        this.direccionBusqueda = direccionBusqueda;
    }

    public int getPrecioEstimado() {
        return precioEstimado;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

  
    

   

   
  
}
