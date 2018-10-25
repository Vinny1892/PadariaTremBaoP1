/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cliente;

import controller.ControllerCliente;
import view.produto.*;
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
import model.GestaoCliente;
import model.GestaoProduto;
import model.PessoaFisica;
import view.CategoriasComboBox;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLCliente implements Initializable {

    private ControllerCliente cc;
    private ArrayList<GestaoCliente> clientes;
    private ArrayList<CategoriasComboBox> categorias;
    private ObservableList<CategoriasComboBox> obsCategorias;
    private ObservableList<GestaoCliente> obsGestaoCliente;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableView<GestaoCliente> tableCliente;

    @FXML
    private TableColumn<GestaoCliente, String> tableColumnNome;

    @FXML
    private TableColumn<GestaoCliente, String> tableColumnCPF;

    @FXML
    private TextField textFieldCliente;

    @FXML
    private ComboBox<CategoriasComboBox> comboBoxCliente;

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
            root = FXMLLoader.load(getClass().getResource("FXMLFormCliente.fxml"));
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
        if (comboBoxCliente.getSelectionModel().getSelectedItem().getNome().equals("Nome")) {
            for (int i = 0; i < clientes.size(); i++) {
                if (textFieldCliente.getText().equals(clientes.get(i).getNome())) {
                    // tableCliente.getSelectionModel().select(clientes.get(i));
                    btnRemover.setDisable(false);
                }
            }
        }
        if (comboBoxCliente.getSelectionModel().getSelectedItem().getNome().equals("Codigo")) {
            for (int i = 0; i < clientes.size(); i++) {

                if (textFieldCliente.getText().equals(String.valueOf(clientes.get(i).getCpf()))) {
                    // tableCliente.getSelectionModel().select(clientes.get(i));
                    btnRemover.setDisable(false);
                }
            }
        }
    }

    @FXML
    void btnRemoverAction(ActionEvent event) throws SQLException {
        GestaoCliente cliente = tableCliente.getSelectionModel().getSelectedItem();
        cc.deletar(String.valueOf(cliente.getCpf()));
        tableCliente.getItems().remove(cliente);
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
        cc = new ControllerCliente();
        try {
            clientes = cc.getAll();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Clientes do Banco");
            System.out.println(ex);
        }
        inicializarComboBox();
        inicializarTabela();

    }

    public void inicializarComboBox() {
        categorias = new ArrayList<CategoriasComboBox>();
        CategoriasComboBox comboBoxNomeProduto = new CategoriasComboBox("Nome", 1);
        CategoriasComboBox comboBoxCodigoProduto = new CategoriasComboBox("CPF", 2);
        categorias.add(comboBoxNomeProduto);
        categorias.add(comboBoxCodigoProduto);
        obsCategorias = FXCollections.observableArrayList(categorias);
        comboBoxCliente.setItems(obsCategorias);
        comboBoxCliente.getSelectionModel().select(comboBoxNomeProduto);

    }

    public void inicializarTabela() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        obsGestaoCliente = FXCollections.observableArrayList(clientes);
        tableCliente.setItems(obsGestaoCliente);
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            btnRemover.setDisable(false);
        });

    }

}
