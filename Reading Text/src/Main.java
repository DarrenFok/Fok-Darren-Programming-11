import java.io.*;
import java.util.ArrayList;

public class Main {

    //Requires: String
    //Modifies: This
    //Effects: Reads ProgrammingHistory.txt (input file), determines which index an occurrence happens at
    public static int findText(String finding) throws IOException{
        System.out.println("");
        System.out.println("Searching for word: " + finding);
        int counter = 0;
        int lineCounter = 0;
        int indexBeginning = 0;
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println("Read this line: " + line);
            lineCounter++;

            indexBeginning = line.indexOf(finding);
            while(indexBeginning >= 0){
                System.out.println("Found word: " + finding + ", at index position: " + indexBeginning + ", on ArrayList element: " + lineCounter);
                indexBeginning = line.indexOf(finding, indexBeginning + 1);
                counter++;
            }
        }
        return indexBeginning;
    }

    public static void main(String[] args) throws IOException{
        //copies each line into an ArrayList
        ArrayList<String> lines = new ArrayList<>();
        FileReader fileReader = new FileReader("ProgrammingHistory.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println("Just Read: " + line);
            lines.add(line);
        }
        bufferedReader.close();
        for(String i:lines){
            System.out.println(i);
        }

        //prints text over to an "out" file
        FileWriter fw = new FileWriter("out.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Writing to 'out' file of ProgrammingHistory.txt file\r");
        for(String i : lines){
            bw.write(i + "\r");
        }
        bw.close();

        //runs the method that finds the text
        findText("machine");
    }
}
