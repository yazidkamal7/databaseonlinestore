package semo;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Report extends Controller{

    @FXML
    private JFXTextField numCustmer;



    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        try {
            numCustmer.setText(String.valueOf(getnumofCustmer()));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int getnumofCustmer() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL="SELECT COUNT(DISTINCT c.cname) FROM custmer c;";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);

        int id=0;
        while ( rs.next() ){


            id= rs.getInt(1);

        }
        rs.close();
        s.close();
        conect.close();
        return id;
    }

}
