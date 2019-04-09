package main;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repo.*;
import service.Service;
import view.MainController;

import java.io.IOException;

public class Main extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage){
        ArtistDbRepo artistDbRepo = new ArtistDbRepo();
        EmployeesDbRepo employeesDbRepo = new EmployeesDbRepo();
        ShowDbRepo showDbRepo = new ShowDbRepo();
        ShowArtistDbRepo showArtistDbRepo = new ShowArtistDbRepo();
        TicketDbRepo ticketDbRepo = new TicketDbRepo();

        Service service = new Service(artistDbRepo, employeesDbRepo, showDbRepo, showArtistDbRepo, ticketDbRepo);

        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("mainScene.fxml"));
            root = loader.load();

            MainController controller = loader.getController();
            controller.setMainController(service);

            primaryStage.setTitle("Application");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
