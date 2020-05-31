package loginDBMS;

import HRManager.HRManagerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.Pane;

public class loginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;

    public void initialize(URL url, ResourceBundle rb) {
        if (this.loginModel.isDatabaseConnected()) {
            this.dbstatus.setText("Connected To Database");
        } else {
            this.dbstatus.setText("Not Connected to Database");
        }
    }

    @FXML
    public void Login(ActionEvent event) {
        try {
            if (this.loginModel.isLogin(this.username.getText(), this.password.getText())) {
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();
                HRManagerLogin();
            } else {
                this.loginStatus.setText("Wrong Username or Password");
            }

        } catch (Exception localException) {

        }

    }

    public void HRManagerLogin() {
        try {
            Stage HRManagerStage = new Stage();
            FXMLLoader HRManagerLoader = new FXMLLoader();
            Pane HRManagerRoot = (Pane) HRManagerLoader.load(getClass().getResource("/HRManager/HRManager.fxml").openStream());
            HRManagerController hrManagerController = (HRManagerController) HRManagerLoader.getController();

            Scene scene = new Scene(HRManagerRoot);
            HRManagerStage.setScene(scene);
            HRManagerStage.setTitle("HRManager Dashboard");
            HRManagerStage.setResizable(false);
            HRManagerStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
