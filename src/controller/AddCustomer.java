package controller;



import helper.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Customer;
import model.Schedule;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

    public class AddCustomer implements Initializable {

        Stage stage;
        Parent scene;

        @FXML
        public TextField idTxt;

        @FXML
        private TextField customerNameTxt;

        @FXML
        private TextField postalCodeTxt;

        @FXML
        private TextField phoneTxt;

        @FXML
        private TextField addressTxt;

        @FXML
        private TextField countryTxt;

        @FXML
        private RadioButton unitedStatesRdoBtn;

        @FXML
        private RadioButton canadaRdoBtn;

        @FXML
        private RadioButton unitedKingdomRdoBtn;

        @FXML
        private Button backBtn;

        @FXML
        private ComboBox cityComboBox;

        @FXML
        private Label cityOrCountryLbl;


        public void countryComboBox() throws SQLException, Exception{

        }


        /**
         * @param event onActionSavePart saves part
         */
        @FXML
        void onActionSaveCustomer (ActionEvent event) throws IOException {

            try {


                int customerId = (Schedule.getAllCustomers().size() + 1);
                String customerName = customerNameTxt.getText();
                double phone = Double.parseDouble(phoneTxt.getText());
                int postalCode = Integer.parseInt(postalCodeTxt.getText());
                String address = addressTxt.getText();
                String country = countryTxt.getText();
                String state = cityComboBox.getTypeSelector();

//                if (min > max) {
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle("Warning Dialog");
//                    alert.setContentText("Max must be greater than the min!");
//                    alert.showAndWait();
//                    return;
//                }
//                if (stock > max | stock < min) {
//                    Alert alert = new Alert(Alert.AlertType.WARNING);
//                    alert.setTitle("Warning Dialog");
//                    alert.setContentText("Stock must be between max and min!");
//                    alert.showAndWait();
//                    return;
//                }


                    Schedule.addCustomer(new Customer(customerId, customerName, phone, postalCode, address, country, state));

                    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    scene = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
                    stage.setScene(new Scene(scene));
                    stage.show();


            }
            /**
             *@param check checks for number format exception.
             */
            catch(NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setContentText("Please enter valid values in the text boxes!");
                alert.showAndWait();
            }



        }
        /**
         *@param event onActionDisplayMainMenu brings user back to main as well as confirming that they wish to cancel adding a new part.
         */
        @FXML
        void onActionDisplayMainMenu (ActionEvent event) throws IOException {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will clear all text field values, do you want to continue?");

            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && result.get() == ButtonType.OK) {

                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();

            }
        }
        /**
         *@param event OnActionInHouse changes the form to inHouse.
         */
        @FXML
        void onActionUnitedStates (ActionEvent event) throws IOException{
            countryTxt.setPromptText("United States");
            addressTxt.setPromptText("123 ABC Street, White Plains");
            cityOrCountryLbl.setText("State");

        }
        /**
         *@param event onActionOutsourced changes the form to outsourced.
         */
        @FXML
        void onActionCanada (ActionEvent event) throws IOException{
           countryTxt.setPromptText("Canada");
           addressTxt.setPromptText("123 ABC Street, Newmarket");
            cityOrCountryLbl.setText("City");
        }

        @FXML
        void onActionUnitedKingdom (ActionEvent event) throws IOException{
            countryTxt.setPromptText(("United Kingdom"));
            addressTxt.setPromptText("123 ABC Street, Greenwich, London");
            cityOrCountryLbl.setText("Country");
        }
        /**
         * @param url
         * @param resourceBundle
         */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {


        }
    }

