package semo;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustmerProdVeiw extends Controller {
    @FXML
    private VBox sVbox;

    @FXML
    private VBox pVbox;

    @FXML
    private VBox mVbox;

    @FXML
    private VBox nVbox;




    public ArrayList<Stickers> stik=new ArrayList<>();
    public ArrayList<String> sname=new ArrayList<>();
    ArrayList<Pin> pn=new ArrayList<>();
    ArrayList<Mug> mg=new ArrayList<>();
    ArrayList<NoteBook> nb=new ArrayList<>();
    static int lastolid;

    String ssname;



    static String buttonname;


    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {


        butStrickers();
        try {
            lastolid=getlastol();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    void butStrickers(){
        try {
            getStrickerName();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<JFXButton> stb = new ArrayList<>();
        ArrayList<HBox> sHbox= new ArrayList<>();
        sHbox.add(new HBox());
        sHbox.get(0).setSpacing(20);
        sVbox.getChildren().add(sHbox.get(0));
        int j=0;

        for (int i=0;i<sname.size();i++){

            stb.add(new JFXButton());
            stb.get(i).setText(sname.get(i));
            stb.get(i).setStyle("-fx-background-radius: 30px;  " +
                    "-fx-font-size: 18px; -fx-border-color: #810D8C;" +
                    "-fx-border-radius: 30px;-fx-text-fill: #761054;" );
            stb.get(i).setGraphic(new ImageView(image));
            stb.get(i).setMinSize(250,150);
            stb.get(i).setMaxSize(250,130);
            sHbox.get(j).getChildren().add(stb.get(i));


            int finalI = i;
            stb.get(i).setOnAction(e->{
                System.out.println(finalI);
                setname(stb.get(finalI).getText());
                cartStricrt();
            });
             sHbox.get(j).setAlignment(Pos.CENTER);

            if (i%3==2){
                j++;
                sHbox.add(new HBox());
                sVbox.getChildren().add(sHbox.get(j));
                sHbox.get(j).setSpacing(20);
            }

        }

    }

    private void setname(String text) {
        this.buttonname=text;
        System.out.println(buttonname);
    }
    public String getButtonname() {

        return buttonname;
    }

    void addtoCart(ActionEvent event) {
        System.out.println("go");
    }
    private void cartStricrt() {


        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("Form/AddtoCartSticker.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.getIcons().add(icon);
            stage.setTitle("Cart");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    void getStrickerName() throws SQLException,ClassNotFoundException{
        connect2DB();
        String statmentSQL;
        statmentSQL = "select DISTINCT name from product p , sticker s where s.pid=p.pid AND p.pid>=1000;";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        while (rs.next()) {
            String s1 = rs.getString(1);
            sname.add(s1);
        }


        rs.close();
        s.close();
        conect.close();

    }
    public int getlastol() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL="SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = \"semo\" AND TABLE_NAME = \"orderline\";";
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

    @FXML
    void adCustmer(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("Form/cunsmui.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.getIcons().add(icon);
            stage.setTitle("Admin");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
