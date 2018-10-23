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

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFuncionario implements Initializable {
    @FXML
    private TableView<?> tableFuncionario;

    @FXML
    private TableColumn<?, ?> tableColumnNome;

    @FXML
    private TableColumn<?, ?> tableColumnCPF;

    @FXML
    private TableColumn<?, ?> tableColumnProfissao;

    @FXML
    private TextField textFieldFuncionario;

    @FXML
    private ComboBox<?> comboBoxFuncionarioProfissao;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnRemoverAction;

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
        // TODO
    }    
    
}
