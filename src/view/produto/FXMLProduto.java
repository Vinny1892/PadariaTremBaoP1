/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.produto;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.GestaoProduto;
import view.CategoriasComboBox;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLProduto implements Initializable {
    private ControllerProduto cp;
    private ArrayList<GestaoProduto> produtos;
    private ArrayList<CategoriasComboBox> categorias;
    private ObservableList<CategoriasComboBox> obsCategorias;
    private ObservableList<GestaoProduto> obsGestaoProdutos;
    
    
      @FXML
    private Button btnBuscar;

    @FXML
    private TableView<GestaoProduto> tableProduto;

    @FXML
    private TableColumn<GestaoProduto, String> tableColumnNome;

    @FXML
    private TableColumn<GestaoProduto, String> tableColumnCodigo;

    @FXML
    private TextField textFieldProduto;

    @FXML
    private ComboBox<CategoriasComboBox> comboBoxProduto;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltar;

    @FXML
    void btnAdicionarAction(ActionEvent event) {
         Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLFormProduto.fxml"));
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
        if(comboBoxProduto.getSelectionModel().getSelectedItem().getNome().equals("Nome")){
            for (int i = 0 ;i <produtos.size();i++){
                if(textFieldProduto.getText().equals(produtos.get(i).getNome())){
                    tableProduto.getSelectionModel().select(produtos.get(i));
                    btnRemover.setDisable(false);
                }
            }
        }
        if(comboBoxProduto.getSelectionModel().getSelectedItem().getNome().equals("Codigo")){
             for (int i = 0 ;i <produtos.size();i++){
                 
                if(textFieldProduto.getText().equals(String.valueOf(produtos.get(i).getIdproduto()))){
                    tableProduto.getSelectionModel().select(produtos.get(i));
                    btnRemover.setDisable(false);
                }
            }
        }
    }

    @FXML
    void btnRemoverAction(ActionEvent event) throws SQLException {
        GestaoProduto produtoDeletar = tableProduto.getSelectionModel().getSelectedItem();
        cp.deletar(String.valueOf(produtoDeletar.getIdproduto()));
        tableProduto.getItems().remove(produtoDeletar);

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cp = new ControllerProduto();
      try {
            produtos = cp.getAll();
      } catch (SQLException ex) {
            System.out.println("Erro ao buscar Produtos do Banco");
        }
       inicializarComboBox();
        inicializarTabela();
        
    }

public void inicializarComboBox(){
    categorias = new ArrayList<CategoriasComboBox>();
     CategoriasComboBox comboBoxNomeProduto = new CategoriasComboBox("Nome", 1);
     CategoriasComboBox comboBoxCodigoProduto = new CategoriasComboBox("Codigo", 2);
     categorias.add(comboBoxNomeProduto);
     categorias.add(comboBoxCodigoProduto);
     obsCategorias= FXCollections.observableArrayList(categorias);
     comboBoxProduto.setItems(obsCategorias);
     comboBoxProduto.getSelectionModel().select(comboBoxNomeProduto);
    
}   

public void inicializarTabela(){
    tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    obsGestaoProdutos = FXCollections.observableArrayList(produtos);
    tableProduto.setItems(obsGestaoProdutos);
    
}
    
}
