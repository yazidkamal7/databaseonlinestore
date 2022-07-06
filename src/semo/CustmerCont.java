package semo;

import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.*;
import java.util.function.UnaryOperator;

import static java.lang.System.currentTimeMillis;

public class CustmerCont extends Controller {

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField phone;

    @FXML
    private TextField social;

    @FXML
    private ChoiceBox<String> cityid;

    @FXML
    private TextField town;

    @FXML
    private TextArea street;

    @FXML
    private JFXButton sbtid;



    @FXML
    void SubmitOrder(ActionEvent event) {
        Custmer c = new Custmer();
        c.setName(firstname.getText()+" "+lastname.getText());
        c.setCuid(customerid());
        c.setPhonenumber(phone.getText());
        c.setSocialAccount(social.getText());
        c.setAdress((cityid.getValue()+" "+town.getText()+" "+ street.getText()));

        insertNewCustmer(c);
        clearTextFileds();



    }

    private String customerid (){
        return (""+firstname.getText().charAt(0)+lastname.getText().charAt(0)+cityid.getValue().charAt(0)+
                town.getText().charAt(0)+phone.getText().charAt(8)+phone.getText().charAt(9)).toUpperCase();
    }

//    for enter in phone textfelid just number and 10 char (from number)
    void phoneFormat(){
        phone.setTextFormatter(new TextFormatter<Object>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                change.setText(change.getText().replaceAll("[^0-9]",""));
                return change;
            }
        }));
        phone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (phone.getText().length() > 10) {
                    String s = phone.getText().substring(0, 10);
                    phone.setText(s);
                }
            }
        });
    }
    //for disable submet Button order for user fill a data
    private void disableSubmetButton() {
        BooleanBinding disable = new BooleanBinding() {
            {
                super.bind(firstname.textProperty(),lastname.textProperty(),phone.textProperty(),social.textProperty(),
                        town.textProperty());
            }
            @Override
            protected boolean computeValue() {
                return (firstname.getText().isEmpty() || lastname.getText().isEmpty() || social.getText().isEmpty()
                        || phone.getText().isEmpty()  || town.getText().isEmpty()) ;
            }
        };
        sbtid.disableProperty().bind(disable);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phoneFormat();

        cityid.setItems(FXCollections.observableArrayList("Ramallah","Jerusalem", "Nablus", "Tulkarm", "Tubas",
                "Qalqilya", "Salfit", "Jericho", "Bethlehem", "Hebron", "Jenin"));

        disableSubmetButton();

    }
     void clearTextFileds(){
        firstname.clear();
        lastname.clear();
        phone.clear();
        social.clear();
        town.clear();
        street.clear();
        cityid.getSelectionModel().clearSelection();
     }

}
