package sample;

public class Item {
    //Fields
    private String name;

    //Constructor
    Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //To String Method
    public String toString() {return name;}
}
