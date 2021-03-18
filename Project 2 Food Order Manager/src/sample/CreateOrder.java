package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CreateOrder {
    private static String name;
    private static List<Item> items;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Order> orders = new ArrayList<>();

    public static ArrayList createAllOrders(String fileName) throws IOException{
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String orderString = "";
        while((line = br.readLine()) != null){
            if(!line.equals(";")){
                orderString += line;
            }
            else{
                parseOrder(orderString);
                orderString = "";
            }
        }
        return orders;
    }
    private static void parseOrder(String string){
        int pos = 0;
        String name = "";
        List<Item> items = Collections.emptyList();
        for(int i = 0; i < string.length(); i++){
            if(string.substring(i, i+1).equals(",")){
                pos = i;
                name = string.substring(0, pos);
                items =
            }
        }
        orders.add(new Order(name,items));
    }
}
