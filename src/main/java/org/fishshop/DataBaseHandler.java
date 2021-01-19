package org.fishshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.fishshop.FinalVariable.*;


public class DataBaseHandler{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,DB_USERNAME,DB_PASSWORD);

        return dbConnection;
    }

    public ResultSet getUser(User user){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + TABLE_NAME_LOGIN + " WHERE " + USERS_NAME + "=? AND " + USERS_PASSWORD + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1,user.getUser_name());
            preparedStatement.setString(2,user.getUser_password());

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public ObservableList<Info> getInfo(){
        ObservableList<Info> list= FXCollections.observableArrayList();
        String select = "SELECT * FROM " + TABLE_NAME_PRODUCT;
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(new Info(Integer.parseInt(resultSet.getString(PRODUCT_ID)), resultSet.getString(PRODUCT_NAME),
                        Integer.parseInt(resultSet.getString(PRODUCT_PRICE)), resultSet.getString(PRODUCT_DATE),
                            Integer.parseInt(resultSet.getString(PRODUCT_COUNT))));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return list;
    }

    public List <Integer> getProfit(){
        List <Integer> profitList = new ArrayList<>();
        String select = "SELECT * FROM " + TABLE_NAME_PRODUCT;
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                profitList.add(Integer.parseInt(resultSet.getString(PRODUCT_PRICE)));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return profitList;
    }

    public List <String> getName(){
        List <String> nameList = new ArrayList<>();
        String select = "SELECT * FROM " + TABLE_NAME_PRODUCT;
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                nameList.add(resultSet.getString(PRODUCT_NAME));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return nameList;
    }

//    public List<String> getStatusTender(){
//        List <String> statusList = new ArrayList<>();
//        String select = "SELECT * FROM " + TABLE_NAME_PRODUCT;
//        try{
//            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()) {
//                statusList.add(resultSet.getString(INFO_STATUS));
//            }
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//        return statusList;
//    }
}