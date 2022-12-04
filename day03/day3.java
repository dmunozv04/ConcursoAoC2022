package day03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class day3 {
    public static String[] loadFileToArray(String filename){
        List<String> listOfStrings = new ArrayList<String>();
        try {

            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            while (myReader.hasNextLine()) {
                listOfStrings.add(myReader.nextLine());
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return listOfStrings.toArray(new String[0]);
    }
    public static int calculateScore(char character){
        int score = (int) character;
        if((int) character < 'a'){ //all uppercase letters
            score -= 38; //-38 makes A be 27
        }
        else{
            score -= 96;//-96 makes a be 1
        }
        return score;
    }
    public static List<List<String>> loadFileToArrays(String filename){
        List<List<String>> listOfStrings = new ArrayList<>();
        try {

            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            int index = 0;
            while (myReader.hasNextLine()) {
                listOfStrings.add(new ArrayList<String>());
                listOfStrings.get(index).add(myReader.nextLine());
                listOfStrings.get(index).add(myReader.nextLine());
                listOfStrings.get(index).add(myReader.nextLine());
                index++;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return listOfStrings;
    }

    public static void part1(){
        String[] input = loadFileToArray("day03/input.txt");
        int counter = 0;
        for(int i=0;i<input.length;i++){
            boolean isFound = false;
            String secondHalf = input[i].substring(input[i].length()/2);
            for(int j=0; j<input[i].length()/2 && !isFound;j++){
                if(secondHalf.contains(String.valueOf(input[i].charAt(j)))){
                    counter += calculateScore(input[i].charAt(j));
                    isFound = true;
                }
            }
        }
        System.out.println(counter);   
    }
    public static void part2(){
        List<List<String>> input = loadFileToArrays("day03/input.txt");
        int counter = 0;
        for(int i=0;i<input.size();i++){
            boolean isFound = false;
            for(int j=0; j<input.get(i).get(0).length() && !isFound;j++){
                if(input.get(i).get(1).contains(String.valueOf(input.get(i).get(0).charAt(j))) &&
                input.get(i).get(2).contains(String.valueOf(input.get(i).get(0).charAt(j)))){
                    counter += calculateScore(input.get(i).get(0).charAt(j));
                    isFound = true;
                }
            }
            if(!isFound){
                System.out.println("error in " + i*3);
            }
        }
        System.out.println(counter);
    }
    public static void main(String args[]){
        part2();
    }
    
}
