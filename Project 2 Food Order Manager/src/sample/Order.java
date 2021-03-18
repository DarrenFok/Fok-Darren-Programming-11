package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    //Write to file
    public void writeToFile() throws IOException{
        FileWriter fw = new FileWriter("orders.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(items.toString() + "\r");
        bw.write(";\r");
        bw.close();
    }
}
