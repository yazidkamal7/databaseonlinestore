package semo;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminController extends Controller {

    @FXML
    public TableView<Custmer> tableveiw;

    @FXML
    private TableColumn<Custmer, String> cuidCol;

    @FXML
    private TableColumn<Custmer, String> nameCol;

    @FXML
    private TableColumn<Custmer, String> phoneCol;

    @FXML
    private TableColumn<Custmer, String> socialCol;

    @FXML
    private TableColumn<Custmer, String> adressCol;


    @FXML
    void addProd(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form/addProduct.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(icon);
            stage.setTitle("ADD PRODUCT");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addnew(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("form/adminadd.fxml"));
            Stage stagec = new Stage();
            stagec.setScene(new Scene(root));
            stagec.getIcons().add(icon);
            stagec.setTitle("Add new Customer");
            stagec.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void delete(ActionEvent event) {
        ObservableList<Custmer> selectedRows = tableveiw.getSelectionModel().getSelectedItems();
        ArrayList<Custmer> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            tableveiw.getItems().remove(row);
            try {
                connect2DB();
                comandSQL("delete from  custmer where cuid='"+row.getCuid() + "';");
                conect.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            tableveiw.refresh();
        });

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getDataCust();
            custmersList = FXCollections.observableArrayList(newCustmer);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        for (Custmer i : newCustmer) {
//            System.out.println(i.toString());
//        }
//        System.out.println("--------------");

        tableveiw.setItems(custmersList);

        cuidCol.setCellValueFactory(new PropertyValueFactory<Custmer, String>("cuid"));

        nameCol.setCellValueFactory(new PropertyValueFactory<Custmer, String>("name"));

        phoneCol.setCellValueFactory(new PropertyValueFactory<Custmer ,String>("phonenumber"));

        socialCol.setCellValueFactory(new PropertyValueFactory<Custmer, String>("socialAccount"));

        adressCol.setCellValueFactory(new PropertyValueFactory<Custmer, String>("adress"));

        nameCol.setCellFactory(TextFieldTableCell.<Custmer>forTableColumn());
        nameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Custmer, String> t) -> {
                    ((Custmer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue());
                    try {
                        edit(t.getRowValue().getCuid(),t.getNewValue(),"cname");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });

        phoneCol.setCellFactory(TextFieldTableCell.<Custmer>forTableColumn());
        phoneCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Custmer, String> t) -> {
                    ((Custmer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhonenumber(t.getNewValue());
                    try {
                        edit( t.getRowValue().getCuid(),t.getNewValue(),"phonenumber");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
        socialCol.setCellFactory(TextFieldTableCell.<Custmer>forTableColumn());
        socialCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Custmer, String> t) -> {
                    ((Custmer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhonenumber(t.getNewValue());
                    try {
                        edit( t.getRowValue().getCuid(),t.getNewValue(),"socialacc");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
        adressCol.setCellFactory(TextFieldTableCell.<Custmer>forTableColumn());
        adressCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Custmer, String> t) -> {
                    ((Custmer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhonenumber(t.getNewValue());
                    try {
                        edit( t.getRowValue().getCuid(),t.getNewValue(),"address");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });


    }

    private void edit(String cuid, String newValue,String row) throws SQLException, ClassNotFoundException {
        connect2DB();
        comandSQL("update custmer set "+row+" = '"+newValue+ "' where cuid = '"+cuid+"';");
        conect.close();

    }
    @FXML
    void refersh(ActionEvent event) {
        tableveiw.refresh();
    }

    @FXML
    void productVeiw(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("Form/productVeiw.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.getIcons().add(icon);
            stage.setTitle("Admin");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void reportData(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("Form/report.fxml"));
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
