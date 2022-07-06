package semo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CartStrickes extends CustmerProdVeiw{
    @FXML
    private Label slname;

    @FXML
    private RadioButton ssmal;

    @FXML
    private ToggleGroup Size;

    @FXML
    private RadioButton smed;

    @FXML
    private RadioButton slarge;

    @FXML
    private Spinner<Integer> amountspn;

    String[] pricsst=new String[3];

    @FXML
    private Label sLprice;
    int q;
    int pd;
    double priest;
    @FXML
     void addtoCart(ActionEvent event) {
        q =amountspn.getValueFactory().getValue();
        pd=0;
        if(slarge.isSelected()){
            try {
                pd= getpid('L');
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else if (smed.isSelected()){
            try {
                pd= getpid('M');
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else if(ssmal.isSelected()){
            try {
                pd= getpid('S');
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        insert2Cart(lastolid,pd,q,priest);

    }
    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        System.out.println(getButtonname());
        try {
            getStickerData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


            slname.setText(getButtonname());
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);


        amountspn.setValueFactory(valueFactory);
        try {
            getStickerData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void choiceLarge(ActionEvent event) {
        q =amountspn.getValueFactory().getValue();
        priest= Double.parseDouble((pricsst[2]))*q;
        sLprice.setText(String.valueOf(priest));
    }

    @FXML
    void choiceMedium(ActionEvent event) {
        q =amountspn.getValueFactory().getValue();
        priest= Double.parseDouble((pricsst[1]))*q;
        sLprice.setText(String.valueOf(priest));
    }

    @FXML
    void choiceSmall(ActionEvent event) {
        q =amountspn.getValueFactory().getValue();
        priest= Double.parseDouble((pricsst[0]))*q;
       sLprice.setText(String.valueOf(priest));
    }

    public void insert2Cart(int ol,int pid,int q,double p) {

        try {

            connect2DB();
            comandSQL("Insert into orderline (ol, pid, quantity,price) values" +
                    "("+ol+","+pid+","+q+","+p+")");

            conect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    void getStickerData() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select s.price from product p , sticker s  where s.pid=p.pid And s.pid >=1000 And p.name ='" + getButtonname() + "'order by s.pid , s.size desc";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        int i = 0;
        while (rs.next()) {
            String s1 = rs.getString(1);
            pricsst[i] = s1;
            i++;

        }
    }
    int getpid(char size) throws SQLException, ClassNotFoundException {
        int pid = 0;
        connect2DB();
        String statmentSQL;
        statmentSQL = "select s.pid from product p , sticker s  where s.pid=p.pid And s.pid >=1000 And p.name ='" + getButtonname() + "'And s.size='" + size + "'order by s.pid , s.size desc";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        int i = 0;
        while (rs.next()) {
            String s1 = rs.getString(1);
            pid = Integer.parseInt(s1);
            i++;
        }
        return pid;
    }
}
