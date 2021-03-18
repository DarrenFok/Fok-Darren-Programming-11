package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.util.List;

public class Controller {
    //Order Management Fields
    public ListView<Order> overallList;
    public Button viewOrder;
    public Button shipOrder;

    //View Your Order Fields
    public ListView<Item> viewList;

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
        //Clear viewList
        viewList.getSelectionModel().getSelectedItems().clear();

        //Transfer selected Order's list's items to viewList
        List<Item> tempList = overallList.getSelectionModel().getSelectedItem().getItems();
        for(int i = 0; i < tempList.size(); i++){
            viewList.getItems().add(tempList.get(i));
        }

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
            List<Item> tempList = createOrderList.getItems();

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
}
