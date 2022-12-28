package addressbook;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static String fileNum;
    private static int t = new File("src\\main\\java\\addressbook\\AddressBook").list().length;
    Entry[] contents;

    class Entry{
        private String first;
        private String last;
        private String street;
        private String city;
        private String zip;
        private Object state;
        private String email;
        private String notes;

        Entry(String first, String last, String street, String city, String zip, Object state, String email, String notes){
            this.first = first;
            this.last = last;
            this.street = street;
            this.city = city;
            this.zip = zip;
            this.state = state;
            this.notes = notes;
            this.email = email;
        }
        Entry(){
            first = "";
            last = "";
            street = "";
            city = "";
            zip = "";
            notes = "";
            state = "";
            email = "";

        }
        public void readEntry(){
            System.out.println("First Name:"+first );
            System.out.println("Last Name:"+last );
            System.out.println("Street:"+street );
            System.out.println("City:"+city );
            System.out.println("State:"+state );
            System.out.println("Zip:"+zip );
            System.out.println("Email:"+email );
            System.out.println("Notes:"+notes );

            
        }
        public String getName()
        {
            String s = first + " " + last;
            return s;
        }
        public String Display()
        {
            return "Name: " + first + " " + last + "\nStreet: " + street + "\nCity: " + city + "\nState: " + state + "\nZIP: " + zip +
            "\nEmail: " + email + "\nNotes: \n" + notes;
        }
    }
    @Override
    public void start(Stage stage) throws IOException 
    {
        List<Entry> addressBook = new ArrayList<Entry>();
        List<String> name = new ArrayList<String>();
        ArrayList<ArrayList<String>> listOfAddresses = new ArrayList<ArrayList<String>>(); 
        ListView<String> list = new ListView<String>();
        ArrayList<String> qqq = new ArrayList<String>();
        File newFile = new File("src\\main\\java\\addressbook\\Names.txt");
        Scanner newReader = new Scanner(newFile);
        while (newReader.hasNextLine()) 
                {
                    qqq.add(newReader.nextLine());
                }
                newReader.close();

        //Reads from the files and adds them to ArrayList of ArrayLists
        for(int x = 0; x < t; x++)
        {
            ArrayList<String> ind = new ArrayList<String>();
            //name.add(qqq.get(x));
            try
            {
                File myObj = new File("src\\main\\java\\addressbook\\AddressBook\\" + qqq.get(x));
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) 
                {
                    ind.add(myReader.nextLine());
                }
                listOfAddresses.add(ind);
                myReader.close();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    
 
        fileNum = String.valueOf(t);
        System.out.println(fileNum);
        for(int q = 0; q < t; q++)
        {
        ArrayList<String> sSplit = new ArrayList<String>();
        ArrayList<String> dSplit = new ArrayList<String>();
        ArrayList<String> citSplit = new ArrayList<String>();
        ArrayList<String> stsSplit = new ArrayList<String>(); 
        ArrayList<String> zpSplit = new ArrayList<String>(); 
        ArrayList<String> emSplit = new ArrayList<String>();
        String r = "";
        String l = "";
        String n = ""; 
        String u = "";
        String m = "";
        String city2 ="";
        String zp2 ="";
        String em2 = "";
        String sts2 = "";
        String i = "";
        String cit = "";
        String sts = "";
        String zp = "";
        String em1 = "";
        String not = "";
        //gets First and Last name
        String s = listOfAddresses.get(q).get(0);
        String[] ss = s.split("\\s+");
        if(ss.length > 1)
        {
        for(int e = 0; e < ss.length; e++)
        {
            sSplit.add(ss[e]);
        }
        u = sSplit.get(1);
        m = sSplit.get(2);
        }
        System.out.println(u);
        System.out.println(m);
        
        //gets street address
        i = listOfAddresses.get(q).get(1);
        String[] dd = i.split("\\s+");
        if(dd.length > 1)
        {
        for(int e = 0; e < dd.length; e++)
        {
            dSplit.add(dd[e]);
        }
        for(int x = 1; x < dSplit.size(); x++)
        {
            r = r + dSplit.get(x) + " ";
        }
        }
        System.out.println(r);

        //gets city
        cit = listOfAddresses.get(q).get(2);
        String[] cc = cit.split("\\s+");
        if(cc.length > 1)
        {
        for(int e = 0; e < cc.length; e++)
        {
            citSplit.add(cc[e]);
        }
        city2 = citSplit.get(1);
        }
        System.out.println(city2);

        //gets state
        sts = listOfAddresses.get(q).get(3);
        String[] sss = sts.split("\\s+");
        if(sss.length > 1)
        {
        for(int e = 0; e < sss.length; e++)
        {
            stsSplit.add(sss[e]);
        }
        sts2 = stsSplit.get(1);
        }
        System.out.println(sts2);

        //gets zip
        zp = listOfAddresses.get(q).get(4);
        String[] zz = zp.split("\\s+");
        if(zz.length > 1)
        {
        for(int e = 0; e < zz.length; e++)
        {
            zpSplit.add(zz[e]);
        }
        zp2 = zpSplit.get(1);
        }
        System.out.println(zp2);

        //gets Email
        em1 = listOfAddresses.get(q).get(5);
        String[] ee = em1.split("\\s+");
        if(ee.length > 1)
        {
        for(int e = 0; e < ee.length; e++)
        {
            emSplit.add(ee[e]);
        }
        em2 = emSplit.get(1);
        }
        System.out.println(em2);

        //gets notes
        if(listOfAddresses.get(q).size() > 7)
        {
        for(int x = 7; x < listOfAddresses.get(q).size(); x++)
        {
            not = listOfAddresses.get(q).get(x); 
            n = n + not + "\n";
        }
        }   
        System.out.println(n);

        l = u + " " + m;
        name.add(l);
        addressBook.add(new Entry(u, m, r, city2, zp2, sts2, em2, n));
        list.getItems().clear();
        list.getItems().addAll(name);
        
        }
        //addressBook.add(new Entry(u, m, r, city2, zp2, sts2, em2, n));
        
        String States[] = {"AL", "AK", 
        "AZ", "AR", 
        "AS", "CA", 
        "CO", "CT", 
        "DE", "DC", 
        "FL", "GA", 
        "HI", "ID", 
        "IL", "IN", 
        "IA", "KS", 
        "KY", "LA", 
        "ME", "MD", 
        "MA", "MI", 
        "MN", "MS", 
        "MO", "MT", 
        "NE", "NV", 
        "NH", "NJ", 
        "NM", "NY", 
        "NC", "ND", 
        "OH", "OK", 
        "OR", "PA", 
        "RI", "SC", 
        "SD", "TN", 
        "TX", "UT", 
        "VT", "VA", 
        "WA", "WV", 
        "WI", "WY"};

        //Creates the different grids for the different tabs
        GridPane root = new GridPane();
        root.setHgap(8);
        root.setVgap(8);
        root.setPadding(new Insets(5));
        GridPane homePage = new GridPane();
        homePage.setHgap(8);
        homePage.setVgap(8);
        homePage.setPadding(new Insets(5));
        GridPane DeletePage = new GridPane();
        DeletePage.setHgap(8);
        DeletePage.setVgap(8);
        DeletePage.setPadding(new Insets(5));
        GridPane Address = new GridPane();
        Address.setHgap(8);
        Address.setVgap(8);
        Address.setPadding(new Insets(5));
        TabPane tabPane = new TabPane();
        VBox vBox = new VBox(tabPane);


        //Creates the different grids for the different tabs

        //Sets constraints for my grids
        ColumnConstraints horz = new ColumnConstraints();
        horz.setHgrow(Priority.NEVER);
        root.getColumnConstraints().add(horz);
        ColumnConstraints vert = new ColumnConstraints();
        vert.setHgrow(Priority.ALWAYS);

        RowConstraints rhorz = new RowConstraints();
        rhorz.setVgrow(Priority.NEVER); 
        RowConstraints rvert = new RowConstraints();
        rvert.setVgrow(Priority.ALWAYS);  

        root.getColumnConstraints().addAll(horz, vert);
        root.getRowConstraints().addAll(rhorz, rvert);
        homePage.getColumnConstraints().addAll(horz, vert);
        homePage.getRowConstraints().addAll(rhorz, rvert);
        DeletePage.getColumnConstraints().addAll(horz, vert);
        DeletePage.getRowConstraints().addAll(rhorz, rvert);
        Address.getColumnConstraints().addAll(horz, vert);
        Address.getRowConstraints().addAll(rhorz, rvert);
        //Sets constraints for my grids

        //Different fields to add to tabs
        TextField Fname = new TextField();
        TextField street = new TextField();
        TextField city = new TextField();
        TextField email = new TextField();
        TextField Lname = new TextField();
        TextField zip = new TextField();
        TextArea Info = new TextArea();
        TextArea notes = new TextArea();
        Button NewAddress = new Button("New");
        Button DeleteAddress = new Button("Delete");
        Button OpenAddress = new Button("Open");
        Button Create = new Button("Create");
        Text a = new Text("First Name:");
        Text b = new Text("Last Name:");       
        Text c = new Text("Street:");    
        Text d = new Text("City:");    
        Text e = new Text("ZIP:");       
        Text f = new Text("EMAIL:");       
        Text g = new Text("NOTES:");  
        Text h = new Text("State:");
        final Tab tab1 = new Tab("Address List");
        final Tab tab2 = new Tab("New Address ");
        final Tab tab4 = new Tab("Address");
        ChoiceBox box = new ChoiceBox(FXCollections.observableArrayList(States));
        //Different fields to add to tabs


        //Customization
        Info.setEditable(false);
        tab1.setClosable(false);
        NewAddress.setPrefSize(200, 150);
        DeleteAddress.setPrefSize(200,150);
        OpenAddress.setPrefSize(200,150);
        notes.setPrefHeight(150);
        Create.setPrefSize(300,100);
        NewAddress.getStyleClass().add("button");
        DeleteAddress.getStyleClass().add("button");
        OpenAddress.getStyleClass().add("button");
        Create.getStyleClass().add("button");
        vBox.getStyleClass().add("root");
        Info.getStyleClass().add("font");
        Fname.getStyleClass().add("font1");
        Lname.getStyleClass().add("font1");
        street.getStyleClass().add("font1");
        city.getStyleClass().add("font1");
        email.getStyleClass().add("font1");
        zip.getStyleClass().add("font1");
        notes.getStyleClass().add("font1");
        list.getStyleClass().add("font");


        //Customization


        // force the field to be numeric only 
        //got from stackoverflow and slightly modified it.
        zip.textProperty().addListener((ChangeListener<? super String>) new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
        if (!newValue.matches("\\d*")) {
            zip.setText(newValue.replaceAll("[^\\d]", ""));
        }
        }
        });
        // force the field to be numeric only 


        //(name, left-to-right, up-and-down, span left-to-right, span up-and-down)
        //Adds items to different grids
        root.add(Fname, 1, 0, 2, 1);
        root.add(Lname, 4, 0, 2, 1);
        root.add(street, 1, 1, 5, 1);
        root.add(city, 1, 2, 2, 1);
        root.add(zip, 4, 2, 2, 1);
        root.add(email, 1, 4, 5, 1);
        root.add(notes, 0, 6, 6, 1);
        root.add(a, 0,0);
        root.add(b, 3,0);
        root.add(c, 0,1);
        root.add(d, 0,2);
        root.add(e, 3,2);
        root.add(f, 0,4);
        root.add(g, 0,5);
        root.add(h,0,3);
        root.add(Create, 1, 7, 4, 3);
        root.add(box, 1, 3);
        homePage.add(list, 0, 0, 1, 3);    
        homePage.add(NewAddress, 1, 0);    
        homePage.add(DeleteAddress, 1, 1);    
        homePage.add(OpenAddress, 1, 2);
        Address.add(Info, 0, 1, 1, 2);
        tabPane.getTabs().add(tab1);
            //adds gridpane layout to specific tab
            tab1.setContent(homePage);
        //Adds items to different grids


        //opens tab when button is pressed
        EventHandler<ActionEvent> New = new EventHandler<ActionEvent>() {
             public void handle(ActionEvent e)
            {
                tabPane.getTabs().add(tab2);
                //changes to new tab when created
                tabPane.getSelectionModel().select(tab2);
                tab2.setContent(root);

                //clear all boxes
                Fname.clear();
                Lname.clear();
                street.clear();
                city.clear();
                zip.clear();
                email.clear();
                notes.clear();
                box.valueProperty().set(null);
            }
            };
        EventHandler<ActionEvent> Delete = new EventHandler<ActionEvent>() {
             public void handle(ActionEvent e)
            {

                for(int x = 0; x < addressBook.size(); x++)
                {
                    if(list.getSelectionModel().getSelectedItem().equals(addressBook.get(x).getName()))
                    {
                        File myObj = new File("src\\main\\java\\addressbook\\AddressBook\\" + addressBook.get(x).getName()); 
                        if (myObj.delete()) { 
                            System.out.println("Deleted the file: " + myObj.getName());
                            try{
                                File newFile = new File("src\\main\\java\\addressbook\\Names.txt");
                                File tempFile = new File("src\\main\\java\\addressbook\\Names.txt");
                                BufferedReader my_reader = new BufferedReader(new FileReader(newFile));
                                BufferedWriter myWriter = new BufferedWriter(new FileWriter(tempFile));
                                String lineToRemove = addressBook.get(x).getName();
                                System.out.println(lineToRemove);
                                String curLine;
                                try{
                                while ((curLine = my_reader.readLine()) != null) 
                                {
                                    String trimmed = curLine.trim();
                                    if(trimmed.equals(lineToRemove)) continue;
                                    myWriter.write(curLine + System.getProperty("line.separator")); 
                                }
                                myWriter.close();
                                my_reader.close();
                            }
                                catch(IOException f){

                                }
                                newReader.close();
                            }
                            catch(FileNotFoundException g){
                                    System.out.println("Failed to delete name from file");
                            } 
                            catch (IOException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        list.getItems().remove(list.getSelectionModel().getSelectedItem());
                        addressBook.remove(x);
                        list.getItems().clear();
                        name.remove(x);
                        list.getItems().addAll(name);
                        t--;
                        try (FileWriter newWriter = new FileWriter("src\\main\\java\\addressbook\\Names.txt")) {
                            for(int uu = 0; uu < name.size(); uu++)
                            {
                                newWriter.write(name.get(uu) + "\n");
                            }
                            newWriter.close();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        }   
                        else {
                            System.out.println("Failed to delete the file.");
                        } 
                    }
                    else
                    {
                        
                    }
                } 
                }
            
        };  
        EventHandler<ActionEvent> Open = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                if(tab4.getTabPane() != null)
                {
                    tab4.getTabPane().getTabs().remove(tab4);
                }
                String s = list.getSelectionModel().getSelectedItem();

                if(!s.equals(null))
                {
                tabPane.getTabs().add(tab4);
                tabPane.getSelectionModel().select(tab4);
                tab4.setContent(Address);
                for(int x = 0; x < addressBook.size(); x++)
                {
                    if(s.equals(addressBook.get(x).getName()))
                    {
                        Info.setText(addressBook.get(x).Display());
                        break;
                    }
                }
                s = null;
                }

            }
            };  
        EventHandler<ActionEvent> create = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            String First = Fname.getText();
            String Last = Lname.getText();
            String n = First + " " + Last;
            name.add(n);
            String Str = street.getText();
            String City = city.getText();
            String Zip = zip.getText();
            String em = email.getText();
            String note = notes.getText();
            Object states = box.getValue();

            addressBook.add(new Entry(First, Last, Str, City, Zip, states, em, note));

            list.getItems().clear();
            list.getItems().addAll(name);
            for(int x = 0; x < addressBook.size(); x++)
            {
                if(n.equals(addressBook.get(x).getName()))
                {
                File file = new File("src\\main\\java\\addressbook\\AddressBook\\" + addressBook.get(x).getName());
                try
                {
                    if(file.createNewFile())
                    {
                        System.out.println("File created: " + file.getName());
                    
                        FileWriter myWriter = new FileWriter("src\\main\\java\\addressbook\\AddressBook\\" + addressBook.get(x).getName());
                        myWriter.write(addressBook.get(t).Display());
                        myWriter.close();
                        if("src\\main\\java\\addressbook\\Names.txt".length() != 0)
                        {
                        PrintWriter pw = new PrintWriter("src\\main\\java\\addressbook\\Names.txt");
                        pw.close();
                        FileWriter newWriter = new FileWriter("src\\main\\java\\addressbook\\Names.txt");
                        for(int r = 0; r < name.size();r++)
                        {
                            newWriter.write(name.get(r) + "\n");
                        }
                        newWriter.close();
                        }
                        else
                        {
                        FileWriter newWriter = new FileWriter("src\\main\\java\\addressbook\\Names.txt");
                        newWriter.write(addressBook.get(t).getName());
                        newWriter.close();
                        }
                        t++;
                        fileNum = String.valueOf(t);
                    } 
                    else 
                    {
                        System.out.println("File already exists.");
                    }
                }
                catch(IOException g)
                {
                    System.out.println("An error occurred.");
                    g.printStackTrace();      
                }
            }
            }
            
            tab2.getTabPane().getTabs().remove(tab2);

        }
        };   


        //adds Handler to buttons
        NewAddress.setOnAction(New);
        DeleteAddress.setOnAction(Delete);
        OpenAddress.setOnAction(Open); 
        Create.setOnAction(create);      
        //adds Handler to buttons

        //Creates scene
        Scene scene = new Scene(vBox, 450, 450);
        stage.setTitle("Address Book");
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().addAll(App.class.getResource("Styles.css").toExternalForm());
        stage.show();
        //Creates scene

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}