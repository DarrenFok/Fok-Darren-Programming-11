package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Order{
    //Fields
    private String name;
    private String items;

    //Constructor
    public Order(){
    }

    public Order(String name, String items){
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
    public String getItems() {
        return items;
    }

    public void setItems(String tempList) {
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
