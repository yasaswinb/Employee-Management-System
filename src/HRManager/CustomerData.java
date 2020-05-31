package HRManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerData {
    private final StringProperty cusID;
    private final StringProperty cusName;
    private final StringProperty address;
    private final StringProperty phoneNumber;

    public CustomerData(String cusID, String cusName, String address, String phoneNumber) {
        this.cusID = new SimpleStringProperty(cusID);
        this.cusName = new SimpleStringProperty(cusName);
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    public String getCusID() {
        return cusID.get();
    }

    public StringProperty cusIDProperty() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID.set(cusID);
    }

    public String getCusName() {
        return cusName.get();
    }

    public StringProperty cusNameProperty() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName.set(cusName);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
