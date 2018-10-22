/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.produto;

import controller.ControllerFornecedor;
import controller.ControllerProduto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.GestaoFornecedor;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFormProduto implements Initializable {
    ControllerFornecedor cf ;
    ArrayList<GestaoFornecedor> fornecedores;
        private ObservableList<GestaoFornecedor> obsCategoriasFornecedor;

      @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldApelido;

    @FXML
    private TextField textFieldCodigo;
    
       @FXML
    private TextField textFieldValorCusto;

    @FXML
    private CheckBox checkBoxPerecivel;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ComboBox<GestaoFornecedor> comboBoxFornecedor;

    @FXML
    void btnSalvarAction(ActionEvent event) throws SQLException {
        GestaoFornecedor fornecedor = null;
        if(validaCodigo() && !textFieldNome.getText().equals("") && !textFieldApelido.getText().equals("") && fornecedor!= null){
            fornecedor = comboBoxFornecedor.getSelectionModel().getSelectedItem();
            new ControllerProduto().salvar(textFieldNome.getText(), fornecedor, Float.parseFloat(textFieldValorCusto.getText()) , textFieldApelido.getText());
        }else{
          
             Alert alert = new Alert(Alert.AlertType.NONE,"Não Deixe Campos Vazios", ButtonType.OK);
             alert.setTitle("Erro Campos Formulario"); 
             alert.show();
            
        }
        

    }
    public boolean validaCodigo(){
        return true;
    }
    

    @FXML
    void btnVoltarAction(ActionEvent event) throws SQLException {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLProduto.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnVoltar.getScene().getWindow().hide();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cf = new ControllerFornecedor();
        try {
            fornecedores = cf.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLFormProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicializarComboBox();
        
    }   
    
    public void inicializarComboBox(){
        obsCategoriasFornecedor = FXCollections.observableArrayList();
       
        comboBoxFornecedor.setItems(obsCategoriasFornecedor);
        if(fornecedores.size() > 0){
            comboBoxFornecedor.getSelectionModel().select(fornecedores.get(0));
        }else{
            comboBoxFornecedor.setEditable(false);
        }
        
    }
    
}
