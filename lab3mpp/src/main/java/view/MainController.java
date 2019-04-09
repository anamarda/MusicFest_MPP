package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;


public class MainController {
    Service service;

    @FXML private TextField nameText;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;

    public MainController(){}

    @FXML
    private void initialize(){
        System.out.println("Initializat din MainController");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                login();
            }
        });
    }

    public void setMainController(Service service) {
        this.service = service;
    }

    @FXML
    private void login(){
        Boolean exist = service.checkLogin(nameText.getText(), passwordField.getText());
        if(!exist){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Wrong name or pass!");
            alert.show();
        }
        else {
            nameText.clear();
            passwordField.clear();
            afterLogin();
        }
    }

    private void afterLogin(){
        try {
            Stage stage = new Stage();

            Parent root;
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("AfterLogin.fxml"));
            root = loader.load();

            AfterLoginController afterLoginController = loader.getController();
            afterLoginController.setAfterLoginController(service);
            stage.setTitle("Helloooooo!");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Nu aveti acces la informatii.");
            alert.show();
        }
    }

}
