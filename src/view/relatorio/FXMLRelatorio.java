/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.relatorio;

//import controller.ControllerInformacao;
import controller.ControllerInformacao;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.CategoriasComboBox;
import view.main.Main;

/**
 * FXML Controller class
 *
 * @author mateus
 */
public class FXMLRelatorio implements Initializable {

    private ToggleGroup group;
    private ControllerInformacao cf;

    @FXML
    private ComboBox<CategoriasComboBox> optionsSelector;

    @FXML
    private Button search;

    @FXML
    private Button voltar;

    @FXML
    private Text infoCodigo;

    @FXML
    private TextField codigo;

    @FXML
    private TextField output;

    @FXML
    private RadioButton individual;

    @FXML
    private RadioButton coletivo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group = new ToggleGroup();
        individual.setToggleGroup(group);
        coletivo.setToggleGroup(group);
        codigo.setVisible(false);
        infoCodigo.setVisible(false);
        group.selectedToggleProperty().addListener((observable) -> {
            if (coletivo.isSelected()) {
                codigo.setVisible(false);
                infoCodigo.setVisible(false);
            } else {
                codigo.setVisible(true);
                infoCodigo.setVisible(true);
            }
        });
    }

    @FXML
    void btnCreatePDF(ActionEvent event) {
        String tipo = group.getSelectedToggle().getUserData().toString();
        tipo = "Fornecedor";
        String local = output.getText();
        cf = new ControllerInformacao(tipo, local);
        if (individual.isSelected()) {
            int cod = Integer.parseInt(codigo.getText());
            cf.createPDF(cod);
        } else {
            cf.createPDF();
        }        
    }

    @FXML
    void btnVoltar(ActionEvent event) {
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
        voltar.getScene().getWindow().hide();
    }
}
