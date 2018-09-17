/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Soporte.GestorVentanas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Octavio
 */
public class FormaDePagoInterfaz implements Initializable {

    @FXML
    private ComboBox<String> cmb_pago;
    @FXML
    private ImageView imgTitulo;
    @FXML
    private ImageView imgview;
    @FXML
    private Button btn_Siguiente;
    private GestorVentanas g = new GestorVentanas();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image titulo = new Image("delivereat_owler_20170228_090215_original.png");
        Image imagen2 = new Image("mobile01.png");
        imgTitulo.setImage(titulo);
        imgview.setImage(imagen2);
        cmb_pago.getItems().add("Efectivo");
        cmb_pago.getItems().add("Tarjeta");
    }

    @FXML
    private void handleButtonSiguiente(ActionEvent event) throws IOException {
        try {
            if (cmb_pago.getValue().equals(cmb_pago.getItems().get(0))) {
                abrirVentana("PagoEfectivoInterfaz.fxml");
                g.cerrarVentana(event);
            } else {
                abrirVentana("PagoTarjetaInterfaz.fxml");
                g.cerrarVentana(event);
            }
        } catch (RuntimeException ex) {
            g.generarDialogoError("Seleccione una forma de pago");
        }

    }

    private void abrirVentana(String nombreXML) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreXML));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
