package com.example.crudaggro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public final class HelloController  extends JavaPostgreSql implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private  TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private  TextField tfFixe;
    @FXML
    private TextField tfPortable;
    @FXML
    private  TextField tfService;
    @FXML
    private  TextField tfSite;
    @FXML
    private TableView<Salarie> tvSalarie;
    @FXML
    private  TableColumn<Salarie,Integer> colId;
    @FXML
    private TableColumn< Salarie,String> colNom;
    @FXML
    private TableColumn< Salarie,String> colPrenom;
    @FXML
    private TableColumn< Salarie,String> colFixe;
    @FXML
    private TableColumn< Salarie,String> colPortable;
    @FXML
    private TableColumn< Salarie,String> colEmail;
    @FXML
    private TableColumn<Services, String> colService;
    @FXML
    private TableColumn<Sites, String> colSite;
    @FXML
    private Button btnInsert;
    @FXML
    private  Button btnUpdate;
    @FXML
    private  Button btnDelete;




    @FXML
    private void handleButtonAction(ActionEvent event) {

        if (event.getSource() == btnInsert) {
            insertRecord();

        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showSalarie();

    }

    public Connection getConnection(){
        Connection conn;
        try {
            conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/aggro",
                    "kroutok", "pouet");
            return  conn;
        } catch (Exception ex) {
            System.out.println("ça marche po : " + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Salarie> getSalarieList() {
        ObservableList<Salarie> salarieList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = " SELECT * FROM salarie";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Salarie salarie;
            while(rs.next()) {
                salarie = new Salarie(rs.getInt("salarie_id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("fixe"),
                        rs.getString("portable"),
                        rs.getString("email"));



                salarieList.add(salarie);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return salarieList;
    }

    public ObservableList<Services> getServicesList() {
        ObservableList<Services> servicesList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = " SELECT * FROM service";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Services services;
            while(rs.next()) {
                services = new Services(rs.getInt("service_id"),
                        rs.getString("service"));




                servicesList.add(services);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return servicesList;
    }

    public void showSalarie(){
        ObservableList<Salarie> list = getSalarieList();

        colId.setCellValueFactory(new PropertyValueFactory< Salarie, Integer>("salarie_id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Salarie, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Salarie, String>("prenom"));
        colFixe.setCellValueFactory(new PropertyValueFactory<Salarie, String>("fixe"));
        colPortable.setCellValueFactory(new PropertyValueFactory<Salarie, String>("portable"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Salarie, String>("email"));
        colService.setCellValueFactory(new PropertyValueFactory<Services, String>("service"));
        colSite.setCellValueFactory(new PropertyValueFactory<Sites, String>("site"));

        tvSalarie.setItems(list);

    }


    private void insertRecord(){
        String query ="INSERT INTO salarie,service,site VALUES(" + tfNom.getText()
                + ",'" + tfPrenom.getText()
                + "','" + tfFixe.getText()
                + "'," + tfPortable.getText()
                + "','" + tfEmail.getText()
                + "','" + tfService.getText()
                + tfSite.getText()+ ")";
        executeQuery(query);

        showSalarie();
    }
    private void  executeQuery(String query){
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}



