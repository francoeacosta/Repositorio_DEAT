/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Soporte.GestorVentanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Octavio
 */
public class PagoEfectivoInterfazController implements Initializable {

    @FXML
    private ImageView imgTitulo;
    @FXML
    private ImageView imgview;
    @FXML
    private TextField txt_Pago;
    @FXML
    private Button btn_confirmar;
    private GestorVentanas g = new GestorVentanas();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Image titulo = new Image ("delivereat_owler_20170228_090215_original.png");
      Image imagen2 = new Image ("mobile01.png");
      imgTitulo.setImage(titulo);
      imgview.setImage(imagen2);
     
    }    

    @FXML
    private void handleConfirmar(ActionEvent event) {
        if(validarDatos()){
            if(validarNoVacio()){
        g.cerrarVentana(event);
        g.generarDialogoInformation("Su pedido a sido confirmado, sera entregado segun lo acordado");
        }
            else{
                g.generarDialogoError("Ingrese un monto porfavor");
            }
        }
        else{
             g.generarDialogoError("Ingrese un monto valido porfavor");
        }
        
        
    }
    
     private boolean validarDatos(){
        return g.isNumeric(txt_Pago.getText())  ;
    }
    
    private boolean validarNoVacio(){
        return !txt_Pago.getText().equals("") ;
    }
    
    
    
}
