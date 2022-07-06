package semo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class ProductController extends Controller {
    @FXML
    private TableView<Stickers> StickerTable;

    @FXML
    private TableColumn<Stickers, Integer> sid;

    @FXML
    private TableColumn<Stickers, String> sname;

    @FXML
    private TableColumn<Stickers, Character> ssize;

    @FXML
    private TableColumn<Stickers, String> sprice;

    @FXML
    private TableColumn<Stickers, String> simage;

    @FXML
    private TableView<Pin> PinTable;

    @FXML
    private TableColumn<Pin, Integer> Pid;

    @FXML
    private TableColumn<Pin, String> pname;

    @FXML
    private TableColumn<Pin, Character> psize;

    @FXML
    private TableColumn<Pin, Double> pprice;

    @FXML
    private TableColumn<Pin, String> pimage;
    @FXML
    private TableView<Mug> MugTable;

    @FXML
    private TableColumn<Mug, Integer> mid;

    @FXML
    private TableColumn<Mug, String> mname;

    @FXML
    private TableColumn<Mug, Boolean> isMagic;

    @FXML
    private TableColumn<Mug, Double> mprice;

    @FXML
    private TableColumn<Mug, String> mimage;

    @FXML
    private TableView<NoteBook> NoteBookTable;

    @FXML
    private TableColumn<NoteBook, Integer> nid;

    @FXML
    private TableColumn<NoteBook, String> nname;

    @FXML
    private TableColumn<NoteBook, Integer> numOfpage;

    @FXML
    private TableColumn<NoteBook, Double> nprice;

    @FXML
    private TableColumn<NoteBook, String> nimage;
    @FXML
    private TableView<PhoneCase> PhoneCaseTable;

    @FXML
    private TableColumn<PhoneCase, Integer> phid;

    @FXML
    private TableColumn<PhoneCase, String> phname;

    @FXML
    private TableColumn<PhoneCase, String> phonemodelc;

    @FXML
    private TableColumn<PhoneCase,Double> phprice;

    @FXML
    private TableColumn<PhoneCase, String> phimage;
    @FXML
    private TextField ssp;

    @FXML
    private TextField smp;

    @FXML
    private TextField slp;

    ArrayList<Stickers> StickerList = new ArrayList<>();
    ObservableList<Stickers> stl;
    ArrayList<Pin> pinlist = new ArrayList<>();
    ObservableList<Pin> pnl;
    ArrayList<Mug> muglist = new ArrayList<>();
    ObservableList<Mug> mgl;
    ArrayList<NoteBook> notelist = new ArrayList<>();
    ObservableList<NoteBook> nbl;
    ArrayList<PhoneCase> phonelist = new ArrayList<>();
    ObservableList<PhoneCase> phl;

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        StickersTableVeiw();
        PinTableVeiw();
        MugTableVeiw();
        NoteBookTableVeiw();


    }

    void StickersTableVeiw() {
        try {
            getStickerData();
            stl = FXCollections.observableArrayList(StickerList);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        StickerTable.setItems(stl);
        sid.setCellValueFactory(new PropertyValueFactory<Stickers, Integer>("pid"));
        sname.setCellValueFactory(new PropertyValueFactory<Stickers, String>("name"));
        ssize.setCellValueFactory(new PropertyValueFactory<Stickers, Character>("size"));
        sprice.setCellValueFactory(new PropertyValueFactory<Stickers, String>("price"));
        simage.setCellValueFactory(new PropertyValueFactory<Stickers, String>("image"));




    }

     void getStickerData() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select s.pid,p.name,s.size,s.price,p.image from product p , sticker s  where s.pid=p.pid And s.pid>= 1000 order by s.pid , s.size desc";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        while (rs.next()) {
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString(3);
            String s4 = rs.getString(4);
            String s5 = rs.getString(5);
            Stickers st = new Stickers();
            st.setPid(Integer.parseInt(s1));
            st.setName(s2);
            st.setSize(s3.charAt(0));
            st.setPrice(Double.parseDouble(s4));
            st.setImage(s5);
            StickerList.add(st);

        }

        rs.close();
        s.close();
        conect.close();

    }
    void PinTableVeiw() {

        try {

            getPinDATA();
            pnl = FXCollections.observableArrayList(pinlist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PinTable.setItems(pnl);

        Pid.setCellValueFactory(new PropertyValueFactory<Pin, Integer>("pid"));
        pname.setCellValueFactory(new PropertyValueFactory<Pin, String>("name"));
        psize.setCellValueFactory(new PropertyValueFactory<Pin, Character>("size"));
        pprice.setCellValueFactory(new PropertyValueFactory<Pin, Double>("price"));
        pimage.setCellValueFactory(new PropertyValueFactory<Pin, String>("image"));


    }
   public void getPinDATA() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select pn.pid,p.name,pn.size,pn.price,p.image from product p , pin pn  where pn.pid=p.pid And pn.pid >=1000 order by pn.pid , pn.size desc";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        while (rs.next()) {
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString(3);
            String s4 = rs.getString(4);
            String s5 = rs.getString(5);
            Pin pn = new Pin();
            pn.setPid(Integer.parseInt(s1));
            pn.setName(s2);
            pn.setSize(s3.charAt(0));
            pn.setPrice(Double.parseDouble(s4));
            pn.setImage(s5);
            pinlist.add(pn);

        }

        rs.close();
        s.close();
        conect.close();

    }
    public void getMugData() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select m.pid,p.name,m.isMageic,m.price,p.image from product p , mug m  where m.pid=p.pid And m.pid >=1000 order by m.pid";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        while (rs.next()) {
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString(3);
            String s4 = rs.getString(4);
            String s5 = rs.getString(5);
            Mug m = new Mug();
            m.setPid(Integer.parseInt(s1));
            m.setName(s2);
            if(s3.equals("0")){
                m.setMugic(false);
            }
            else
                m.setMugic(true);

            m.setPrice(Double.parseDouble(s4));
            m.setImage(s5);
            muglist.add(m);

        }

        rs.close();
        s.close();
        conect.close();

    }
    void MugTableVeiw() {
        try {
            getMugData();
            mgl = FXCollections.observableArrayList(muglist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        MugTable.setItems(mgl);

        mid.setCellValueFactory(new PropertyValueFactory<Mug, Integer>("pid"));
        mname.setCellValueFactory(new PropertyValueFactory<Mug, String>("name"));
        isMagic.setCellValueFactory(new PropertyValueFactory<Mug, Boolean>("Mugic"));
        mprice.setCellValueFactory(new PropertyValueFactory<Mug, Double>("price"));
        mimage.setCellValueFactory(new PropertyValueFactory<Mug, String>("image"));


    }
   public void getnotebookdata() throws SQLException, ClassNotFoundException {
        connect2DB();
        String statmentSQL;
        statmentSQL = "select n.pid,p.name,n.numberofpage,n.price,p.image from product p , notebook n  where n.pid=p.pid And n.pid >=1000 order by n.pid ";
        Statement s = conect.createStatement();
        ResultSet rs = s.executeQuery(statmentSQL);
        while (rs.next()) {
            String s1 = rs.getString(1);
            String s2 = rs.getString(2);
            String s3 = rs.getString(3);
            String s4 = rs.getString(4);
            String s5 = rs.getString(5);
            NoteBook n = new NoteBook();
            n.setPid(Integer.parseInt(s1));
            n.setName(s2);
            n.setNumOfPaper(Integer.parseInt(s3));
            n.setPrice(Double.parseDouble(s4));
            n.setImage(s5);
            notelist.add(n);

        }

        rs.close();
        s.close();
        conect.close();

    }
    void NoteBookTableVeiw() {
        try {

            getnotebookdata();
            nbl = FXCollections.observableArrayList(notelist);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        NoteBookTable.setItems(nbl);
        nid.setCellValueFactory(new PropertyValueFactory<NoteBook, Integer>("pid"));
        nname.setCellValueFactory(new PropertyValueFactory<NoteBook, String>("name"));
        numOfpage.setCellValueFactory(new PropertyValueFactory<NoteBook, Integer>("numOfPaper"));
        nprice.setCellValueFactory(new PropertyValueFactory<NoteBook, Double>("price"));
        nimage.setCellValueFactory(new PropertyValueFactory<NoteBook, String>("image"));

    }



    @FXML
    void deleteselected(ActionEvent event) {
        ObservableList<Stickers> selectedRows = StickerTable.getSelectionModel().getSelectedItems();
        ArrayList<Stickers> rows = new ArrayList<>(selectedRows);
        rows.forEach(row -> {
            StickerTable.getItems().remove(row);
            try {
                connect2DB();
                comandSQL("delete from  sticker where pid='"+row.getPid() + "' And size='"+row.getSize()+"';");
                conect.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

           StickerTable.refresh();
        });
    }

    @FXML
    void ulb(ActionEvent event) throws Exception{
            connect2DB();
            comandSQL("update  sticker set price = "+ssp.getText()+ " where size = 'S';");
            conect.close();

    }

    @FXML
    void umb(ActionEvent event) throws Exception{
        connect2DB();
        comandSQL("update  sticker set price = "+smp.getText()+ " where size = 'M'  ;");
        conect.close();
    }



    @FXML
    void usb(ActionEvent event)throws Exception {
        connect2DB();
        comandSQL("update  sticker set price = "+ssp.getText()+ " where size = 'S';");
        conect.close();
    }


}
