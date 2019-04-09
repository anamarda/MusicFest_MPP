package view;

import domain.Artist;
import domain.DTO_ArtistShow;
import domain.DTO_SearchArtistShow;
import domain.Show;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import service.Service;
import utils.ChangeEventType;
import utils.DTO_artistShowEvent;
import utils.Observer;

import javax.xml.soap.Text;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class AfterLoginController {
    Service service;
    private ObservableList<DTO_ArtistShow> observableList;

    @FXML
    private TableView artistsTableView;
    @FXML
    private TableView searchArtistsTableView;
    @FXML
    private DatePicker searchDP;
    @FXML
    private TextField purchaserText;
    @FXML
    private TextField ticketsText;

    @FXML
    TableColumn<DTO_ArtistShow, String> artistColumnMain;
    @FXML
    TableColumn<DTO_ArtistShow, LocalDate> dateColumnMain;
    @FXML
    TableColumn<DTO_ArtistShow, String> locationColumnMain;
    @FXML
    TableColumn<DTO_ArtistShow, Integer> availableColumnMain;
    @FXML
    TableColumn<DTO_ArtistShow, Integer> soldColumnMain;

    @FXML
    private TableColumn<DTO_SearchArtistShow, String> artistColumn;
    @FXML
    private TableColumn<DTO_SearchArtistShow, String> locationColumn;
    @FXML
    private TableColumn<DTO_SearchArtistShow, String> hourColumn;
    @FXML
    private TableColumn<DTO_SearchArtistShow, Integer> availableColumn;

    @FXML
    private Button logoutButton;


    public AfterLoginController() { }

    public void setAfterLoginController(Service service) {
        this.service = service;
        setTableData();
        loadData();
    }

    private void setTableData() {
        artistsTableView.getColumns().clear();
        artistColumnMain = new TableColumn<>("Name");
        dateColumnMain = new TableColumn<>("Date");
        locationColumnMain = new TableColumn<>("Location");
        availableColumnMain = new TableColumn<>("NoAvailableTickets");
        soldColumnMain = new TableColumn<>("NoSoldTickets");

        artistsTableView.getColumns().addAll(artistColumnMain, dateColumnMain, locationColumnMain, availableColumnMain, soldColumnMain);

        artistColumnMain.setCellValueFactory(new PropertyValueFactory<DTO_ArtistShow, String>("name"));
        dateColumnMain.setCellValueFactory(new PropertyValueFactory<DTO_ArtistShow, LocalDate>("date"));
        locationColumnMain.setCellValueFactory(new PropertyValueFactory<DTO_ArtistShow, String>("location"));
        availableColumnMain.setCellValueFactory(new PropertyValueFactory<DTO_ArtistShow, Integer>("availableTickets"));
        soldColumnMain.setCellValueFactory(new PropertyValueFactory<DTO_ArtistShow, Integer>("soldTickets"));

        searchArtistsTableView.getColumns().clear();
        artistColumn = new TableColumn<>("Name");
        locationColumn = new TableColumn<>("Location");
        hourColumn = new TableColumn<>("Hour");
        availableColumn = new TableColumn<>("Available Tickets");

        searchArtistsTableView.getColumns().addAll(artistColumn, locationColumn, hourColumn, availableColumn);

        artistColumn.setCellValueFactory(new PropertyValueFactory<DTO_SearchArtistShow, String>("name"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<DTO_SearchArtistShow, String>("location"));
        hourColumn.setCellValueFactory(new PropertyValueFactory<DTO_SearchArtistShow, String>("hour"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<DTO_SearchArtistShow, Integer>("availableTickets"));

    }

    @FXML
    private void initialize() {
        System.out.println("Initializat din AfterLoginController");
    }

    private void loadData() {
        artistsTableView.getItems().clear();
        List<DTO_ArtistShow> list = service.getArtistsShows();
        artistsTableView.setItems(FXCollections.observableList(list));
    }

    /**
     * Colouring the shows without any available tickets
     */
    @FXML
    private void changedText() {
        availableColumn.setCellFactory(param -> getTableCell());
    }

    private TableCell<DTO_SearchArtistShow, Integer> getTableCell() {
        return new TableCell<DTO_SearchArtistShow, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                setText(empty ? "" : getItem().toString());
                setGraphic(null);

                TableRow<DTO_SearchArtistShow> currentRow = getTableRow();

                if (!isEmpty()) {
                    if (item.equals(0))
                        currentRow.setStyle("-fx-background-color:pink");
                }
            }
        };
    }

    /**
     * Searching for the shows in the picked date
     */
    @FXML
    private void search() {
        if (searchDP.getValue().equals(null)) {
            showAlert("There is no date value!");
        } else {
            List<DTO_SearchArtistShow> searchList = service.getSearchArtistsShows(searchDP.getValue());

            if (searchList.size() < 1) {
                showAlert("There is no show in that day!");
            } else {
                searchArtistsTableView.getItems().clear();
                searchArtistsTableView.setItems(FXCollections.observableList(searchList));
                changedText();
            }
        }
    }

    @FXML
    private void buy() {
        if (searchArtistsTableView.getSelectionModel().getSelectedItem().equals(null) || purchaserText.getText().equals("") || ticketsText.getText().equals("")) {
            showAlert("ERROR: check the next steps." +
                    "\n1.You selected a show." +
                    "\n2.You wrote the purchaser's name." +
                    "\n3.You wrote the number of tickets he/she will buy.");
        } else {
            try {
                DTO_SearchArtistShow show = (DTO_SearchArtistShow) searchArtistsTableView.getSelectionModel().getSelectedItem();
                service.buyTickets(show, purchaserText.getText(), Integer.parseInt(ticketsText.getText()));

                search();
                purchaserText.clear();
                ticketsText.clear();
                loadData();


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Well Bought!");
                alert.show();

            } catch (Exception ex) {
                showAlert(ex.getMessage());
            }

        }
    }

    @FXML
    private void logout() {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}