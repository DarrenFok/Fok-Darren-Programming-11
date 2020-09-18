package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class Controller {
    //Fields
    public TextField nameInput;
    public TextField ageInput;
    public TextField gradeInput;
    public TextField skillsInput;
    public TextField schoolInput;
    public Label outputName;
    public Label outputAge;
    public Label outputGrade;
    public Label outputSkills;
    public Label outputSchool;
    public ListView<Friend> viewFriend = new ListView<>();
    public Button deleteButton;

    //Improved version added fields
    public TextField newListName;
    public ListView availableLists;
    public Button buttonLoadList;
    public Button buttonRemoveList;
    public Button buttonViewList;
    public Button saveToFileButton;
    public Button buildButton;
    public Label saveToFileLabel;
    public Label errorLabel;

    //Build friend method
    public void buildFriend(ActionEvent actionEvent) {
        viewFriend.getItems().clear();
        String name = nameInput.getText();
        int age = Integer.parseInt(ageInput.getText());
        int grade = Integer.parseInt(gradeInput.getText());
        String skills = skillsInput.getText();
        String school = schoolInput.getText();

        Friend newFriend = new Friend (name, age, grade, skills, school);
        viewFriend.getItems().add(newFriend);

        nameInput.clear();
        ageInput.clear();
        gradeInput.clear();
        skillsInput.clear();
        schoolInput.clear();

        saveToFileButton.setVisible(true);
        buildButton.setVisible(false);
        saveToFileLabel.setText("Please select a list to save to and press save.");
        saveToFileButton.setDisable(true);

        nameInput.setDisable(true);
        ageInput.setDisable(true);
        gradeInput.setDisable(true);
        skillsInput.setDisable(true);
        schoolInput.setDisable(true);
    }

    //Display friend method
    public void displayFriend(MouseEvent mouseEvent) {
        Friend newFriend;
        newFriend = viewFriend.getSelectionModel().getSelectedItem();
        outputName.setText(newFriend.getName());
        outputAge.setText(Integer.toString(newFriend.getAge()));
        outputGrade.setText(Integer.toString(newFriend.getGrade()));
        outputSkills.setText(newFriend.getSkills());
        outputSchool.setText(newFriend.getSchool());
        deleteButton.setDisable(false);
        deleteButton.setVisible(true);
    }

    //Delete friend method
    public void deleteFriend(ActionEvent actionEvent) throws IOException{
        Friend newFriend;
        newFriend = viewFriend.getSelectionModel().getSelectedItem();
        viewFriend.getItems().remove(newFriend);

        outputName.setText("");
        outputAge.setText("");
        outputGrade.setText("");
        outputSkills.setText("");
        outputSchool.setText("");
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);

        ObservableList<Friend> friendList = viewFriend.getItems();
        int size = friendList.size();
        Object listName = availableLists.getSelectionModel().getSelectedItem();

        //Clear file
        FileWriter fileWrite = new FileWriter(listName+".txt",false);
        BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
        bufferWrite.write("");
        bufferWrite.close();

        System.out.println("Saving to file: " + listName);
        for(Friend i : friendList){
            System.out.println("Writing: " + i);
            i.writeToFile(listName + ".txt");
        }
    }

    public void createList(ActionEvent actionEvent) throws IOException {
        viewFriend.getItems().clear();

        String newItem = (newListName.getText());
        if(newItem.equals("")){
            System.out.println("No new list has been inputted");
            errorLabel.setText("ERROR: NO LIST INPUTTED");
        }
        else if(compareLists(newItem)){
            System.out.println("CompareList true");
            errorLabel.setText("ERROR: LIST ALREADY IN SET");
        }
        else{
            System.out.println("CompareList false");
            availableLists.getItems().add(newItem);
            newListName.clear();
            FileWriter newFile = new FileWriter(newItem + ".txt");
            BufferedWriter bw = new BufferedWriter(newFile);
            bw.close();

            System.out.println("Writing to friendLists.txt");
            FileWriter fwFriends = new FileWriter("friendLists.txt", true);
            BufferedWriter bwFriends = new BufferedWriter(fwFriends);
            bwFriends.write((String) newItem + "\r");
            bwFriends.close();
            errorLabel.setText("");
        }
    }

    public void loadList(ActionEvent actionEvent) throws IOException{
        System.out.println("Loading list...");
        viewFriend.getItems().clear();

        System.out.println("Updated new load...");
        FileReader fr = new FileReader("friendLists.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println("Line is: " + line);
            availableLists.getItems().add(line);
        }
        br.close();
        buttonLoadList.setVisible(false);
        buttonViewList.setVisible(true);
        buttonViewList.setDisable(true);
    }

    public void removeList(ActionEvent actionEvent) throws IOException{
        File inputFile = new File ("friendLists.txt");
        File tempFile = new File ("tempFile.txt");

        Object locate = availableLists.getSelectionModel().getSelectedItem();
        availableLists.getItems().remove(locate);
        System.out.println("Removing: " + locate);

        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        String line;

        //Writes to a temporary file that can copy later
        FileWriter fileWrite = new FileWriter(tempFile);
        BufferedWriter bufferedWrite = new BufferedWriter(fileWrite);

        while((line = br.readLine()) != null){
            System.out.println("Line located: " + line + " Located: " + locate);
            //When the line is located it can be deleted from the list
            if(line.equals(locate)){
                System.out.println("Line located: " + line + " Located: " + locate);
                System.out.println("Line is: " + line);
                availableLists.getItems().remove(line);

                //Removes file from the folder
                File file = new File (line + ".txt");
                System.out.println(file.delete());
            }
            else{
                //Else write the file back into the list
                System.out.println("Wrote: " + line);
                bufferedWrite.write(line + "\r");
            }
        }
        br.close();
        bufferedWrite.close();
        copyFile();

        outputName.setText("");
        outputAge.setText("");
        outputGrade.setText("");
        outputSkills.setText("");
        outputSchool.setText("");
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);
    }

    public void viewList(ActionEvent actionEvent) throws IOException {
        viewFriend.getItems().clear();;
        outputName.setText("");
        outputAge.setText("");
        outputGrade.setText("");
        outputSkills.setText("");
        outputSchool.setText("");
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);

        System.out.println("Viewing friends in process...");
        System.out.println("Searching list: " + availableLists.getSelectionModel().getSelectedItem() + ".txt");
        ArrayList<Friend> friends = LoadingFriends.viewFriends(availableLists.getSelectionModel().getSelectedItem() + ".txt");
        viewFriend.getItems().clear();

        for(Friend f : friends){
            System.out.println(f);
            viewFriend.getItems().add(f);
        }
    }

    public void selectedFriendList(MouseEvent mouseEvent) {
        buttonViewList.setDisable(false);
        buttonRemoveList.setDisable(false);
        saveToFileButton.setDisable(false);
    }

    public void saveToFile(ActionEvent actionEvent) throws IOException{
        saveToFileLabel.setText("");
        System.out.println("Currently saving to file");
        ObservableList<Friend> friendList = viewFriend.getItems();
        int size = friendList.size();
        Object listName = availableLists.getSelectionModel().getSelectedItem();
        System.out.println("Saving to file: " + listName);

        for(Friend i : friendList){
            System.out.println("Writing: " + i);
            i.writeToFile(listName + ".txt");
        }
        viewFriend.getItems().clear();

        saveToFileButton.setVisible(false);
        buildButton.setDisable(false);
        buildButton.setVisible(true);
        nameInput.setDisable(false);
        ageInput.setDisable(false);
        gradeInput.setDisable(false);
        skillsInput.setDisable(false);
        schoolInput.setDisable(false);
    }
    //Requires: String newList
    //Modifies: File friendLists.txt
    //Effects: Checks if the name of the new list is a duplicate of a pre-existing one
    public boolean compareLists(String newList) throws IOException{
        FileReader fr = new FileReader("friendLists.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null){
            if(line.equals(newList)){
                System.out.println("List name is duplicate");
                return true;
            }
        }
        return false;
    }

    //Requires: Nothing
    //Modifies: friendLists and tempFile files
    //Effects: reads tempFile.txt and copies info over to friendLists.txt
    public void copyFile() throws IOException{
        FileWriter fwrite = new FileWriter("friendLists.txt");
        BufferedWriter bwrite = new BufferedWriter(fwrite);

        FileReader frTemp = new FileReader("tempFile.txt");
        BufferedReader brTemp = new BufferedReader(frTemp);

        String line;

        while((line = brTemp.readLine()) != null){
            bwrite.write(line + "\r");
        }
        bwrite.close();
    }
}
