/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cliente;

import controller.ControllerCartao;
import controller.ControllerCliente;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.CartaoFidelidade;
import model.GestaoCliente;


public class FXMLFormCliente implements Initializable {
    ArrayList<GestaoCliente> clientes;
    ControllerCliente cc ;
    ControllerCartao ccC;
    @FXML
     private ToggleGroup group;


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
        

    }
    
    @FXML
    public void salvarNovoCliente(ActionEvent event) throws SQLException{
        RadioButton cartao = (RadioButton) group.getSelectedToggle();
        CartaoFidelidade cartaoFidelidade = null;
        if(cartao.getText().equals("Platinum")){
            cartaoFidelidade = new CartaoFidelidade(false, true);
            
        }else if(cartao.getText().equals("Gold")){
            cartaoFidelidade = new CartaoFidelidade(true, false);
        }else {
            cartaoFidelidade = new CartaoFidelidade(false, false);
        }
        if(!textFieldCPF.getText().equals("") && !textFieldNome.getText().equals("")){
           
         cc.salvar(textFieldNome.getText(), textFieldEndereco.getText(), textFieldCPF.getText(), textFieldTelefone.getText(), cartaoFidelidade);
       
        }
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cc = new ControllerCliente();
        
        
    }
    
    

}
