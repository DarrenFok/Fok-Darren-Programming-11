package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadingFriends {
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    //Requires: string
    //Modifies: this, String fileName (corresponding file with name)
    //Effects: Reads element in indicated file and returns the ArrayList of each element place
    public static ArrayList viewFriends(String fileName) throws IOException{
        friends.clear();
        System.out.println("Creating friend");
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendsString = "";

        while((line=br.readLine()) != null){
            if(!line.equals(";")){
                friendsString += line;
                System.out.println(line);
            }
            else{
                parseFriend(friendsString);
                friendsString = "";
                System.out.println("Special Line: " + line);
            }
        }
        return friends;
    }
    //Requires: String element
    //Modifies: this
    //Effects: Separates name, age, grade, skills and school
    public static void parseFriend(String element){
        int startIndex = 0;
        int endIndex = 0;
        int locationCounter = 0;

        System.out.println("Element is: " + element);
        //Stores location of comma
        ArrayList<Integer> location = new ArrayList<>();
        //Stores name, age, grade, skills and school
        ArrayList<String> conversionList = new ArrayList<>();

        for(int i = 0; i < element.length(); i++){
            if(element.substring(i,i+1).equals(",")){
                System.out.println("Adding: " + i);
                location.add(i);
            }
        }
        for(int i =0; i < element.length(); i++){
            if(i == location.get(0)){
                conversionList.add(element.substring(0,i));
            }
            if(locationCounter > 3){
                System.out.println("Loop breaking");
                break;
            }
            if(element.substring(i,i+1).equals(",")){
                System.out.println("Location Counter: " + locationCounter + " Location Getting: " + location.get(locationCounter));
                System.out.println("Found Comma");

                startIndex = location.get(locationCounter);
                endIndex = location.get(locationCounter + 1);

                conversionList.add(element.substring(startIndex + 1, endIndex));

                locationCounter++;
            }

        }
        for(String n: conversionList){
            System.out.println("Printing conversion list");
            System.out.println(n);
        }

        friends.add(new Friend(conversionList.get(0),Integer.parseInt(conversionList.get(1)), Integer.parseInt(conversionList.get(2)), conversionList.get(3), conversionList.get(4)));

    }
}
