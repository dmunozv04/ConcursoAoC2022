package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class day4 {
    public static List<int[][]> loadFileToArrays(String filename){
        List<int[][]> listOfInts = new ArrayList<>();
        try {
            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            while (myReader.hasNextLine()) {
                int[][] thisArr = new int[2][2];
                String thisLine = myReader.nextLine();
                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++){
                        thisArr[i][j] = Integer.valueOf(thisLine.split(",")[i].split("-")[j]);
                    }
                }
                listOfInts.add(thisArr);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return listOfInts;
    }
    public static void part1(){
        List<int[][]> input = loadFileToArrays("day04/input.txt");
        int counter =0;
        for(int i=0;i<input.size();i++){
            int[][] thisLine = input.get(i);
            if(thisLine[0][0] <= thisLine[1][0] && thisLine[0][1] >= thisLine[1][1]){
                counter++;
            }
            else if(thisLine[1][0] <= thisLine[0][0] && thisLine[1][1] >= thisLine[0][1]){
                counter++;
            }
        }
        System.out.println(counter);
    }
    public static void part2(){
        List<int[][]> input = loadFileToArrays("day04/input.txt");
        int counter =0;
        for(int i=0;i<input.size();i++){
            int[][] thisLine = input.get(i);
            Set<Integer> hash_Set = new HashSet<Integer>();
            boolean contains = false;
            for(int j=0;j<2;j++){
                for(int k=thisLine[j][0]; k<=thisLine[j][1] && !contains;k++){
                    if(!hash_Set.add(k)){
                        contains = true;
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }
    public static void main(String args[]){
        part2();
    }
}
