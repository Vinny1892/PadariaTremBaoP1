/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.venda;

import controller.ControllerCliente;
import controller.ControllerEstoque;
import controller.ControllerVenda;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.GestaoCliente;
import model.GestaoEstoque;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLVenda implements Initializable {

    ControllerVenda cvV;
    ControllerEstoque ce;
    ControllerVendedor cv;
    ControllerCliente cc;
    ArrayList<GestaoEstoque> carrinho;
    ArrayList<GestaoEstoque> produtosEstoque;
    ArrayList<GestaoCliente> clientes;
    ObservableList<GestaoEstoque> obsCarrinho;
    ObservableList<GestaoEstoque> obsTableEstoque;

    @FXML
    private TableView<GestaoEstoque> tableEstoque;

    @FXML
    private TableColumn<GestaoEstoque, String> tableEstoqueNome;

    @FXML
    private TableColumn<GestaoEstoque, String> tableEstoqueQuantidade;

    @FXML
    private TableView<GestaoEstoque> tableCarrinho;

    @FXML
    private TableColumn<GestaoEstoque, String> tableCarrinhoNome;

    @FXML
    private TableColumn<GestaoEstoque, String> tablePrecoCarrinho;

    @FXML
    private TableColumn<GestaoEstoque, String> tableQuantidadeCarrinho;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnAdicionarCarrinho;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    void btnAdicionarCarrinhoAction(ActionEvent event) {
        tablePrecoCarrinho.setCellValueFactory(new PropertyValueFactory<>("precoCusto"));
        tableCarrinhoNome.setCellValueFactory(new PropertyValueFactory<>("produtoNome"));
        tableQuantidadeCarrinho.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
        GestaoEstoque estoqueCarrinho = tableEstoque.getSelectionModel().getSelectedItem();
        try {
            estoqueCarrinho.setQtdProduto(Integer.parseInt(textFieldQuantidade.getText()));
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Somente Numeros ", ButtonType.FINISH);
            alert.show();
        }
        carrinho.add(estoqueCarrinho);
        obsCarrinho = FXCollections.observableArrayList(carrinho);
        tableCarrinho.setItems(obsCarrinho);
    }

    @FXML
    void btnComprarAction(ActionEvent event) {

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
        ce = new ControllerEstoque();
        cvV = new ControllerVenda();
        cc = new ControllerCliente();
        cv = new ControllerVendedor();
        carrinho = new ArrayList<>();
        try {
            produtosEstoque = ce.getAll();
            clientes = cc.getAll();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicializarTabelaEstoque();
        tableEstoque.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
        });

        //cvV.salvar(data, vendedor, cliente, estoques, formapagamento, valortotal);
        // TODO
    }

    void inicializarTabelaEstoque() {
        System.out.println(produtosEstoque.size());
        tableEstoqueNome.setCellValueFactory(new PropertyValueFactory<>("produtoNome"));
        tableEstoqueQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
        obsTableEstoque = FXCollections.observableArrayList(produtosEstoque);
        tableEstoque.setItems(obsTableEstoque);

    }

}
