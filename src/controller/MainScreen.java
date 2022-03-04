package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointment;
import model.Customer;
import model.Schedule;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class MainScreen implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Button exitBtn;

    @FXML
    private Button addCustomerBtn;

    @FXML
    private Button addAppointmentBtn;

    @FXML
    private TableView<Customer> customerTblView;

    @FXML
    private TableColumn<Customer, Integer> customerIdCol;

    @FXML
    private TableColumn<Customer, String> customerNameCol;

    @FXML
    private TableColumn<Customer, Double> phoneCol;

    @FXML
    private TableColumn<Customer, Integer> postalCodeCol;

    @FXML
    private TableColumn<Customer, String> addressCol;

    @FXML
    private TableColumn<Customer, String> countryCol;

    @FXML
    private TableView<Appointment> appointmentTblView;

    @FXML
    private TableColumn<Appointment, String> appointmentIdCol;

    @FXML
    private TableColumn <Appointment, String>  titleCol;

    @FXML
    private TableColumn <Appointment, String>  descriptionCol;

    @FXML
    private TableColumn <Appointment, String>  locationCol;

    @FXML
    private TableColumn <Appointment, String>  contactCol;

    @FXML
    private TableColumn <Appointment, String>  typeCol;

    @FXML
    private TableColumn<Appointment, Integer> startDateCol;

    @FXML
    private TableColumn<Appointment, Double> startTimeCol;

    @FXML
    private TableColumn<Appointment, Integer> endDateCol;

    @FXML
    private TableColumn<Appointment, Double> endTimeCol;

    @FXML
    private TableColumn<Appointment, Integer> customerAppointmentIdCol;

    @FXML
    private TableColumn<Appointment, Integer> userIdCol;

    @FXML
    void onActionAddCustomer (ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddCustomer.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionAddAppointment (ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddAppointment.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onExitBtn (ActionEvent event) {
        System.exit(0);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        customerTblView.setItems(Schedule.getAllCustomers());
        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        postalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        appointmentTblView.setItems(Schedule.getAllAppointments());
        appointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        endTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        customerAppointmentIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        userIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
    }
}
