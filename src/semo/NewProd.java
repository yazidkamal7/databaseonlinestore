package semo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class NewProd extends Controller {
    @FXML
    private VBox vb1;

    @FXML
    private ComboBox<String> typeProd;

    @FXML
    private TextField nameProd;

    @FXML
    private VBox vbimage;

    private Label lname =new Label();
    private HBox p = new HBox();
    private CheckBox isMagic;
    private TextField magicT;
    private CheckBox notMagic ;
    private TextField notmagicT;
    private CheckBox small;
    private TextField smallT;
    private CheckBox medium;
    private TextField mediumT;
    private CheckBox large;
    private TextField largeT;
    private TextField pp40;
    private TextField pp80;

    private File file;
    private String[] sp=new String[3];
    private String[] pricepin=new String[3];
     private String[] mp=new String[2];
    String[] pricenote = new String[2];

    @FXML
    void addimage(ActionEvent event) {
          FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Choose Photo");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG file", "*.jpg","*.png"));
             file = fileChooser.showOpenDialog(null);
            lname.setText(file.getName());
            lname.setStyle("-fx-text-fill: #810D8C");
            vbimage.getChildren().add(lname);
            System.out.println(file.getAbsolutePath());

    }

    @FXML
    void addnewProd(ActionEvent event) {
//        typeProd.setValue(String.valueOf(" "));
        if (typeProd.getValue().equals("Stickrs")){
            Stickers s = new Stickers();
            if(small.isSelected()){

                s.setName(nameProd.getText());
                s.setImage(file.getAbsolutePath());
                insertNewProduct(s);

                try {
                    s.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                s.setPrice(Double.parseDouble(smallT.getText()));
                s.setSize('S');
                insertNewStickers(s);
            }
            if(medium.isSelected()){

                s.setName(nameProd.getText());
                s.setImage(file.getAbsolutePath());
                insertNewProduct(s);

                try {
                    s.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                s.setPrice(Double.parseDouble(mediumT.getText()));
                s.setSize('M');
                insertNewStickers(s);
            }
            if(large.isSelected()){

                s.setName(nameProd.getText());
                s.setImage(file.getAbsolutePath());
                insertNewProduct(s);

                try {
                    s.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                s.setPrice(Double.parseDouble(largeT.getText()));
                s.setSize('L');
                insertNewStickers(s);
            }

        }
        else if (typeProd.getValue().equals("Mug")){
            Mug m = new Mug();

            if(isMagic.isSelected()){
                m.setName(nameProd.getText());
                m.setImage(file.getAbsolutePath());
                insertNewProduct(m);

                try {
                    m.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                m.setPrice(Double.parseDouble(magicT.getText()));
                m.setMugic(isMagic.isSelected());
                insertNewMug(m);
            }
            if(notMagic.isSelected()){
                m.setName(nameProd.getText());
                m.setImage(file.getAbsolutePath());
                insertNewProduct(m);

                try {
                    m.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                m.setPrice(Double.parseDouble(notmagicT.getText()));
                m.setMugic(false);
                insertNewMug(m);
            }



        }
        else if (typeProd.getValue().equals("Pin")){
            Pin pin = new Pin();

            if(small.isSelected()){
                pin.setName(nameProd.getText());
                pin.setImage(file.getAbsolutePath());
                insertNewProduct(pin);
                try {
                    pin.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                pin.setPrice(Double.parseDouble(smallT.getText()));
                pin.setSize('S');
                insertNewPin(pin);

            }
            if(medium.isSelected()){
                pin.setName(nameProd.getText());
                pin.setImage(file.getAbsolutePath());
                insertNewProduct(pin);
                try {
                    pin.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                pin.setPrice(Double.parseDouble(mediumT.getText()));
                pin.setSize('M');
                insertNewPin(pin);
            }
            if(large.isSelected()){
                pin.setName(nameProd.getText());
                pin.setImage(file.getAbsolutePath());
                insertNewProduct(pin);
                try {
                    pin.setPid(getlastPid());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                pin.setPrice(Double.parseDouble(largeT.getText()));
                pin.setSize('L');
                insertNewPin(pin);
            }

        }
        else if (typeProd.getValue().equals("Note Book")){
            NoteBook b1 = new NoteBook();
            b1.setName(nameProd.getText());
            b1.setImage(file.getAbsolutePath());
            insertNewProduct(b1);
            try {
                b1.setPid(getlastPid());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            b1.setNumOfPaper(40);
            b1.setPrice(Double.parseDouble(pp40.getText()));
            insertNewNoteBook(b1);
            NoteBook b = new NoteBook();
            b.setName(nameProd.getText());
            b.setImage(file.getAbsolutePath());
            insertNewProduct(b);
            try {
                b.setPid(getlastPid());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            b.setNumOfPaper(80);
            b.setPrice(Double.parseDouble(pp80.getText()));
            insertNewNoteBook(b);

        }


     typeProd.getSelectionModel().clearSelection();
        nameProd.clear();

        lname.setText(" ");




    }


    @FXML
    void select(ActionEvent event) throws IOException {

        if (typeProd.getValue().equals("Mug")){
           Label l1 = new Label("Properties");
             isMagic = new CheckBox("Magic");
            isMagic.setSelected(true);
            isMagic.setStyle("-fx-background-color: #C656D1");
            isMagic.setStyle("-fx-focus-color: #C656D1");
             magicT = new TextField(mp[0]);
            magicT.setStyle("-fx-background-radius :20px;-fx-focus-color: #d04d9c ");
            magicT.setMaxWidth(40);
            magicT.disableProperty().set(false);
            isMagic.setOnAction(e -> {
                if(!isMagic.isSelected()){
                    magicT.setText(" ");
                    magicT.disableProperty().set(true);
                }
                else{
                    magicT.setText(mp[0]);
                    magicT.disableProperty().set(false);
                }
            });
            HBox mag = new HBox();
            mag.getChildren().addAll(isMagic,magicT);
            mag.setSpacing(15);
//            ---------------
             notMagic = new CheckBox("Normal");
            notMagic.setSelected(true);
            notMagic.setStyle("-fx-background-color: #C656D1");
            notMagic.setStyle("-fx-focus-color: #C656D1");
             notmagicT = new TextField(mp[1]);
            notmagicT.setStyle("-fx-background-radius :20px;-fx-focus-color: #d04d9c ");
            notmagicT.setMaxWidth(40);
            notmagicT.disableProperty().set(false);
            notMagic.setOnAction(e -> {
                if(!notMagic.isSelected()){
                    notmagicT.setText(" ");
                    notmagicT.disableProperty().set(true);
                }
                else{
                    notmagicT.setText(mp[1]);
                    notmagicT.disableProperty().set(false);
                }
            });
            HBox nmag = new HBox();
            nmag.getChildren().addAll(notMagic,notmagicT);
            nmag.setSpacing(10);

            VBox m = new VBox();
            m.getChildren().addAll(mag,nmag);
            m.setSpacing(10);

            p.getChildren().clear();
            p.getChildren().addAll(l1,m);
            p.setSpacing(50);
            vb1.getChildren().add(p);

        }
        else if (typeProd.getValue().equals("Stickrs")){
            p.getChildren().clear();
            Label l1 = new Label("size ");
            HBox smallB = new HBox();
            HBox mediumB = new HBox();
            HBox largeB = new HBox();
             small = new CheckBox("S");
            small.setSelected(true);

             smallT = new TextField(sp[0]);
            smallT.setMaxWidth(40);
            smallT.disableProperty().set(!small.isSelected());
            small.setOnAction(e -> {
                if(!small.isSelected()){
                    smallT.setText(" ");
                    smallT.disableProperty().set(true);
                }
                else{
                    smallT.setText(sp[0]);
                    smallT.disableProperty().set(false);
                }
            });
            smallB.getChildren().addAll(small,smallT);
            smallB.setSpacing(11);
            small.setStyle("-fx-focus-color: #C656D1");
            smallT.setStyle("-fx-background-radius :20px");
            smallT.setStyle("-fx-focus-color: #d04d9c");
             medium = new CheckBox("M");
            medium.setSelected(true);
            medium.setStyle("-fx-focus-color: #C656D1");
             mediumT = new TextField(sp[1]);
            mediumT.disableProperty().set(!medium.isSelected());
            medium.setOnAction(e -> {
                if(!medium.isSelected()){
                    mediumT.setText(" ");
                    mediumT.disableProperty().set(true);
                }
                else{
                    mediumT.setText(sp[1]);
                    mediumT.disableProperty().set(false);
                }
            });
            mediumT.setMaxWidth(40);
            mediumB.getChildren().addAll(medium,mediumT);
            mediumB.setSpacing(10);
            mediumT.setStyle("-fx-background-radius :20px");
            mediumT.setStyle("-fx-focus-color: #d04d9c");
             large = new CheckBox("L");
            large.setSelected(true);
            large.setStyle("-fx-focus-color: #C656D1");
             largeT = new TextField(sp[2]);
            largeT.disableProperty().set(!large.isSelected());
            large.setOnAction(e -> {
                if(!large.isSelected()){
                    largeT.setText(" ");
                    largeT.disableProperty().set(true);
                }

                else{
                    largeT.setText(sp[2]);
                    largeT.disableProperty().set(false);
                }


            });
            largeT.setStyle("-fx-background-radius :20px");
            largeT.setStyle("-fx-focus-color: #d04d9c");
            largeT.setMaxWidth(40);
            largeB.getChildren().addAll(large,largeT);
            largeB.setSpacing(11);
            VBox sizeVbox = new VBox();
            sizeVbox.getChildren().addAll(smallB,mediumB,largeB);
            sizeVbox.setSpacing(5);
            p.getChildren().addAll(l1,sizeVbox);
            p.setSpacing(20);
            vb1.getChildren().add(p);

        }
        else if (typeProd.getValue().equals("Pin")){
            p.getChildren().clear();
            Label l1 = new Label("size ");
            HBox smallB = new HBox();
            HBox mediumB = new HBox();
            HBox largeB = new HBox();
             small = new CheckBox("S");
            small.setSelected(true);
             smallT = new TextField(pricepin[0]);
            smallT.setMaxWidth(40);
            smallT.disableProperty().set(!small.isSelected());
            small.setOnAction(e -> {
                if(!small.isSelected()){
                    smallT.setText(" ");
                    smallT.disableProperty().set(true);
                }
                else{
                    smallT.setText(pricepin[0]);
                    smallT.disableProperty().set(false);
                }
            });
            smallB.getChildren().addAll(small,smallT);
            smallB.setSpacing(11);
            small.setStyle("-fx-focus-color: #C656D1");
            smallT.setStyle("-fx-background-radius :20px");
            smallT.setStyle("-fx-focus-color: #d04d9c");
             medium = new CheckBox("M");
            medium.setSelected(true);
            medium.setStyle("-fx-focus-color: #C656D1");
             mediumT = new TextField(pricepin[1]);
            mediumT.disableProperty().set(!small.isSelected());
            medium.setOnAction(e -> {
                if(!medium.isSelected()){
                    mediumT.setText(" ");
                    mediumT.disableProperty().set(true);
                }
                else{
                    mediumT.setText(pricepin[1]);
                    mediumT.disableProperty().set(false);
                }
            });
            mediumT.setMaxWidth(40);
            mediumB.getChildren().addAll(medium,mediumT);
            mediumB.setSpacing(10);
            mediumT.setStyle("-fx-background-radius :20px");
            mediumT.setStyle("-fx-focus-color: #d04d9c");
             large = new CheckBox("L");
            large.setSelected(true);
            large.setStyle("-fx-focus-color: #C656D1");
             largeT = new TextField(pricepin[2]);
            largeT.disableProperty().set(!large.isSelected());
            large.setOnAction(e -> {
                if(!large.isSelected()){
                    largeT.setText(" ");
                    largeT.disableProperty().set(true);
                }

                else{
                    largeT.setText(pricepin[2]);
                    largeT.disableProperty().set(false);
                }


            });
            largeT.setStyle("-fx-background-radius :20px");
            largeT.setStyle("-fx-focus-color: #d04d9c");
            largeT.setMaxWidth(40);
            largeB.getChildren().addAll(large,largeT);
            largeB.setSpacing(11);
            VBox sizeVbox = new VBox();
            sizeVbox.getChildren().addAll(smallB,mediumB,largeB);
            sizeVbox.setSpacing(5);
            p.getChildren().addAll(l1,sizeVbox);
            p.setSpacing(20);


        }
        else if (typeProd.getValue().equals("Note Book")){
            p.getChildren().clear();

            Label price = new Label("Price");
            Label peper40 = new Label("#40 peper ");
            Label peper80 = new Label("#80 peper ");
             pp40 = new TextField(pricenote[0]);
             pp80 = new TextField(pricenote[1]);
            HBox p40 = new HBox();
            p40.getChildren().addAll(peper40,pp40);
            p40.setSpacing(10);
            HBox p80 = new HBox();
            p80.getChildren().addAll(peper80,pp80);
            p80.setSpacing(10);
            pp40.setStyle("-fx-background-radius :20px");
            pp40.setStyle("-fx-focus-color: #d04d9c");
            pp40.setMaxWidth(40);
            pp80.setStyle("-fx-background-radius :20px");
            pp80.setStyle("-fx-focus-color: #d04d9c");
            pp80.setMaxWidth(40);
            VBox pn= new VBox();
            pn.getChildren().addAll(p40,p80);
            pn.setSpacing(20);
            p.getChildren().addAll(price,pn);
            p.setSpacing(30);


        }




        else{
            p.getChildren().clear();
        }

        vb1.getChildren().add(p);

    }

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        try {

            getPriceStickers();
            getPriceMug();
            getPricePin();
            getPriceNoteBook();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        typeProd.setItems(FXCollections.observableArrayList("Stickrs","Mug","Pin","Note Book"));
    }
    public void insertNewProduct(Product p) {

        try {

            connect2DB();
            comandSQL("Insert into Product ( Name, image) values" +
                    "('"+p.getName()+"',"+  "LOAD_FILE('"+p.getImage() +"'))");

            conect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void insertNewMug(Mug m) {

        try {

            connect2DB();
            comandSQL("Insert into Mug ( Pid, isMageic,price) values" +
                    "("+m.getPid()+","+m.isMugic()+","+m.getPrice()+")");

            conect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertNewStickers(Stickers s) {

        try {
            connect2DB();
            comandSQL("Insert into sticker ( Pid, size,price) values" +
                    "("+s.getPid()+",'"+s.getSize()+"',"+s.getPrice()+")");

            conect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void insertNewPin(Pin s) {

        try {
            connect2DB();
            comandSQL("Insert into Pin ( Pid, size,price) values" +
                    "("+s.getPid()+",'"+s.getSize()+"',"+s.getPrice()+")");

            conect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertNewNoteBook(NoteBook b) {

        try {
            connect2DB();
            comandSQL("Insert into NoteBook ( Pid, numberofpage,price) values" +
                    "("+b.getPid()+","+b.getNumOfPaper()+","+b.getPrice()+")");

            conect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getlastPid() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL="select max(p.Pid) from Product p;";
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



    public void getPriceStickers() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select distinct price from sticker s where s.pid<1000";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        int i=0;
        while ( rs.next() ){
            String s1=rs.getString(1);
            sp[i]= s1;
            i++;
        }

        rs.close();
        s.close();
        conect.close();

    }
    public void getPriceMug() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select distinct price from Mug m where m.pid<1000";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        int i=0;
        while ( rs.next() ){
            String s1=rs.getString(1);
            mp[i]= s1;
            i++;
        }

        rs.close();
        s.close();
        conect.close();

    }
    public void getPricePin() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select distinct price from pin p where p.pid<1000";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        int i=0;
        while ( rs.next() ){
            String s1=rs.getString(1);
            pricepin[i]= s1;
            i++;
        }
        rs.close();
        s.close();
        conect.close();

    }



    public void getPriceNoteBook() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select distinct price from notebook p where p.pid<1000";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        int i=0;
        while ( rs.next() ){
            String s1=rs.getString(1);
            pricenote[i]= s1;
            i++;
        }
        rs.close();
        s.close();
        conect.close();

    }
}
