package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order {
    //Fields
    private String name;
    private ObservableList<Item> items = FXCollections.observableArrayList();

    //Constructor
    public Order(String name, ObservableList<Item> items){
        this.name = name;
        this.items = items;
    }

    //Name getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Observable List getter and setter
    public ObservableList<Item> getItems() {
        return items;
    }

    public void setItems(ObservableList<Item> tempList) {
        this.items = tempList;
    }

    //To String Method
    public String toString() {return name;}
}
