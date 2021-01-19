package org.fishshop;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.transform.Result;

import static org.fishshop.FinalVariable.ONLINE_USER;

public class loginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginLabel;


    @FXML
    void initialize() {
        //auth
        Alert a = new Alert(Alert.AlertType.NONE);

        loginButton.setOnAction(actionEvent -> {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();

            if(!login.equals("") && !password.equals("")) {
                loginUser(login,password);
            }else{
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Ведіть коректний пароль");
                a.show();
            }
        });
        //end auth
    }

    private void loginUser(String user_name, String user_password){
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        User user = new User();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        user.setUser_name(user_name);
        user.setUser_password(user_password);
        ResultSet resultSet = dataBaseHandler.getUser(user);

        int counter = 0;

        try{
            while(resultSet.next()){
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(counter >= 1){
            ONLINE_USER = user_name;

            loginButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("main.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.show();
        }else{
            loginField.setText("");
            passwordField.setText("");
            loginLabel.setText("Не вірні дані!Спробуйте знову");
        }
    }
}