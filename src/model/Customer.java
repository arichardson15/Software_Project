package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Schedule;

public class Customer extends Schedule {
    private int customerId;
    private String customerName;
    private double phone;
    private int postalCode;
    private String address;
    private String country;
    private String state;
    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

    public Customer(int customerId, String customerName, double phone, int postalCode, String address, String country, String state) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.postalCode = postalCode;
        this.address = address;
        this.country = country;
        this.state = state;
    }



    /**
     * @return the id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the id to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the name to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the price
     */
    public double getPhone() {
        return phone;
    }

    /**
     * @param phone the price to set
     */
    public void setPhone(double phone) {
        this.phone = phone;
    }

    /**
     * @return the postalCode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the stock to set
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the min
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the max to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}