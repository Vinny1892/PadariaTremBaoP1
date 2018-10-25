/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.estoquee;

import controller.ControllerEstoque;
import controller.ControllerProduto;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.GestaoEstoque;
import model.GestaoProduto;
import view.CategoriasComboBox;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLEstoque implements Initializable {

    ControllerEstoque ceE;
    ControllerProduto cp;
    ArrayList<GestaoProduto> produtos;
    ArrayList<GestaoEstoque> produtosEstoque;
    private ArrayList<CategoriasComboBox> categorias;
    private ObservableList<CategoriasComboBox> obsCategoriasComboBox;
    private ObservableList<GestaoEstoque> obsTableEstoque;
    private ObservableList<GestaoProduto> obsCategoriasProdutoFormEstoque;

    @FXML
    private AnchorPane formEstoque;

    @FXML
    private TableView<GestaoEstoque> tableProdutoEstoque;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnNome;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnCodigo;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnDataValidade;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnQuantidade;

    @FXML
    private TextField textFieldProdutoEstoque;

    @FXML
    private ComboBox<CategoriasComboBox> comboBoxEstoque;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnBuscar;

    @FXML
    void btnAdicionarAction(ActionEvent event) {
        formEstoque.setVisible(true);
        //to do Validacoes

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
        try {
            produtosEstoque = ceE.getAll();
        } catch (SQLException ex) {
            System.out.println("Erro ao puxar estoque do banco , culpa do kaio");
        }
        inicializarTabela();
        inicializarComboBox();

    }

    public void inicializarTabela() {
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("idEstoque"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
        tableColumnDataValidade.setCellValueFactory(new PropertyValueFactory<>("dataValidade"));

        obsTableEstoque = FXCollections.observableArrayList(produtosEstoque);
        tableProdutoEstoque.setItems(obsTableEstoque);
    }

    public void inicializarComboBox() {
        categorias = new ArrayList<CategoriasComboBox>();
        CategoriasComboBox categoriaNome = new CategoriasComboBox("Nome", 1);
        CategoriasComboBox categoriaCodigo = new CategoriasComboBox("Codigo", 2);
        categorias.add(categoriaNome);
        categorias.add(categoriaCodigo);
        obsCategoriasComboBox = FXCollections.observableArrayList(categorias);
        comboBoxEstoque.setItems(obsCategoriasComboBox);
        comboBoxEstoque.getSelectionModel().select(categoriaNome);

    }
}
