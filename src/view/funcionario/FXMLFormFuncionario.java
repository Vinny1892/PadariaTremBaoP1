/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionario;

import controller.ControllerGerente;
import controller.ControllerPadeiro;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import view.CategoriasComboBox;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author VinnyWindows
 */
public class FXMLFormFuncionario implements Initializable {
    ControllerVendedor cv;
    ControllerGerente cg;
    ControllerPadeiro cpP;
    private ArrayList<CategoriasComboBox> categorias;
    private ObservableList<CategoriasComboBox> obsComboBoxFuncionario;

    
  @FXML
    private TextField textFieldCPF;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldTelefone;

    @FXML
    private TextField textFieldEndereco;

    @FXML
    private TextField textFieldSalario;

    @FXML
    private ComboBox<CategoriasComboBox> comboBoxProfissao;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;
    
    

    @FXML
    void btnSalvarAction(ActionEvent event) throws SQLException {
        if(comboBoxProfissao.getSelectionModel().getSelectedItem().getNome().equals("Gerente")){
          cg = new ControllerGerente();
          cg.salvar(textFieldNome.getText(), textFieldCPF.getText(), textFieldEndereco.getText(), textFieldTelefone.getText(),
                  Float.parseFloat(textFieldSalario.getText()),
                  0);
        }else if (comboBoxProfissao.getSelectionModel().getSelectedItem().getNome().equals("Vendedor")){
            cv = new ControllerVendedor();
            cv.salvar(0, Float.parseFloat(textFieldSalario.getText()), textFieldCPF.getText(), textFieldTelefone.getText(), textFieldNome.getText(),textFieldEndereco.getText());
            
        }else if(comboBoxProfissao.getSelectionModel().getSelectedItem().getNome().equals("Padeiro")){
            cpP = new ControllerPadeiro();
            cpP.salvar(textFieldNome.getText(), textFieldEndereco.getText(), textFieldCPF.getText(), textFieldTelefone.getText(),Float.parseFloat(textFieldSalario.getText()),0);
        }
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarCombobox();
        // TODO
    } 
    
    public void inicializarCombobox(){
        categorias = new ArrayList<CategoriasComboBox>();
        CategoriasComboBox padeiro = new CategoriasComboBox("Padeiro", 1);
        CategoriasComboBox gerente = new CategoriasComboBox("Gerente", 2);
        CategoriasComboBox vendedor = new CategoriasComboBox("Vendedor", 3);
        categorias.add(gerente);
        categorias.add(padeiro);
        categorias.add(vendedor);
        obsComboBoxFuncionario = FXCollections.observableArrayList(categorias);
        comboBoxProfissao.setItems(obsComboBoxFuncionario);
        comboBoxProfissao.getSelectionModel().selectLast();
    }
    
}
