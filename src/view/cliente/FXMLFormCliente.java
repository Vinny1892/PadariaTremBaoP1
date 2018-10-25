/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cliente;

import controller.ControllerCartao;
import controller.ControllerCliente;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.CartaoFidelidade;
import model.GestaoCliente;
import view.main.Main;

public class FXMLFormCliente implements Initializable {

    ArrayList<GestaoCliente> clientes;
    ControllerCliente cc;
    ControllerCartao ccC;

    ToggleGroup group;

    @FXML
    private RadioButton gold;

    @FXML
    private RadioButton platinum;

    @FXML
    private RadioButton novo;

    @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField textFieldTelefone;

    @FXML
    public void btnVoltarAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLCliente.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnVoltar.getScene().getWindow().hide();
    }

    @FXML
    public void salvarNovoCliente(ActionEvent event) throws SQLException {
        RadioButton cartao = (RadioButton) group.getSelectedToggle();
        CartaoFidelidade cartaoFidelidade = null;
        if (cartao.getText().equals("Platinum")) {
            cartaoFidelidade = new CartaoFidelidade(false, true);

        } else if (cartao.getText().equals("Gold")) {
            cartaoFidelidade = new CartaoFidelidade(true, false);
        } else {
            cartaoFidelidade = new CartaoFidelidade(false, false);
        }
        if (!textFieldCPF.getText().equals("") && !textFieldNome.getText().equals("")) {
            try {
                cc.salvar(textFieldNome.getText(), textFieldEndereco.getText(), textFieldCPF.getText(), textFieldTelefone.getText(), cartaoFidelidade);
                voltaTelaAnterior();
            } catch(SQLException e) {
                System.out.println(e);
            }
        }
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cc = new ControllerCliente();
        group = new ToggleGroup();
        novo.setToggleGroup(group);
        gold.setToggleGroup(group);
        platinum.setToggleGroup(group);
    }

    private void voltaTelaAnterior() {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLCliente.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        btnVoltar.getScene().getWindow().hide();
    }
}
