package main;

import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Appointment;
import model.Customer;
import model.Schedule;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FirstScreen.fxml"));
        stage.setTitle("First Screen");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
    public static void main(String[] args) {

        Customer customer1 = new Customer((Schedule.assignCustomerId()), "Cum Drinker", 1456, 10, "address", "country", "Maine");
        Customer customer2 = new Customer((Schedule.assignCustomerId()), "Test 2", 456, 20, "address", "country", "Minnesota");

       Schedule.addCustomer(customer1);
       Schedule.addCustomer(customer2);

        Appointment appointment1 = new Appointment((Schedule.assignAppointmentId()), "title", "description", "location", "contact", "type", 34.34, 12323, 23.34, 23, customer1.getCustomerId(), 34);

        Schedule.addAppointment(appointment1);

        JDBC.openConnection();
        launch(args);
        JDBC.closeConnection();
    }
}
