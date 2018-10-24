/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fornecedor;

import controller.ControllerFornecedor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFormFornecedor implements Initializable {

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private TextField textFieldCNPJ;

    @FXML
    private TextField textFieldTaxa;

    @FXML
    private CheckBox checkBoxRecorrente;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    public boolean ValidaCNPJ() {
        Pattern p = Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");
        Matcher m = p.matcher(textFieldCNPJ.getText());
        return m.matches();
    }

    @FXML
    void btnSalvarAction(ActionEvent event) throws SQLException {
        if (!textFieldNome.getText().equals("") && !textFieldEndereco.getText().equals("") && ValidaCNPJ()) {

            new ControllerFornecedor().salvar(textFieldCNPJ.getText(), checkBoxRecorrente.isSelected(), textFieldNome.getText(),
                    textFieldEndereco.getText(), textFieldTaxa.getText());
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("FXMLFornecedor.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            btnSalvar.getScene().getWindow().hide();

        } else {
            Alert alert = new Alert(AlertType.NONE, "Campos com Valor invalido", ButtonType.FINISH);
            alert.show();
        }

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLFornecedor.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnSalvar.getScene().getWindow().hide();
    }

    @FXML
    void checkBoxRecorrenteAction(ActionEvent event) {
        if (checkBoxRecorrente.isSelected()) {
            textFieldTaxa.setEditable(true);
        }
        if (!checkBoxRecorrente.isSelected()) {
            textFieldTaxa.setText("");
            textFieldTaxa.setEditable(false);
        }
    }

}
