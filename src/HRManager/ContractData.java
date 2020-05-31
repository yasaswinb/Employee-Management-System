package HRManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContractData {

    private final StringProperty conID;
    private final StringProperty conDesc;
    private final StringProperty creationData;
    private final StringProperty jobRole;
    private final StringProperty projectLeader;
    private final StringProperty cusID;

    public ContractData(String conID, String conDesc, String creationData, String jobRole, String projectLeader, String cusID) {
        this.conID = new SimpleStringProperty(conID);
        this.conDesc = new SimpleStringProperty(conDesc);
        this.creationData = new SimpleStringProperty(creationData);
        this.jobRole = new SimpleStringProperty(jobRole);
        this.projectLeader = new SimpleStringProperty(projectLeader);
        this.cusID = new SimpleStringProperty(cusID);
    }

    public String getConID() {
        return conID.get();
    }

    public StringProperty conIDProperty() {
        return conID;
    }

    public void setConID(String conID) {
        this.conID.set(conID);
    }

    public String getConDesc() {
        return conDesc.get();
    }

    public StringProperty conDescProperty() {
        return conDesc;
    }

    public void setConDesc(String conDesc) {
        this.conDesc.set(conDesc);
    }

    public String getCreationData() {
        return creationData.get();
    }

    public StringProperty creationDataProperty() {
        return creationData;
    }

    public void setCreationData(String creationData) {
        this.creationData.set(creationData);
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

    public String getProjectLeader() {
        return projectLeader.get();
    }

    public StringProperty projectLeaderProperty() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader.set(projectLeader);
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
}
