/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.main;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author VinnyWindows
 */
public class Main extends Application {
    
    @FXML
    private Button btnFornecedor;

    @FXML
    private Button btnProduto;

    @FXML
    private Button btnFuncionario;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnVenda;

    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnRelatorio;

    @FXML
    private Label labelMain;
    
     
   

   
    
     @FXML
    void btnProdutoAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../produto/FXMLProduto.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnProduto.getScene().getWindow().hide();

    }
    @FXML
    void btFornecedorAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../fornecedor/FXMLFornecedor.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnFornecedor.getScene().getWindow().hide();
    }
    
    
     @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
