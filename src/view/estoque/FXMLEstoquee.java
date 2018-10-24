/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.estoque;

import controller.ControllerEstoque;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.GestaoEstoque;
import model.GestaoFornecedor;
import model.GestaoProduto;
import view.CategoriasComboBox;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLEstoquee implements Initializable {

    ControllerEstoque ce;
    ControllerProduto cp;
    ArrayList<GestaoEstoque> produtosEstoque;
    ;
    ArrayList<GestaoProduto> produtos;
    ArrayList<CategoriasComboBox> categorias;

    private ObservableList<CategoriasComboBox> obscategoriasProdutoEstoqueBusca;
    private ObservableList<GestaoEstoque> obsTableEstoque;
    private ObservableList<GestaoProduto> obscategoriasProdutoEstoqueAdicionar;

    @FXML
    private TextField textFieldProduto;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltar;

    @FXML
    private ComboBox<CategoriasComboBox> comboBoxProduto;

    @FXML
    private AnchorPane formEstoque;

    @FXML
    private ComboBox<GestaoProduto> comboBoxProdutoForm;

    @FXML
    private TextField textFieldFormDataValidade;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    private Button btnSalvar;

    @FXML
    private TableView<GestaoEstoque> tableEstoque;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnNome;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnCodigo;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnDataValidade;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnQuantidade;

    @FXML
    void btnAdicionarAction(ActionEvent event) {
        formEstoque.setVisible(true);
        if (produtos.isEmpty()) {
            comboBoxProduto.setEditable(false);
        } else {
            obscategoriasProdutoEstoqueAdicionar = FXCollections.observableArrayList(produtos);
            comboBoxProdutoForm.setItems(obscategoriasProdutoEstoqueAdicionar);
            comboBoxProdutoForm.getSelectionModel().selectFirst();
        }

    }

    @FXML
    void btnBuscarAction(ActionEvent event) {
        if (comboBoxProduto.getSelectionModel().getSelectedItem().getNome().equals("Nome")) {
            for (int i = 0; i < produtosEstoque.size(); i++) {
                if (textFieldProduto.getText().equals(produtosEstoque.get(i).getProduto().getNome())) {
                    tableEstoque.getSelectionModel().select(produtosEstoque.get(i));
                    btnRemover.setDisable(false);
                }

            }
        }
        if (comboBoxProduto.getSelectionModel().getSelectedItem().getNome().equals("Codigo")) {
            for (int i = 0; i < produtosEstoque.size(); i++) {
                if (textFieldProduto.getText().equals(produtosEstoque.get(i).getProduto().getIdproduto())) {
                    tableEstoque.getSelectionModel().select(produtosEstoque.get(i));
                    btnRemover.setDisable(false);
                }
            }
        }
        btnRemover.setDisable(false);

    }

    @FXML
    void btnRemoverAction(ActionEvent event) throws SQLException {
        GestaoEstoque estoqueRemover = tableEstoque.getSelectionModel().getSelectedItem();
        ce.deletar(String.valueOf(estoqueRemover.getIdEstoque()));
        tableEstoque.getItems().remove(estoqueRemover);
        tableEstoque.getSelectionModel().clearSelection();
    }

    @FXML
    void btnSalvarAction(ActionEvent event) {
        inicializarComboBoxProduto();
        if (!textFieldFormDataValidade.getText().isEmpty() && !textFieldQuantidade.getText().isEmpty()) {
            try {
                GestaoProduto produtoSalvar = comboBoxProdutoForm.valueProperty().get();
                ce.salvar(Integer.parseInt(textFieldQuantidade.getText()), textFieldFormDataValidade.getText(), produtoSalvar);
                produtosEstoque = ce.getAll();
                inicializarTabela();
                formEstoque.setVisible(false);

            } catch (Exception e) {
                System.out.println("Erro ao Salvar");
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
        cp = new ControllerProduto();
        try {
            produtos = cp.getAll();
            produtosEstoque = ce.getAll();

        } catch (SQLException ex) {
            System.out.println("Erro ao trazer produtos  ou  produtos do estoque");

        }
        inicializarComboBox();
        inicializarTabela();
        tableEstoque.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            btnRemover.setDisable(false);
        });
    }

    public void inicializarTabela() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("produtoNome"));
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("produtoCodigo"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
        tableColumnDataValidade.setCellValueFactory(new PropertyValueFactory<>("dataValidade"));
        obsTableEstoque = FXCollections.observableArrayList(produtosEstoque);
        tableEstoque.setItems(obsTableEstoque);

    }

    public void inicializarComboBox() {
        categorias = new ArrayList<>();
        CategoriasComboBox categoriaNome = new CategoriasComboBox("Nome", 1);
        CategoriasComboBox categoriasCodigo = new CategoriasComboBox("Codigo", 2);
        categorias.add(categoriaNome);
        categorias.add(categoriasCodigo);
        obscategoriasProdutoEstoqueBusca = FXCollections.observableArrayList(categorias);
        comboBoxProduto.setItems(obscategoriasProdutoEstoqueBusca);
        comboBoxProduto.getSelectionModel().select(categoriaNome);

    }

    public void inicializarComboBoxProduto() {
        obscategoriasProdutoEstoqueAdicionar = FXCollections.observableArrayList(produtos);
        comboBoxProdutoForm.setItems(obscategoriasProdutoEstoqueAdicionar);
    }

}
