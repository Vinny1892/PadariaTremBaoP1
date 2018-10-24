/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFuncionarioPeculiaridade implements Initializable {
     @FXML
    private TableView<?> tableEstoque;

    @FXML
    private TableColumn<?, ?> tableColumnNome;

    @FXML
    private TableColumn<?, ?> tableColumnQuantidade;

    @FXML
    private AnchorPane formGerenteConf;

    @FXML
    private TextField textFieldGratificacao;

    @FXML
    private ComboBox<?> comboBoxGerente;

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
    private ComboBox<?> comboBoxPadeiro;

    @FXML
    private Button btnVoltarPadeiro;

    @FXML
    private Button btnSalvarPadeiro;

    @FXML
    private Button btnPadeiro;

    @FXML
    void btnGerenteConfAction(ActionEvent event) {

    }

    @FXML
    void btnPadeiroAction(ActionEvent event) {

    }

    @FXML
    void btnSalvarGerenteAction(ActionEvent event) {

    }

    @FXML
    void btnSalvarPadeiroAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarFormGerente(ActionEvent event) {

    }

    @FXML
    void btnVoltarPadeiroAction(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
