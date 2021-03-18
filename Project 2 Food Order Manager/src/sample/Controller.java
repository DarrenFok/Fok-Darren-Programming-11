package sample;


import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    //Order Management Fields
    public ListView<Order> overallList;
    public Button viewOrder;
    public Button shipOrder;
    public Button saveButton;
    public Button loadButton;

    //View Your Order Fields
    public Label selectedOrder;
    public Label viewSelectedOrder;

    //Create Your Order Tab Fields
    public ListView<Item> createOrderList = new ListView<>();
    public Button cheeseburger;
    public Button softdrink;
    public Button csandiwch;
    public Button fries;
    public Button removeItem;
    public Button removeAll;
    public Button createOrder;
    public TextField nameOrder;

    //Requires: nothing
    //Modifies: Labels selectOrder and viewSelectedOrder
    //Effects: Changes text in labels to display name and contents of order.
    public void viewOrder(MouseEvent mouseEvent) {

        //Set name of selected order
        selectedOrder.setText(overallList.getSelectionModel().getSelectedItem().getName());

        //Display ordered items by setting text
        String order = overallList.getSelectionModel().getSelectedItem().getItems();
        for(int i = 0; i < order.length(); i++){
            if(order.substring(i).equals("\n"));
                order.substring(i).replace("\n", "\n");
        }
        viewSelectedOrder.setText(order);
    }

    //Requires: nothing
    //Modifies: ListView overallList
    //Effects: Removes and "ships" order from overallList
    public void shipOrder(MouseEvent mouseEvent) {
        Order remove = overallList.getSelectionModel().getSelectedItem();
        overallList.getItems().remove(remove);
    }

    //Requires: nothing
    //Modifies: ListView createOrderList
    //Effects: Adds a cheeseburger item to createOrderList
    public void addCheeseburger(MouseEvent mouseEvent) {
        String name = "Cheeseburger";
        Item cheeseburger = new Item(name);
        createOrderList.getItems().add(cheeseburger);
    }

    //Requires: nothing
    //Modifies: ListView createOrderList
    //Effects: Adds a soft drink item to createOrderList
    public void addSoftdrink(MouseEvent mouseEvent) {
        String name = "Soft Drink";
        Item softDrink = new Item(name);
        createOrderList.getItems().add(softDrink);
    }

    //Requires: nothing
    //Modifies: ListView createOrderList
    //Effects: adds a Chicken Sandwich item to createOrderList
    public void addCsandwich(MouseEvent mouseEvent) {
        String name = "Chicken Sandwich";
        Item cSandwich = new Item(name);
        createOrderList.getItems().add(cSandwich);
    }

    //Requires: nothing
    //Modifies: ListView createOrderList
    //Effects: adds a fries item to createOrderList
    public void addFries(MouseEvent mouseEvent) {
        String name = "Fries";
        Item fries = new Item(name);
        createOrderList.getItems().add(fries);
    }

    //Requires: nothing
    //Modifies: ListView createOrderList
    //Effects: removes one selected item from createOrderList
    public void removeItem(MouseEvent mouseEvent) {
        Item remove;
        remove = (Item) createOrderList.getSelectionModel().getSelectedItem();
        createOrderList.getItems().remove(remove);
    }

    //Requires: nothing
    //Modifies: ListView createOrderList
    //Effects: removes all items from createOrderList
    public void removeAll(MouseEvent mouseEvent) {
        createOrderList.getItems().clear();
    }

    //Requires: nothing
    //Modifies: ListView createOrderList and ListView overallList
    //Effects: Stores items within createOrderList into an object Order and adds that Order to overallList
    public void confirmOrder(MouseEvent mouseEvent) throws IOException {
        //Name order and transfer all items within listView into an Order
        String name = nameOrder.getText();
        if(createOrderList.getItems().isEmpty()) {
            System.out.println("ERROR, ORDER LIST IS EMPTY");
        }
        else if(compareOrder(name, "orders.txt")){
            System.out.println("ERROR, ORDER IS ALREADY IN SET");
        }
        else{
            //Add items from the createOrderList into the new list
            String tempList = "";
            for(int i = 0; i < createOrderList.getItems().size(); i++)
                tempList += (createOrderList.getItems().get(i) + " " + "\n");

            //Create new object Order and take the new list and put it in in the new Order
            Order tempOrder = new Order(name, tempList);

            //Add the order to the overall list of orders
            overallList.getItems().add(tempOrder);

            //Clear everything within the temporary createOrderList
            createOrderList.getItems().clear();

            //Clear everything within the text field
            nameOrder.clear();
        }

    }
    //Requires: Nothing
    //Modifies: orders.txt
    //Effects: Saves contents of ListView overallList to orders.txt
    public void saveToFile(MouseEvent mouseEvent) throws IOException {
        ObservableList<Order> myList = overallList.getItems();
        for(Order o : myList){
            o.writeToFile();
        }
        overallList.getItems().clear();
    }

    //Requires: Nothing
    //Modifies: Nothing
    //Effects: loads from orders.txt
    public void loadFile(MouseEvent mouseEvent) throws IOException {
        overallList.getItems().clear();
        ArrayList<Order> orders = CreateOrder.createAllOrders("orders.txt");
        for (Order o : orders) {
            overallList.getItems().add(o);
        }
    }

    //Requires: String newOrderName, String fileName
    //Modifies: File orders.txt
    //Effects: Checks if newOrderName is a duplicate in the file.
    public boolean compareOrder(String newOrderName, String fileName) throws IOException{
        // Start a new fileReader to read the specified fileName
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null) {
            // Determine if any line is a duplicate, then return true.
            if(line.equals(newOrderName)){
                System.out.println("ERROR LIST NAME IS DUPLICATE");
                br.close();
                return true;
            }
        }
        br.close();
        // Else, return false
        return false;
    }
}
