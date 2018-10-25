/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionario;

import controller.ControllerGerente;
import controller.ControllerPadeiro;
import controller.ControllerVendedor;
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
import model.GestaoFuncionario;
import model.GestaoGerente;
import model.Padeiro;
import model.Vendedor;
import view.CategoriasComboBox;
import view.main.Main;

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
    private Button btnSeila;

    @FXML
    void btnSeilaAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLFuncionarioPeculiaridade.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnSeila.getScene().getWindow().hide();
    }

    @FXML
    void btnAdicionarAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLFormFuncionario.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnAdicionar.getScene().getWindow().hide();
    }

    @FXML
    void btnBuscarAction(ActionEvent event) {
        if (comboBoxFuncionarioProfissao.getSelectionModel().getSelectedItem().getNome().equals("Nome")) {
            for (int i = 0; i < funcionarios.size(); i++) {
                if (textFieldFuncionario.getText().trim().equals(funcionarios.get(i).getNome())) {
                    tableFuncionario.getSelectionModel().select(funcionarios.get(i));
                }
            }
        }
        if (comboBoxFuncionarioProfissao.getSelectionModel().getSelectedItem().getNome().equals("CPF")) {
            for (int i = 0; i < funcionarios.size(); i++) {
                if (textFieldFuncionario.getText().trim().equals(funcionarios.get(i).getCpf())) {
                    tableFuncionario.getSelectionModel().select(funcionarios.get(i));
                }
            }
        }

    }

    @FXML
    void btnRemoverAction(ActionEvent event) throws SQLException {
        GestaoFuncionario funcionarioDeletar = tableFuncionario.getSelectionModel().getSelectedItem();
        cg.deletar(funcionarioDeletar.getCpf());
        tableFuncionario.getItems().remove(funcionarioDeletar);
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
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnVoltar.getScene().getWindow().hide();
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

        } catch (SQLException ex) {
            System.out.println("erro");
        }
        funcionarios = new ArrayList<>();
        funcionarios.addAll(gerentes);
        funcionarios.addAll(padeiros);
        funcionarios.addAll(vendedores);
        inicializarComboBox();
        inicializarTabela();

        tableFuncionario.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            btnRemover.setDisable(false);
        });
    }

    public void inicializarComboBox() {
        categorias = new ArrayList<>();
        CategoriasComboBox categoriaNome = new CategoriasComboBox("Nome", 1);
        CategoriasComboBox categoriaCPF = new CategoriasComboBox("CPF", 2);
        categorias.add(categoriaNome);
        categorias.add(categoriaCPF);
        obsComboBox = FXCollections.observableArrayList(categorias);
        comboBoxFuncionarioProfissao.setItems(obsComboBox);
        comboBoxFuncionarioProfissao.getSelectionModel().selectFirst();

    }

    public void inicializarTabela() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnProfissao.setCellValueFactory(new PropertyValueFactory<>("profissao"));
        obsTableList = FXCollections.observableArrayList(funcionarios);
        tableFuncionario.setItems(obsTableList);

    }

}
