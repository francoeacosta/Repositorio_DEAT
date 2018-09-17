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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Clases.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Soporte.GestorVentanas;


/**
 *
 * @author Octavio
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField txt_domicilio;
    @FXML
    private Button btn_siguiente;
    @FXML
    private TextField txt_Producto;
    @FXML
    private Button btn_imagen;
    @FXML
    private ImageView imview;
    @FXML
    private Label lblImagen;
    @FXML
    private ImageView imgTitulo;
    @FXML
    private ImageView imgSubida;
    @FXML
    private ImageView imgUbicacion;
    @FXML
    private Button btn_ubicacion;
    private GestorVentanas g = new GestorVentanas();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Image titulo = new Image ("delivereat_owler_20170228_090215_original.png");
      Image imagen2 = new Image ("mobile01.png");
      Image imagen3 = new Image ("unnamed.png");
      Image imagen4 = new Image ("ubicacion.png");
      imgTitulo.setImage(titulo);
      imview.setImage(imagen2);
      imgSubida.setImage(imagen3);
      imgUbicacion.setImage(imagen4);
      
    }    
    
    public void tomarDatos(){
        String nombreProducto = txt_Producto.getText();
        String domicilio = txt_domicilio.getText();
        Pedido pedido = new Pedido(nombreProducto, domicilio);
    }

    @FXML
    private void handleButtonSubir(ActionEvent event) { 
        try {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Abrir Imagen");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes (*.jpg)", "*.jpg"));
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes (*.png)", "*.png"));
        File file = chooser.showOpenDialog(null);
        String url = file.toURI().toURL().toString();
        Image imagen = new Image(url);
        imgSubida.setImage(imagen);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void seleccionarUbicacion(ActionEvent event) {
         try {
          FileChooser chooser = new FileChooser();
        chooser.setTitle("seleccionar Ubicacion");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes (*.jpg)", "*.jpg"));
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG (*.png)", "*.png"));
        File file = chooser.showOpenDialog(null);
            String url = file.toURI().toURL().toString();
            Image imagen = new Image(url);
            imgUbicacion.setImage(imagen);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleButtonSiguiente(ActionEvent event) throws IOException {
        if(validarDatos() && validarNoVacio()){
    
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormaDePagoInterfaz.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        g.generarDialogoInformation("Prosiga a seleccionar una forma de pago");
        g.cerrarVentana(event);
       
        }
        else{
            g.generarDialogoError("Ingrese datos validos porfavor");
        }
    }
    
    private boolean validarDatos(){
        return !g.isNumeric(txt_Producto.getText()) && !g.isNumeric(txt_domicilio.getText()) ;
    }
    
    private boolean validarNoVacio(){
        return !txt_Producto.getText().equals("") && !txt_domicilio.getText().equals("");
    }
    
    
    
}
