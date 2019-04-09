//package client;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import service.Service;
//import view.AfterLoginController;
//import view.MainController;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Properties;
//
//public class ObjectClient {
//    private int defaultPort = 55565;
//    private String defaultServer = "localhost";
//    private Socket socket;
//
//    @FXML private TextField nameText;
//    @FXML private PasswordField passwordField;
//    @FXML private Button loginButton;
//
//    @FXML
//    private void initialize(){
//        System.out.println("Initializat din MainController");
//
//        loginButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                login();
//            }
//        });
//    }
//
//    public void setMainController() {
//        Properties clientProps = new Properties();
//
//        try {
//            clientProps.load(ObjectClient.class.getResourceAsStream("client.properties"));
//            System.out.println("Client properties set. ");
//            clientProps.list(System.out);
//        } catch (IOException var8) {
//            System.err.println("Cannot find client.properties " + var8);
//            return;
//        }
//
//        String serverIP = clientProps.getProperty("chat.server.host", defaultServer);
//        int serverPort = defaultPort;
//
//        try {
//            serverPort = Integer.parseInt(clientProps.getProperty("chat.server.port"));
//        } catch (NumberFormatException var7) {
//            System.err.println("Wrong port number " + var7.getMessage());
//            System.out.println("Using default port: " + defaultPort);
//        }
//
//        try {
//            socket = new Socket(defaultServer, defaultPort);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @FXML
//    private void login(){
//        //TODO
//        String str = nameText.getText() + "," + passwordField.getText();
//        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//            try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
//                bufferedWriter.write(str);
//                bufferedWriter.flush();
//                str = bufferedReader.readLine();
//                if(str.equals("Rejected.")){
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setContentText("Wrong name or pass!");
//                    alert.show();
//                }
//                else {
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setContentText("yaaaaaaaaay");
//                    alert.show();
////                    nameText.clear();
////                    passwordField.clear();
////            afterLogin();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
////
////    private void afterLogin(){
////        try {
////            Stage stage = new Stage();
////
////            Parent root;
////            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("AfterLogin.fxml"));
////            root = loader.load();
////
////            AfterLoginController afterLoginController = loader.getController();
////            afterLoginController.setAfterLoginController(service);
////            stage.setTitle("Helloooooo!");
////            stage.setScene(new Scene(root));
////            stage.show();
////        } catch (IOException e) {
////            Alert alert = new Alert(Alert.AlertType.WARNING);
////            alert.setContentText("Nu aveti acces la informatii.");
////            alert.show();
////        }
////    }
//
//
//}
