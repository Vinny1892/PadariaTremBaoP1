/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.relatorio;

import controller.ControllerInformacao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author mateus
 */
public class FXMLRelatorio implements Initializable {

    
    private ControllerInformacao cf;
    
    @FXML
    private Button search;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // cf = new ControllerInformacao();
    }    
    
    @FXML
    void btnCreatePDF (ActionEvent event) {
        

    }
    
}
