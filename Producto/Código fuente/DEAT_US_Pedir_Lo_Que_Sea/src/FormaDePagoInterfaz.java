/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Soporte.GestorVentanas;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
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
    @FXML
    private CheckBox chk_antes;
    @FXML
    private DatePicker dtpk_fechaEntrega;
    @FXML
    private TextField txt_hora;
    @FXML
    private TextField txt_mins;

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
            if (validarHora() && validarNumerico()) {
                if (cmb_pago.getValue().equals(cmb_pago.getItems().get(0))) {
                    abrirVentana("PagoEfectivoInterfaz.fxml");
                    g.cerrarVentana(event);
                } else {
                    abrirVentana("PagoTarjetaInterfaz.fxml");
                    g.cerrarVentana(event);
                }
            } else {
                g.generarDialogoError("Ingrese una hora valida");
            }
        } catch (RuntimeException ex) {
            g.generarDialogoError("Seleccione una forma de pago");
        }

    }

    private boolean validarHora() {
        int hora = Integer.parseInt(txt_hora.getText());
        int minutos = Integer.parseInt(txt_mins.getText());
        if (chk_antes.isSelected()) {
            return true;
        } else {

            
            return hora <= 24 && hora >= 0 && minutos >= 0 && minutos <= 60;
        }

    }

    private boolean validarNumerico() {
        if (chk_antes.isSelected()) {
            return true;
        } else {

            return g.isNumeric(txt_hora.getText()) && g.isNumeric(txt_mins.getText());

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

    @FXML
    private void chk_checked(ActionEvent event) {
        if (chk_antes.isSelected()) {
            dtpk_fechaEntrega.setDisable(true);
            txt_hora.setDisable(true);
            txt_mins.setDisable(true);
        } else {
            dtpk_fechaEntrega.setDisable(false);
            txt_hora.setDisable(false);
            txt_mins.setDisable(false);
        }
    }

}
