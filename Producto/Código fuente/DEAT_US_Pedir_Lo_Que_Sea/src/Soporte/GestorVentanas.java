package Soporte;




import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Octavio
 */
public class GestorVentanas {
    
    
    public void cerrarVentana(ActionEvent event){
        final Node source = (Node) event.getSource(); 
        final Stage stage1 = (Stage) source.getScene().getWindow(); 
        stage1.close(); 
    }
    
    public void generarDialogoError(String texto){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("DeliverEAT");
            alert.setHeaderText(null);
            alert.setContentText(texto);
            alert.showAndWait();
    }
    
    public void generarDialogoInformation(String texto){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DeliverEAT");
            alert.setHeaderText(null);
            alert.setContentText(texto);
            alert.showAndWait();
    }

    public boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    
}
