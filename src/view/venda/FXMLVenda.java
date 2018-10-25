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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.GestaoCliente;
import model.GestaoEstoque;
import model.Vendedor;
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
    ArrayList<Vendedor> vendedores;
    ObservableList<GestaoCliente> obsClienteComboBox;
    ObservableList<GestaoEstoque> obsCarrinho;
    ObservableList<GestaoEstoque> obsTableEstoque;
    ObservableList<Vendedor> obsVendedorComboBox;

    @FXML
    private ComboBox<GestaoCliente> comboBoxCliente;

    @FXML
    private ToggleGroup group;
    @FXML
    private Label lblMontanteVenda;
    @FXML
    private TextField textFieldData;

    @FXML
    private ComboBox<Vendedor> comboBoxVendedor;

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
        GestaoEstoque qtdProdutoEstoque = tableEstoque.getSelectionModel().getSelectedItem();
        try {
            GestaoEstoque qtdProdutoCarrinho = new GestaoEstoque(qtdProdutoEstoque.getIdEstoque(), Integer.parseInt(textFieldQuantidade.getText().trim()), qtdProdutoEstoque.getDataValidade(), qtdProdutoEstoque.getProduto());
            if (!textFieldQuantidade.getText().isEmpty()) {

                int qtdConvertida = Integer.parseInt(textFieldQuantidade.getText().trim());
                qtdProdutoCarrinho.setQtdProduto(qtdConvertida);
                Alert alert = null;
                if (qtdProdutoCarrinho.getQtdProduto() > 0) {
                    if (qtdProdutoCarrinho.getQtdProduto() <= tableEstoque.getSelectionModel().getSelectedItem().getQtdProduto()) {

                        carrinho.add(qtdProdutoCarrinho);
                        obsCarrinho = FXCollections.observableArrayList(carrinho);
                        tableCarrinho.setItems(obsCarrinho);
                        String valor = String.valueOf(calculaValorVenda());
                        lblMontanteVenda.setText(valor);

                    } else {
                        alert = new Alert(Alert.AlertType.NONE, "Quantidade Invalida", ButtonType.YES);
                        alert.show();
                    }
                } else {
                    alert = new Alert(Alert.AlertType.NONE, "Quantidade Invalida, igual ou menor a zero.", ButtonType.YES);
                    alert.show();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.NONE, "Erro ao adicionar no carrinho de compras ", ButtonType.YES);
                alert.show();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.NONE, "Insira uma quantidade válida!", ButtonType.FINISH);
            alert.show();
        }

    }//fim metodo

    //(qtdNoEstoque >= qtdProdutoClite)
    public float calculaValorVenda() {
        float valorTotalVenda = 0;
        //Calcula Montante
        for (int i = 0; i < carrinho.size(); i++) {
            valorTotalVenda += carrinho.get(i).getProduto().getPrecoCusto() * carrinho.get(i).getQtdProduto();
        }
        // Calcula se venda e prazo a vista
        boolean prazo = false;
        RadioButton vistaPrazo = (RadioButton) group.getSelectedToggle();
        if (vistaPrazo.getText().equals("A Vista")) {
            prazo = false;
        }
        if (vistaPrazo.getText().equals("A Prazo")) {
            prazo = true;
            valorTotalVenda = cvV.precoFinalVenda(prazo, valorTotalVenda);
        }
        return valorTotalVenda;

    }

    @FXML
    void btnComprarAction(ActionEvent event) throws SQLException {
        GestaoCliente cliente = comboBoxCliente.getSelectionModel().getSelectedItem();
        Vendedor vendedor = comboBoxVendedor.getSelectionModel().getSelectedItem();
        String data = textFieldData.getText();
        if (data.equals("")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
            LocalDateTime now = LocalDateTime.now();  
            data = dtf.format(now); 
        }
        if (carrinho.size() > 0) {
            try {
                cvV.salvar(data, vendedor, cliente, carrinho, 1, calculaValorVenda());
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
            } catch(SQLException e) {
                System.out.println(e);
            }
        }
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
            vendedores = cv.getAll();

            //clientes = cc.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicializarTabelaEstoque();
        tableEstoque.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            //System.out.println("Aqui1");
            for (int i = 0; i < carrinho.size(); i++) {
                if (tableEstoque.getSelectionModel().getSelectedItem().getIdEstoque() == carrinho.get(i).getIdEstoque()) {
                    btnAdicionarCarrinho.setDisable(true);
                    tableEstoque.getSelectionModel().selectLast();

                } else {
                    btnAdicionarCarrinho.setDisable(false);
                }
            }
        });
        tableEstoque.getSelectionModel().selectFirst();
        inicializarComboBoxCliente();
        inicializarComboBoxVendedor();

        //cvV.salvar(data, vendedor, cliente, estoques, formapagamento, valortotal);
        // TODO
    }

    void inicializarTabelaEstoque() {
        tableEstoqueNome.setCellValueFactory(new PropertyValueFactory<>("produtoNome"));
        tableEstoqueQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
        obsTableEstoque = FXCollections.observableArrayList(produtosEstoque);
        tableEstoque.setItems(obsTableEstoque);

    }

    void inicializarComboBoxCliente() {
        obsClienteComboBox = FXCollections.observableArrayList(clientes);
        comboBoxCliente.setItems(obsClienteComboBox);
        comboBoxCliente.getSelectionModel().selectFirst();

    }

    void inicializarComboBoxVendedor() {
        obsVendedorComboBox = FXCollections.observableArrayList(vendedores);
        comboBoxVendedor.setItems(obsVendedorComboBox);
        comboBoxVendedor.getSelectionModel().selectFirst();
    }

}
