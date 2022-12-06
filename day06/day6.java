package day06;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class day6{
    public static String loadFileToString(String filename){
        String line = "";
        try {
            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
                line = myReader.nextLine();
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return line;
    }
    public static void part1(){
        String input = loadFileToString("day06/input.txt");
        boolean isFound = false;
        for(int i=0;i<input.length() && !isFound;i++){
            if((input.charAt(i)==input.charAt(i+1)) || (input.charAt(i)==input.charAt(i+2)) || (input.charAt(i)== input.charAt(i+3))
            || (input.charAt(i+1)==input.charAt(i+2)) || (input.charAt(i+1)==input.charAt(i+3))
            || (input.charAt(i+2)==input.charAt(i+3))){}
            else{
                isFound = true;
                System.out.println(i+4);
            }
        }
    }
    public static void part2(){
        String input = loadFileToString("day06/input.txt");
        boolean isFound = false;
        for(int i=0;i<input.length() && !isFound;i++){
            Set<Character> dupes = new HashSet<>();
            boolean isDifferent = true;
            for(int j=0; j<14 && isDifferent;j++){
                isDifferent = dupes.add(input.charAt(i+j));
            }
            if(isDifferent){
                System.out.println(i+14);
                isFound = true;
            }
        }
    }
    public static void main(String args[]){
        part1();
        part2();
    }
}