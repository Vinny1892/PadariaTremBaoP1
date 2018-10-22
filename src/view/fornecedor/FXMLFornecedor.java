/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fornecedor;

import controller.ControllerFornecedor;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewFocusModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.GestaoFornecedor;
import view.CategoriasComboBox;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFornecedor implements Initializable {
    
     private ControllerFornecedor cf ;
     private ArrayList<GestaoFornecedor> fornecedores;
    private ArrayList<CategoriasComboBox> categorias;
    private ObservableList<CategoriasComboBox> obsCategoriasComboBox;
     private ObservableList<GestaoFornecedor> obsTableList;
     
     
     @FXML
    private Button btnVoltar;
        @FXML
    private Button btnBuscar;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRemover;
    
       @FXML
    private TableColumn<GestaoFornecedor, String> tableColumnNome;

    @FXML
    private TableColumn<GestaoFornecedor, String> tableColumnCNPJ;

    
     @FXML
    private TableView<GestaoFornecedor> tableFornecedor;

    @FXML
    private TextField textFieldFornecedor;

    @FXML
    private ComboBox<CategoriasComboBox> comboBoxFornecedor;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cf = new ControllerFornecedor();
        try {
            fornecedores = cf.getAll();
        } catch (SQLException ex) {
            System.out.println("Erro ao achar fornecedores");
        }
        inicializarComboBox();
        inicializarTableView();
        

       
    }
    public void inicializarTableView(){
        tableColumnCNPJ.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        obsTableList = FXCollections.observableArrayList(fornecedores);
        tableFornecedor.setItems(obsTableList);
        
        
    }

        public void inicializarComboBox(){
            categorias = new ArrayList<CategoriasComboBox>();
            CategoriasComboBox categoriaCNPJ  = new CategoriasComboBox("CNPJ" , 1);
            CategoriasComboBox categoriaNome = new CategoriasComboBox("Nome", 2);
              categorias.add(categoriaNome);
            categorias.add(categoriaCNPJ);
          
            obsCategoriasComboBox = FXCollections.observableArrayList(categorias);
            comboBoxFornecedor.setItems(obsCategoriasComboBox);
            comboBoxFornecedor.getSelectionModel().select(categoriaNome);
           
            
            
            
        }  
        
     @FXML
    void btnAdicionarAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLFormFornecedor.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnAdicionar.getScene().getWindow().hide();

    }

    @FXML
    void btnBuscarAction(ActionEvent event) {
        if(comboBoxFornecedor.getSelectionModel().getSelectedItem().getNome().equals("Nome")){
            for(int i = 0 ;i<fornecedores.size();i++){
                if(fornecedores.get(i).getNome().equals(textFieldFornecedor.getText())){
                   tableFornecedor.getSelectionModel().select(fornecedores.get(i));
                            }
            }
        
        } if(comboBoxFornecedor.getSelectionModel().getSelectedItem().getNome().equals("CNPJ")){
            for(int i = 0 ;i<fornecedores.size();i++){
                if(fornecedores.get(i).getCnpj().equals(textFieldFornecedor.getText())){
                   tableFornecedor.getSelectionModel().select(fornecedores.get(i));
                            }
            }
        
        }
        //todo IMplementar Alert de erro;
        
    }

    @FXML
    void btnRemoverAction(ActionEvent event) throws SQLException {
        GestaoFornecedor fornecedor = tableFornecedor.getSelectionModel().getSelectedItem();
        new ControllerFornecedor().deletar(fornecedor.getCnpj());
        tableFornecedor.getItems().remove(fornecedor);

    }
    @FXML
    void btnVoltarAction(ActionEvent event){
         Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../main/FXMLMain.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnVoltar.getScene().getWindow().hide();
    }    
    
}
