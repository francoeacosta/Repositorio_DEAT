/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Tarjeta;
import Soporte.GestorVentanas;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Octavio
 */
public class PagoTarjetaInterfazController implements Initializable {

    @FXML
    private ImageView imgview;
    @FXML
    private DatePicker dtpk_fecha;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellido;
    @FXML
    private TextField txt_codigo;
    @FXML
    private Button btn_confirmar;
    @FXML
    private ImageView imgTitulo;
    private ArrayList<Tarjeta> tarjetasValidas = new ArrayList();
    @FXML
    private TextField txt_num1;
    @FXML
    private TextField txt_num2;
    @FXML
    private TextField txt_num3;
    @FXML
    private TextField txt_num4;
    private GestorVentanas g = new GestorVentanas();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image titulo = new Image("delivereat_owler_20170228_090215_original.png");
        Image imagen2 = new Image("mobile01.png");
        imgTitulo.setImage(titulo);
        imgview.setImage(imagen2);
        tarjetasValidas = getTarjetasValidas();
    }

    @FXML
    private void handleConfirmar(ActionEvent event) {
        if (validarTarjeta()) {
            g.cerrarVentana(event);
            g.generarDialogoInformation("Datos de la tarjeta ingresados correctamente");
            g.generarDialogoInformation("Su pedido va en camino sera entregado segun lo acordado");
        } else {
            g.generarDialogoError("Ingrese una tarjeta valida porfavor");
        }
    }

    public ArrayList<Tarjeta> getTarjetasValidas() {
        Tarjeta t1 = new Tarjeta("1234", "5678", "9123", "4567", "Octavio", "Santi", "352", LocalDate.of(2020, 10, 25));
        Tarjeta t2 = new Tarjeta("5789", "9999", "8888", "1111", "Camila", "Romero", "453", LocalDate.of(2020, 10, 28));
        Tarjeta t3 = new Tarjeta("1111", "2222", "3333", "4444", "Franco", "Acosta", "454", LocalDate.of(2020, 10, 29));
        Tarjeta t4 = new Tarjeta("5555", "6666", "7777", "8888", "Facundo", "Muñoz", "455", LocalDate.of(2019, 10, 30));
        Tarjeta t5 = new Tarjeta("2222", "3333", "4444", "5555", "Lucas", "Garcia", "346", LocalDate.of(2020, 11, 27));
        tarjetasValidas.add(t1);
        tarjetasValidas.add(t2);
        tarjetasValidas.add(t3);
        tarjetasValidas.add(t4);
        tarjetasValidas.add(t5);
        return tarjetasValidas;
    }

    public boolean validarTarjeta() {
        for (int i = 0; i < tarjetasValidas.size(); i++) {
            return txt_num1.getText().equals(tarjetasValidas.get(i).getNum1())
                    && txt_num2.getText().equals(tarjetasValidas.get(i).getNum2()) && txt_num3.getText().equals(tarjetasValidas.get(i).getNum3())
                    && txt_num4.getText().equals(tarjetasValidas.get(i).getNum4()) && txt_nombre.getText().equals(tarjetasValidas.get(i).getNombreTitular())
                    && txt_apellido.getText().equals(tarjetasValidas.get(i).getApellidoTitular()) && txt_codigo.getText().equals(tarjetasValidas.get(i).getCodigoSeguridad())
                    && dtpk_fecha.getValue().equals(tarjetasValidas.get(i).getFechaVencimiento());
        }
        return false;
    }

}
