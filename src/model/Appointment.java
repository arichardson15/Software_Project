package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Schedule;

/**
 * Product model
 */
public class Appointment {
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String contact;
    private String type;
    private Double startTime;
    private int startDate;
    private Double endTime;
    private int endDate;
    private int customerId;
    private int userId;
    private ObservableList<Customer> associatedCustomers = FXCollections.observableArrayList();
    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    private static ObservableList<Appointment> filteredAppointments = FXCollections.observableArrayList();


    public Appointment(int appointmentId, String title, String description, String location, String contact,
                       String type, Double startTime, Integer startDate, Double endTime, Integer endDate, Integer customerId, Integer userId){
        this.appointmentId = appointmentId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.startTime = startTime;
        this.startDate = startDate;
        this.endTime = endTime;
        this.endDate = endDate;
        this.customerId = customerId;
        this.userId = userId;
    }

    /**
     *Getter and Setter for the different Product attributes.
     */

    public Appointment() {

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getlocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public String getContact() {

        return contact;
    }

    public void setContact(String contact) {

        this.contact = contact;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }
    
    public int getStartDate(){
        
        return startDate;
    }

    public double getStartTime(){
        return startTime;
    }

    public void setStartTime(double startTime) {

        this.startTime = startTime;
    }

    public void setStartDate(int startDate){
        
        this.startDate = startDate;
    }

    public double getEndTime(){
        return endTime;
    }

    public void setEndTime(double endTime) {

        this.endTime = endTime;
    }

    public int getEndDate(){

        return endDate;
    }

    public void setEndDate(int endDate){

        this.endDate = endDate;
    }

    public int getCustomerId(){

        return customerId;
    }

    public void setCustomerId(int customerId){

        this.customerId = customerId;
    }

    public int getUserId(){

        return userId;
    }

    public void setUserId(int userId){

        this.userId = userId;
    }

    /**
     *
     * @param customer add the associated part
     */
    public void addAssociatedCustomer (Customer customer){
        associatedCustomers.add(customer);
    }

    /**
     *
     * @param selectedAssociatedCustomer deletes the associated parts from the selected product.
     * @return
     */
    public boolean deleteAssociatedCustomer (Customer selectedAssociatedCustomer) {
        return associatedCustomers.remove(selectedAssociatedCustomer);
    }





    /**
     *
     * @return gets list of all associated parts for the product.
     */

    public ObservableList<Customer> getAllAssociatedCustomers() {
        return associatedCustomers;
    }

}
