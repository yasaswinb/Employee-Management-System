package HRManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData {

    private final StringProperty empID;
    private final StringProperty empName;
    private final StringProperty DOB;
    private final StringProperty address;
    private final StringProperty phoneNumber;
    private final StringProperty jobRole;

    public EmployeeData(String empID, String empName, String DOB, String address, String phoneNumber, String jobRole) {

        this.empID = new SimpleStringProperty(empID);
        this.empName = new SimpleStringProperty(empName);
        this.DOB = new SimpleStringProperty(DOB);
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.jobRole = new SimpleStringProperty(jobRole);
    }

    public String getEmpID() {
        return empID.get();
    }

    public StringProperty empIDProperty() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID.set(empID);
    }

    public String getEmpName() {
        return empName.get();
    }

    public StringProperty empNameProperty() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName.set(empName);
    }

    public String getDOB() {
        return DOB.get();
    }

    public StringProperty DOBProperty() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
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

    public String getJobRole() {
        return jobRole.get();
    }

    public StringProperty jobRoleProperty() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole.set(jobRole);
    }
}
