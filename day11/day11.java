package day11;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class day11 {
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
    public static Monkey[] parseInput(String[] input){
        List<Monkey> parsed = new ArrayList<>();
        for(int i = 0; i < input.length; i+=7){
            String[] itemsString = input[i+1].split(" ");
            List<Integer> items = new ArrayList<>();
            for(int j = 4; j < itemsString.length; j++){ //Skips 0 and 1 which are text
                items.add(Integer.parseInt(itemsString[j].split(",")[0]));
            }
            String[] operationString = input[i+2].split(" ");
            boolean opType = operationString[6].equals("+");
            int opAmount;
            boolean opWithOld;
            try{
                opAmount = Integer.parseInt(operationString[7]);
                opWithOld = false;
            }
            catch(NumberFormatException e){ //If it's not a number, it's a reference to another monkey
                opAmount = 0;
                opWithOld = true;
            }
            int testAmount = Integer.parseInt(input[i+3].split(" ")[5]);
            int monkeyIfTrue = Integer.parseInt(input[i+4].split(" ")[9]);
            int monkeyIfFalse = Integer.parseInt(input[i+5].split(" ")[9]);
            parsed.add(new Monkey(items, opType, opAmount, opWithOld, testAmount, monkeyIfTrue, monkeyIfFalse));
        }
        return parsed.toArray(new Monkey[0]);
    }
    public static void part1(){
        String[] input = loadFileToArray("day11/input.txt");
        Monkey[] monkeys = parseInput(input);
        System.out.print("");
        for(int i=0;i<20;i++){ //20 cycles
            for(int j=0;j<monkeys.length;j++){
                monkeys[j].inspect(monkeys);
            }
        }
        List<Integer> numOfInspections = new LinkedList<>();
        for(Monkey i : monkeys){
            numOfInspections.add(i.getNumOfInspections());
        }
        int max1 = Collections.max(numOfInspections);
        numOfInspections.remove(numOfInspections.indexOf(max1));
        int max2 = Collections.max(numOfInspections);
        System.out.println(max1 * max2);


    }
    public static void part2(){}
    public static void main(String[] args){
        part1();
        part2();
    }
}
