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
    private String direccion;

    public Pedido(String nombreProducto, String direccion) {
        this.nombreProducto = nombreProducto;
        this.direccion = direccion;

    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
