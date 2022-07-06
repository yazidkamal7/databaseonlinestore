package semo;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.*;

import static java.lang.System.currentTimeMillis;

public class Controller implements Initializable {
    protected Image icon;
        public ArrayList<Custmer> newCustmer=new ArrayList<Custmer>();
    public ObservableList<Custmer> custmersList;


    public Image image = new Image(getClass().getResourceAsStream("img/null.png"));

    public Controller() {

        icon = new Image(
                Main.class.getResource("img/semo3.png").toExternalForm());
    }



    private String URLDB;
    private String dbUsername="root";
    private String dbPassword="root";
    private String URL="127.0.0.1";
    private String port="3306";
    private String dbName="semo";
    public Connection conect;

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton backid;
    @FXML
    void login(ActionEvent event) {
        if( password.getText().equals(getPassword()) && !username.getText().isEmpty()){
            try {
                    Parent root2 = FXMLLoader.load(getClass().getResource("Form/tableV.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root2));
                    stage.getIcons().add(icon);
                    stage.setTitle("Admin");
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) backid.getScene().getWindow();
                stage.close();
            }

            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("User name or Password is Wrong");
                alert.setContentText("try us: root , pass: root1234");
                alert.showAndWait();
            }

    }
    @FXML
    void btAdmin(ActionEvent event) throws Exception {
        System.out.println(currentTimeMillis());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form/adminlogin.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(icon);
            stage.setTitle("logIn");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btCu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("form/CustmerProdVeiw.fxml"));
            Stage stagec = new Stage();
            stagec.setScene(new Scene(root));
            stagec.getIcons().add(icon);
            stagec.setTitle("Custmer");
            stagec.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) {
        Stage stage = (Stage) backid.getScene().getWindow();
        stage.close();
       
    }


    @Override @FXML
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void insertNewCustmer(Custmer c) {

        try {

            connect2DB();
            comandSQL("Insert into custmer (cuid, cname, phonenumber, socialacc, address) values" +
                    "('"+c.getCuid()+"','"+c.getName()+"','"+ c.getPhonenumber() +"','"+ c.getSocialAccount()+"','"+ c.getAdress()+"')");

            conect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void getDataCust() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select * from custmer order by cuid";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        while ( rs.next() ){
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            String s3=rs.getString(3);
            String s4=rs.getString(4);
            String s5=rs.getString(5);
            Custmer c=new Custmer();
            c.setCuid(s1);
            c.setName(s2);
            c.setPhonenumber(s3);
            c.setSocialAccount(s4);
            c.setAdress(s5);
            newCustmer.add(c);

        }

        rs.close();
        s.close();
        conect.close();

    }


    public void connect2DB() throws ClassNotFoundException, SQLException {

        URLDB="jdbc:mysql://"+URL+":"+port+"/"+dbName+"?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user",dbUsername);
        p.setProperty("password",dbPassword);
        p.setProperty("useSSL","false");
        p.setProperty("autoReconnect","true");
        Class.forName("com.mysql.jdbc.Driver");
        conect = DriverManager.getConnection (URLDB,p);

    }


    public void comandSQL(String stSQL) throws SQLException {

        try {
            Statement st = conect.createStatement();
            st.executeUpdate(stSQL);
            st.close();
        }
        catch(SQLException s) {
            s.printStackTrace();
            System.out.println("SQL statement have an Errors" +" "+stSQL);

        }


    }
    private String getPassword (){
        String p="";

        try {
            connect2DB();

            String sqlSt="select a.password from admin a where a.username='"+username.getText()+"';";
            Statement s = conect.createStatement();
            ResultSet rs = s.executeQuery(sqlSt);
            while (rs.next()){

                p=rs.getString(1);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        
        return p;
    }

}
