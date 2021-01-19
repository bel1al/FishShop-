package org.fishshop;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

import static org.fishshop.FinalVariable.*;


public class mainController {

    Stage stage = new Stage();
    FXMLLoader loader = new FXMLLoader();

//    onlineUserLabel.setText(onlineUserLabel.getText() + ONLINE_USER);
//    onlineUserLabel.autosize();

    @FXML
    private TableView<Info> tableView;

    @FXML
    private TableColumn<Info, Integer> id;

    @FXML
    private TableColumn<Info, String> name;

    @FXML
    private TableColumn<Info, Integer> price;

    @FXML
    private TableColumn<Info, String> date;

    @FXML
    private TableColumn<Info, Integer> count;

    @FXML
    private Label onlineUserLabel;

    ObservableList<Info> listM;
    DataBaseHandler dataBaseHandler = new DataBaseHandler();

    @FXML
    void initialize() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        onlineUserLabel.setText(onlineUserLabel.getText() + ONLINE_USER);
        onlineUserLabel.autosize();
        //col add data from mysql
        id.setCellValueFactory(new PropertyValueFactory<Info,Integer>(PRODUCT_ID));
        name.setCellValueFactory(new PropertyValueFactory<Info,String>(PRODUCT_NAME));
        price.setCellValueFactory(new PropertyValueFactory<Info,Integer>(PRODUCT_PRICE));
        date.setCellValueFactory(new PropertyValueFactory<Info,String>(PRODUCT_DATE));
        count.setCellValueFactory(new PropertyValueFactory<Info,Integer>(PRODUCT_COUNT));
        List<Integer> profitList = dataBaseHandler.getProfit();
        System.out.println(profitList);
        listM = dataBaseHandler.getInfo();
        tableView.setItems(listM);

        listM = dataBaseHandler.getInfo();
        tableView.setItems(listM);
    }
}
