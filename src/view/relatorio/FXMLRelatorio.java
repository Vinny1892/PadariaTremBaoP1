/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.relatorio;

//import controller.ControllerInformacao;
import controller.ControllerInformacao;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GestaoCliente;
import view.CategoriasComboBox;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author mateus
 */
public class FXMLRelatorio implements Initializable {

    private ToggleGroup group;
    private ControllerInformacao cf;
    private ArrayList<CategoriasComboBox> categorias;
    private ObservableList<CategoriasComboBox> obsGestaoCategorias;

    @FXML
    private ComboBox<CategoriasComboBox> optionsSelector;

    @FXML
    private Button search;

    @FXML
    private Button voltar;

    @FXML
    private Text infoCodigo;

    @FXML
    private TextField codigo;

    @FXML
    private TextField output;

    @FXML
    private RadioButton individual;

    @FXML
    private RadioButton coletivo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group = new ToggleGroup();
        individual.setToggleGroup(group);
        coletivo.setToggleGroup(group);
        codigo.setVisible(false);
        infoCodigo.setVisible(false);
        group.selectedToggleProperty().addListener((observable) -> {
            if (coletivo.isSelected()) {
                codigo.setVisible(false);
                infoCodigo.setVisible(false);
            } else {
                codigo.setVisible(true);
                infoCodigo.setVisible(true);
            }
        });
        inicializarComboBox();
    }

    @FXML
    void btnCreatePDF(ActionEvent event) {
        String tipo = group.getSelectedToggle().getUserData().toString();
        tipo = "Fornecedor";
        String local = output.getText();
        cf = new ControllerInformacao(tipo, local);
        if (individual.isSelected()) {
            int cod = Integer.parseInt(codigo.getText());
            cf.createPDF(cod);
        } else {
            cf.createPDF();
        }        
    }

    @FXML
    void btnVoltar(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../main/FXMLMain.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        voltar.getScene().getWindow().hide();
    }
    
    void inicializarComboBox(){
        categorias = new ArrayList<>();
        CategoriasComboBox categoriaCliente = new CategoriasComboBox("Cliente", 1);
         CategoriasComboBox categoriaVendedor = new CategoriasComboBox("Vendedor", 2);
          CategoriasComboBox categoriaPadeiro = new CategoriasComboBox("Padeiro", 3);
           CategoriasComboBox categoriaProduto = new CategoriasComboBox("Produto", 4);
            CategoriasComboBox categoriaGerente = new CategoriasComboBox("Gerente", 5);
             CategoriasComboBox categoriaImposto = new CategoriasComboBox("Impostos", 6);
              CategoriasComboBox categoriaFornecedor = new CategoriasComboBox("Fornecedor", 7);
              categorias.add(categoriaCliente);
              categorias.add(categoriaVendedor);
              categorias.add(categoriaPadeiro);
              categorias.add(categoriaProduto);
              categorias.add(categoriaGerente);
              categorias.add(categoriaImposto);
              categorias.add(categoriaFornecedor);
              obsGestaoCategorias = FXCollections.observableArrayList(categorias);
              optionsSelector.setItems(obsGestaoCategorias);
              optionsSelector.getSelectionModel().selectFirst();
              
              
          
    }
}
