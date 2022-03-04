package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;
import model.Customer;


public class Schedule {

    /**
     * @param customer and product ID are automatically set. Set's starting ids at 0.
     */
    private static int customerId = 0;

    private static int appointmentId = 0;

    /**
     * @param Array list for all customers and all products.
     */

    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();


    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();

    /**
     *@param Array list for associated customers
     */

    private static ObservableList<Customer> allAssociatedCustomers = FXCollections.observableArrayList();

    /**
     *
     * @param customer Adds a customer, updates a customer and sets its index.
     */
    public static void addCustomer(Customer customer){
        allCustomers.add(customer);
    }

    public static void updateCustomer(int index, Customer customer){
        allCustomers.set(index, customer);
    }
    /**
     * @param appointment adds a appointment, updates a appointment and sets its index.
     */
    public static void addAppointment(Appointment appointment){
        allAppointments.add(appointment);
    }
    public static void updateAppointment(int index, Appointment appointment){
        allAppointments.set(index, appointment);
    }

    /**
     *
     * @return assigns customer Id, line 47 assigns a Product Id.
     */
    public static int assignCustomerId(){
        customerId++;
        return customerId;
    }

    public static int assignAppointmentId(){
        appointmentId++;
        return appointmentId;
    }
//    public static int assignUserId(){
//        userId++;
//        return userId;
//    }

    /**
     * Gets a list of all customers, line 53 gets a list of all products.
     * @return
     */
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }

    public static ObservableList<Appointment> getAllAppointments() {
        return allAppointments;
    }

    public static ObservableList<Customer> getAssociatedCustomers() {
        return allAssociatedCustomers;
    }

    /**
     *
     * @param selectedCustomer deletes selected customer. line 78 deletes selected product.
     * @return
     */
    public static boolean deleteCustomer(Customer selectedCustomer) {

        return allCustomers.remove(selectedCustomer);
    }

    public static boolean deleteAppointment(Appointment selectedAppointment) {

        return allAppointments.remove(selectedAppointment);

    }
}