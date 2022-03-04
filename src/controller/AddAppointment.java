package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointment;
import model.Schedule;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddAppointment implements Initializable {

    Stage stage;
    Parent scene;



    @FXML
    public TextField idTxt;

    @FXML
    private TextField titleTxt;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private TextField locationTxt;

    @FXML
    private TextField contactTxt;

    @FXML
    private TextField typeTxt;

    @FXML
    private TextField startTimeTxt;

    @FXML
    private TextField endTimeTxt;

    @FXML
    private TextField startDateTxt;

    @FXML
    private TextField endDateTxt;

    @FXML
    private TextField customerIdTxt;

    @FXML
    private TextField userTxt;

    @FXML
    private Button removeAssoCustomerBtn;

    @FXML
    private TableView<Customer> customerTableView;

    @FXML
    private TableColumn<Customer, Integer> customersIdCol;

    @FXML
    private TableColumn<Customer, String> customersNameCol;

    @FXML
    private TableColumn<Customer, Integer> customersPhoneCol;

    @FXML
    private TableColumn<Customer, Integer> customersCountryCol;

    @FXML
    private TableColumn<Customer, Integer> assoCustomersIdCol;

    @FXML
    private TableColumn<Customer, String> assoCustomersNameCol;

    @FXML
    private TableColumn<Customer, Integer> assoCustomersPhoneCol;

    @FXML
    private TableColumn<Customer, Integer> assoCustomersCountryCol;


    @FXML
    private TableView<Customer> assoCustomerTableView;
    private ObservableList<Customer> assoCustomer = FXCollections.observableArrayList();


    /**
     *@param event  onActionAddAssoCustomer add customer to the associated customers table.
     */
    @FXML
    void onActionAddAssoCustomer (ActionEvent event) throws IOException{
        assoCustomer.add(customerTableView.getSelectionModel().getSelectedItems().get(0));
    }
    /**
     *@param event onActionRemoveAssoCustomer remove customer from the associated customers table.
     */
    @FXML
    void onActionRemoveAssoCustomer (ActionEvent event) throws IOException{
        assoCustomer.remove((assoCustomerTableView.getSelectionModel().getSelectedItems().get(0)));
    }
    /**
     *@param event onActionSaveProduct saves appointment
     */
    @FXML
    void onActionSaveAppointment (ActionEvent event) throws IOException {

        try {


            int appointmentId = (Schedule.getAllAppointments().size() + 1);
            String title = titleTxt.getText();
            String description = descriptionTxt.getText();
            String location = locationTxt.getText();
            String type = typeTxt.getText();
            String contact = contactTxt.getText();
            double startTime = Double.parseDouble(startTimeTxt.getText());
            int startDate = Integer.parseInt(startDateTxt.getText());
            double endTime = Double.parseDouble(endTimeTxt.getText());
            int endDate = Integer.parseInt(endDateTxt.getText());
            int userId = (0);
            int customerId = 0;


            if (startTime > endTime) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setContentText("Max must be greater than the min!");
                alert.showAndWait();
                return;
            }
            if (startDate > endDate) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setContentText("Start date must be before end date");
                alert.showAndWait();
                return;
            }

            Appointment appointment = new Appointment(appointmentId, title, description, location, contact, type, startTime, startDate, endTime, endDate, customerId, userId);
            for (Customer customer: assoCustomer){
                appointment.addAssociatedCustomer(customer);
            }
            Schedule.addAppointment(appointment);

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("Please enter valid values in the text boxes!");
            alert.showAndWait();


        }
    }

    /**
     *@param event onActionDisplay Main brings the user to the main menu and confirms they wish to cancel adding appointment.
     */
    @FXML
    void onActionDisplayMainMenu (ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will clear all text field values, do you want to continue?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        }
    }

    /**
     *@param location
     * @param resources
     * initializes the screen
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /**
         *@param setItems sets the tables to allCustomers and assoCustomers.
         */
        customerTableView.setItems(Schedule.getAllCustomers());
        customersIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customersNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customersPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customersCountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));

        assoCustomerTableView.setItems(assoCustomer);
        assoCustomersIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        assoCustomersNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        assoCustomersPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        assoCustomersCountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
    }



}