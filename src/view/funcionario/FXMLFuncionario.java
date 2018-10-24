/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionario;

import controller.ControllerGerente;
import controller.ControllerPadeiro;
import controller.ControllerVendedor;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.GestaoFuncionario;
import model.GestaoGerente;
import model.Padeiro;
import model.Vendedor;
import view.CategoriasComboBox;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFuncionario implements Initializable {
    ControllerPadeiro cpP;
    ControllerVendedor cv;
    ControllerGerente cg;
    private ArrayList<GestaoGerente> gerentes;
     private ArrayList<Padeiro> padeiros;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<GestaoFuncionario> funcionarios;
    private ObservableList<GestaoFuncionario> obsTableList;
    private ObservableList<CategoriasComboBox> obsComboBox;
    private ArrayList<CategoriasComboBox> categorias;
    
    @FXML
    private TableView<GestaoFuncionario> tableFuncionario;

    @FXML
    private TableColumn<GestaoFuncionario, String> tableColumnNome;

    @FXML
    private TableColumn<GestaoFuncionario, String> tableColumnCPF;

    @FXML
    private TableColumn<GestaoFuncionario, String> tableColumnProfissao;

    @FXML
    private TextField textFieldFuncionario;

    @FXML
    private ComboBox<CategoriasComboBox> comboBoxFuncionarioProfissao;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltar;

    @FXML
    void btnAdicionarAction(ActionEvent event) {

    }

    @FXML
    void btnBuscarAction(ActionEvent event) {

    }

    @FXML
    void btnRemoverAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cpP = new ControllerPadeiro();
       cg = new ControllerGerente();
       cv = new ControllerVendedor();
       try {
            padeiros = cpP.getAll();
          gerentes = cg.getAll();
      vendedores = cv.getAll();
        
       }catch (SQLException ex) {
            System.out.println("erro");
       }
         funcionarios = new ArrayList<>();
        funcionarios.addAll(gerentes);
       funcionarios.addAll(padeiros);
        funcionarios.addAll(vendedores);
        
   tableFuncionario.getSelectionModel().selectedItemProperty().addListener((obs,oldValue,newValue) -> { btnRemover.setDisable(false);});
    }
    public void inicializarComboBox(){
        CategoriasComboBox categoriaNome = new CategoriasComboBox("Nome", 1);
        CategoriasComboBox categoriaCPF = new CategoriasComboBox("CPF", 2);
        categorias.add(categoriaNome);
        categorias.add(categoriaCPF);
        obsComboBox = FXCollections.observableArrayList(categorias);
        comboBoxFuncionarioProfissao.setItems(obsComboBox);
        comboBoxFuncionarioProfissao.getSelectionModel().selectFirst();
        
    }   
    public void inicializarTabela(){
        
    }
    
}
