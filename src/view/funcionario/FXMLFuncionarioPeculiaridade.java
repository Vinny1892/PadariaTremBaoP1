/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionario;

import controller.ControllerEstoque;
import controller.ControllerGerente;
import controller.ControllerPadeiro;
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
import model.GestaoEstoque;
import model.GestaoGerente;
import model.Padeiro;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFuncionarioPeculiaridade implements Initializable {
    private ControllerGerente cg;
    private ControllerPadeiro cpP;
    private ControllerEstoque ce;
    private ArrayList<GestaoEstoque> produtosEstoque;
    private ArrayList<GestaoGerente> gerentes;
    private ArrayList<Padeiro> padeiros;
    private ObservableList<GestaoGerente> obsComboBoxGerente;
    private ObservableList<Padeiro> obsComboBoxPadeiro;
    private ObservableList<GestaoEstoque> obsTableEstoque;
     @FXML
    private TableView<GestaoEstoque> tableEstoque;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnNome;

    @FXML
    private TableColumn<GestaoEstoque, String> tableColumnQuantidade;

    @FXML
    private AnchorPane formGerenteConf;
    
    @FXML
    private AnchorPane formPadeiro;

    @FXML
    private TextField textFieldGratificacao;

    @FXML
    private ComboBox<GestaoGerente> comboBoxGerente;

    @FXML
    private Button btnSalvarGerente;

    @FXML
    private Button btnVoltarFormGerente;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnGerenteConf;

    @FXML
    private TextField textFieldHorasTrabalhadasPadeiro;

    @FXML
    private ComboBox<Padeiro> comboBoxPadeiro;

    @FXML
    private Button btnVoltarPadeiro;

    @FXML
    private Button btnSalvarPadeiro;

    @FXML
    private Button btnPadeiroConf;

    @FXML
    void btnGerenteConfAction(ActionEvent event) throws SQLException {
         
        if(!formGerenteConf.isVisible()){
            formGerenteConf.setVisible(true);
        }else{
            formGerenteConf.setVisible(false);
        }
       
        
    }

    @FXML
    void btnPadeiroConfAction(ActionEvent event) throws SQLException {
        if(!formPadeiro.isVisible()){
            formPadeiro.setVisible(true);
        }else{
            formPadeiro.setVisible(false);
        }
    }

    @FXML
    void btnSalvarGerenteAction(ActionEvent event) {
        //
        Padeiro padeiro  = comboBoxPadeiro.getSelectionModel().getSelectedItem();
        padeiro.sethorarioAlternativo(Float.parseFloat(textFieldHorasTrabalhadasPadeiro.getText()));
        cpP.gratificacao(padeiro);
        formGerenteConf.setVisible(false);
    }

    @FXML
    void btnSalvarPadeiroAction(ActionEvent event) {
        //TODO
        GestaoGerente gerente = comboBoxGerente.getSelectionModel().getSelectedItem();
        gerente.setPorcentagemGratificacao(Integer.parseInt(textFieldGratificacao.getText()));
        cg.gratificacao(gerente);
        formPadeiro.setVisible(false);
    }

    @FXML
    void btnVoltarAction(ActionEvent event) {
           Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLFuncionario.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnVoltar.getScene().getWindow().hide();
    }

    @FXML
    void btnVoltarFormGerente(ActionEvent event) {
        if(!formGerenteConf.isVisible()){
            formGerenteConf.setVisible(true);
        }else{
            formGerenteConf.setVisible(false);
        }
    }
   
    @FXML
        void btnVoltarPadeiroAction(ActionEvent event){
             if(!formPadeiro.isVisible()){
                    formPadeiro.setVisible(true);
                }else{
                    formPadeiro.setVisible(false);
        }
        }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        ce = new ControllerEstoque();
        try {
            produtosEstoque = ce.getAll();
        } catch (SQLException ex) {
            System.out.println("erro");
        }
        try{
        inicializarTabela();
        inicializarComboBoxPadeiro();
        inicializarComboBoxGerente();
        }catch(SQLException e){
            System.out.println("Erro ao carregar dados dos funcionarios");
        }
        if(padeiros.isEmpty()){
            comboBoxPadeiro.setDisable(true);
        }
        if(gerentes.isEmpty()){
            comboBoxGerente.setDisable(true);        
    }
    }
    
    public void inicializarTabela(){
        for(int i = 0 ; i < produtosEstoque.size();i++){
            if(produtosEstoque.get(i).getQtdProduto() > 1){
                produtosEstoque.remove(produtosEstoque.get(i));
            }
        }
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("produtoNome"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtdProduto"));
        obsTableEstoque = FXCollections.observableArrayList(produtosEstoque);
        tableEstoque.setItems(obsTableEstoque);
        
    }
    
    public void inicializarComboBoxGerente() throws SQLException{
        cg = new ControllerGerente();
        gerentes = cg.getAll();
        obsComboBoxGerente = FXCollections.observableArrayList(gerentes);
        comboBoxGerente.setItems(obsComboBoxGerente);
        comboBoxGerente.getSelectionModel().selectFirst();
    }
    public void inicializarComboBoxPadeiro()throws SQLException{
        cpP =  new ControllerPadeiro();
        padeiros = cpP.getAll();
        obsComboBoxPadeiro = FXCollections.observableArrayList(padeiros);
        comboBoxPadeiro.setItems(obsComboBoxPadeiro);
        comboBoxPadeiro.getSelectionModel().selectFirst();
    }
    
}
