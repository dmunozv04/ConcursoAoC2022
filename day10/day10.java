package day10;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class day10 {
    public static String[] loadFileToArray(String filename){
        List<String> input = new ArrayList<>();
        try {
            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            while (myReader.hasNextLine()) {
                input.add(myReader.nextLine());
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return input.toArray(new String[0]);
    }
    public static String[] convertAddTo2Cycles(String[] input){
        List<String> output = new ArrayList<>();
        output.add("noop3");//start instruction since it starts counting at 1
        for(int i=0;i<input.length;i++){
            if(input[i].equals("noop")){
                output.add(input[i]);
            }
            else{
                output.add("noop2");//custom instruction to account for add being 2 cycles
                output.add(input[i]);
            }
        }
        return output.toArray(new String[0]);
    }
    public static void part1(){
        String[] input = loadFileToArray("day10/input.txt");
        input = convertAddTo2Cycles(input);
        int xRegister = 1;
        int sum = 0;
        for(int i=0;i<input.length;i++){
            if((i-20)%40==0){
                sum += (xRegister*i);
            }
            if(input[i].startsWith("noop")){
                continue;
            }
            else{
                xRegister += Integer.parseInt(input[i].split(" ")[1]);
            }
        }
        System.out.println(sum);
    }
    public static void part2(){
        String[] input = loadFileToArray("day10/input.txt");
        input = convertAddTo2Cycles(input);
        //String[] output = new String[6];
        int xRegister = 2; //since it starts at 1
        int horizontalPos = 1;
        String thisLine = "";
        for(int i=1;i<input.length;i++, horizontalPos++){
            if(Math.abs(xRegister-horizontalPos)<2){
                thisLine += "#";
            }
            else{
                thisLine += ".";
            }
            if(i%40==0){
                horizontalPos = 0;
                System.out.println(thisLine);
                thisLine = "";
            }
            //same as p1
            if(input[i].startsWith("addx")){
                xRegister += Integer.parseInt(input[i].split(" ")[1]);
            }
        }
        System.out.println(thisLine);
    }
    public static void main(String[] args){
        //part1();
        part2();
    }
    
}
