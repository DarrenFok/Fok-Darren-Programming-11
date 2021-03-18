package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Order{
    //Fields
    private String name;
    private List<Item> items;

    //Constructor
    public Order(){
    }

    public Order(String name, List<Item> items){
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
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> tempList) {
        this.items = tempList;
    }

    //To String Method
    public String toString() {return name;}
}
