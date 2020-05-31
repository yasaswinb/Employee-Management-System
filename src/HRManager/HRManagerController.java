package HRManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import dbUtil.dbConnection;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.sql.Connection;

public class HRManagerController implements Initializable {
    //Employee
    @FXML
    private TextField empID;
    @FXML
    private TextField empName;
    @FXML
    private DatePicker DOB;
    @FXML
    private TextField address;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField jobRole;

    //Table view
    @FXML
    private TableView<EmployeeData> employeeTable;

    @FXML
    private TableColumn<EmployeeData, String> empIDcolumn;
    @FXML
    private TableColumn<EmployeeData, String> empNamecolumn;
    @FXML
    private TableColumn<EmployeeData, String> DOBcolumn;
    @FXML
    private TableColumn<EmployeeData, String> addresscolumn;
    @FXML
    private TableColumn<EmployeeData, String> phoneNumbercolumn;
    @FXML
    private TableColumn<EmployeeData, String> jobRolecolumn;

    private dbConnection dc;
    private ObservableList<EmployeeData> data;

    private String sql = "SELECT * FROM employee";

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new dbConnection();
    }

    //load employee data
    @FXML
    private void loadEmployeeData(ActionEvent event) {
        try {

            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.data.add(new EmployeeData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (SQLException e) {
            System.err.println("Error " + e);

        }

        this.empIDcolumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("empID"));
        this.empNamecolumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("empName"));
        this.DOBcolumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("DOB"));
        this.addresscolumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("address"));
        this.phoneNumbercolumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("phoneNumber"));
        this.jobRolecolumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("jobRole"));

        this.employeeTable.setItems(null);
        this.employeeTable.setItems(this.data);
    }

    //enter data to database
    @FXML
    private void addEmployee(ActionEvent event) {
        String sqlInsert = "INSERT INTO employee(empID,empName,DOB,address,phoneNumber,jobRole) VALUES (?,?,?,?,?,?)";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.empID.getText());
            stmt.setString(2, this.empName.getText());
            stmt.setString(3, this.DOB.getEditor().getText());
            stmt.setString(4, this.address.getText());
            stmt.setString(5, this.phoneNumber.getText());
            stmt.setString(6, this.jobRole.getText());

            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Already exist");
            e.printStackTrace();
        }
    }

    //Updates data
    @FXML
    public void updateEmployee() {


    }

    //Clears the employee form
    @FXML
    private void clearFields(ActionEvent event) {
        this.empID.setText("");
        this.empName.setText("");
        this.DOB.setValue(null);
        this.address.setText(null);
        this.phoneNumber.setText(null);
        this.jobRole.setText("");
    }

    //Delete the employee
    @FXML
    private void deleteEmployee(ActionEvent event) {

        String sqlDelete = "DELETE FROM employee WHERE empID = ?";

        try {

            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlDelete);

            stmt.setString(1, this.empID.getText());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }


    //Customer
    @FXML
    private TextField cusID;
    @FXML
    private TextField cusName;
    @FXML
    private TextField addressCus;
    @FXML
    private TextField phoneNumberCus;

    //Table view
    @FXML
    private TableView<CustomerData> customerTable;

    @FXML
    private TableColumn<CustomerData, String> cusIDcolumn;
    @FXML
    private TableColumn<CustomerData, String> cusNamecolumn;
    @FXML
    private TableColumn<CustomerData, String> addressCuscolumn;
    @FXML
    private TableColumn<CustomerData, String> phoneNumberCuscolumn;

    private dbConnection dcCus;
    private ObservableList<CustomerData> cusData;

    private String sqlCus = "SELECT * FROM customer";

    public void initializeCus(URL url, ResourceBundle rb) {
        this.dcCus = new dbConnection();
    }

    //Load customer data
    @FXML
    private void loadCustomerData(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getConnection();
            this.cusData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sqlCus);
            //This loop runs until the last row
            while (rs.next()) {
                this.cusData.add(new CustomerData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

        } catch (SQLDataException e) {
            System.err.println("Error " + e);
        }

        //Display data
        this.cusIDcolumn.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("cusID"));
        this.cusNamecolumn.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("cusName"));
        this.addressCuscolumn.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("address"));
        this.phoneNumberCuscolumn.setCellValueFactory(new PropertyValueFactory<CustomerData, String>("phoneNumber"));

        this.customerTable.setItems(null);
        this.customerTable.setItems(this.cusData);
    }

    //Add data to customer database
    @FXML
    private void addCustomer(ActionEvent event) {
        String sqlInsert = "INSERT INTO customer(cusID,cusName,address,phoneNumber) VALUES(?,?,?,?)";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.cusID.getText());
            stmt.setString(2, this.cusName.getText());
            stmt.setString(3, this.addressCus.getText());
            stmt.setString(4, this.phoneNumberCus.getText());

            stmt.execute();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Already exist");
            e.printStackTrace();
        }
    }

    //Clears the customer form
    @FXML
    private void clearFieldsCus(ActionEvent event) {
        this.cusID.setText("");
        this.cusName.setText("");
        this.addressCus.setText("");
        this.phoneNumberCus.setText("");
    }


    //Contract
    @FXML
    private TextField conID;
    @FXML
    private TextField conDesc;
    @FXML
    private DatePicker creationDate;
    @FXML
    private TextField jobRoleCon;
    @FXML
    private TextField projectLeader;
    @FXML
    private TextField cusIDCon;

    @FXML
    private TableView<ContractData> contractTable;

    @FXML
    private TableColumn<ContractData, String> conIDcolumn;
    @FXML
    private TableColumn<ContractData, String> conDesccolumn;
    @FXML
    private TableColumn<ContractData, String> creationDatecolumn;
    @FXML
    private TableColumn<ContractData, String> jobRoleConcolumn;
    @FXML
    private TableColumn<ContractData, String> projectLeadercolumn;
    @FXML
    private TableColumn<ContractData, String> cusIDConcolumn;

    private dbConnection dcCon;
    private ObservableList<ContractData> conData;

    private String sqlCon = "SELECT * FROM contract";

    public void initializeCon(URL url, ResourceBundle rb) {
        this.dcCon = new dbConnection();
    }

    //Load Contract Data
    @FXML
    private void loadContractData(ActionEvent event) {
        try {

            Connection conn = dbConnection.getConnection();
            this.conData = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sqlCon);
            while (rs.next()) {
                this.conData.add(new ContractData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            System.err.println("Error " + e);
        }

        this.conIDcolumn.setCellValueFactory(new PropertyValueFactory<ContractData, String>("conID"));
        this.conDesccolumn.setCellValueFactory(new PropertyValueFactory<ContractData, String>("conDesc"));
        this.creationDatecolumn.setCellValueFactory(new PropertyValueFactory<ContractData, String>("creationDate"));
        this.jobRoleConcolumn.setCellValueFactory(new PropertyValueFactory<ContractData, String>("jobRole"));
        this.projectLeadercolumn.setCellValueFactory(new PropertyValueFactory<ContractData, String>("projectLeader"));
        this.cusIDConcolumn.setCellValueFactory(new PropertyValueFactory<ContractData, String>("cusID"));

        this.contractTable.setItems(null);
        this.contractTable.setItems(this.conData);
    }

    //Enter data to contract database
    @FXML
    private void addContract(ActionEvent event) {
        String sqlInsert = "INSERT INTO contract(conID,conDesc,creationDate,jobRole,projectLeader,cusID) VALUES(?,?,?,?,?,?)";

        try {

            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);

            stmt.setString(1, this.conID.getText());
            stmt.setString(2, this.conDesc.getText());
            stmt.setString(3, this.creationDate.getEditor().getText());
            stmt.setString(4, this.jobRoleCon.getText());
            stmt.setString(5, this.projectLeader.getText());
            stmt.setString(6, this.cusIDCon.getText());

            stmt.execute();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Already exist");
            e.printStackTrace();
        }
    }

    //Clears the contract form
    @FXML
    private void clearFieldsCon(ActionEvent event) {
        this.conID.setText("");
        this.conDesc.setText("");
        this.creationDate.setValue(null);
        this.jobRoleCon.setText("");
        this.projectLeader.setText("");
        this.cusIDCon.setText("");
    }

}
