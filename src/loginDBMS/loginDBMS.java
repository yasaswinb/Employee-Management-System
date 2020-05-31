package loginDBMS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class loginDBMS extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setTitle("Small Computer Consultancy Firm DBMS");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
