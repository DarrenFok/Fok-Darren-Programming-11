package sample;


import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    //Order Management Tab Methods
    public void viewOrder(MouseEvent mouseEvent) {

        //Set name of selected order
        selectedOrder.setText(overallList.getSelectionModel().getSelectedItem().getName());

        //Display ordered items by setting text
        String order = "";
        for(int i = 0; i < overallList.getSelectionModel().getSelectedItem().getItems().size(); i++){
            order += overallList.getSelectionModel().getSelectedItem().getItems().get(i) + "\n";
        }
        viewSelectedOrder.setText(order);
    }

    public void shipOrder(MouseEvent mouseEvent) {
        Order remove = overallList.getSelectionModel().getSelectedItem();
        overallList.getItems().remove(remove);
    }

    //Create Your Order Tab Methods
    public void addCheeseburger(MouseEvent mouseEvent) {
        String name = "Cheeseburger";
        Item cheeseburger = new Item(name);
        createOrderList.getItems().add(cheeseburger);
    }

    public void addSoftdrink(MouseEvent mouseEvent) {
        String name = "Soft Drink";
        Item softDrink = new Item(name);
        createOrderList.getItems().add(softDrink);
    }

    public void addCsandwich(MouseEvent mouseEvent) {
        String name = "Chicken Sandwich";
        Item cSandwich = new Item(name);
        createOrderList.getItems().add(cSandwich);
    }

    public void addFries(MouseEvent mouseEvent) {
        String name = "Fries";
        Item fries = new Item(name);
        createOrderList.getItems().add(fries);
    }

    public void removeItem(MouseEvent mouseEvent) {
        Item remove;
        remove = (Item) createOrderList.getSelectionModel().getSelectedItem();
        createOrderList.getItems().remove(remove);
    }

    public void removeAll(MouseEvent mouseEvent) {
        createOrderList.getItems().clear();
    }

    public void confirmOrder(MouseEvent mouseEvent) {
        //Name order and transfer all items within listView into an Order
        String name = nameOrder.getText();
        if(createOrderList.getItems().isEmpty())
            System.out.println("ERROR, ORDER LIST IS EMPTY");
        else{
            //Add items from the createOrderList into the new list
            List<Item> tempList = new ArrayList<Item>();
            for(int i = 0; i < createOrderList.getItems().size(); i++)
                tempList.add(createOrderList.getItems().get(i));

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
    //Writing to file methods
    public void saveToFile(MouseEvent mouseEvent) throws IOException {
        ObservableList<Order> myList = overallList.getItems();
        for(Order o : myList){
            o.writeToFile();
        }
        overallList.getItems().clear();
    }


    public void loadFile(MouseEvent mouseEvent) throws IOException {
        overallList.getItems().clear();
        ArrayList<Order> orders = CreateOrder.createAllOrders("orders.txt");
        for(Order o : orders){
            overallList.getItems().add(o);
        }
    }
}
