package day09;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class day9 {
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
    public static int[] getVector(String direction){
        int[] vector = new int[2];
        switch(direction){
            case "D":
                vector[0] = 0;
                vector[1] = 1;
                break;
            case "U":
                vector[0] = 0;
                vector[1] = -1;
                break;
            case "R":
                vector[0] = 1;
                vector[1] = 0;
                break;
            case "L":
                vector[0] = -1;
                vector[1] = 0;
                break;
        }
        return vector;
    }
    public static int[] getNewHeadPos(int[] headPos, int[] vector){
        int[] newPos = new int[2];
        newPos[0] = headPos[0] + vector[0];
        newPos[1] = headPos[1] + vector[1];
        return newPos;
    }
    public static int[] getNewTailPosP1(int[] tailPos, int[] headPos){
        int[] newPos = new int[]{tailPos[0],tailPos[1]};
        int[] offset = new int[] {headPos[0]-tailPos[0], headPos[1]-tailPos[1]};
        if(Math.abs(offset[0])>1 || Math.abs(offset[1])>1){
            newPos[0] += Integer.signum(offset[0]);
            newPos[1] += Integer.signum(offset[1]);
        }
        return newPos;
    }
    public static void countTailPos(int[] tailPos, Set<Integer> allTailPos){
        allTailPos.add(tailPos[0]*1000+tailPos[1]);
    }
    public static void part1(){
        String[] input = loadFileToArray("day09/input.txt");
        int[] headPos = new int[] {0,0};
        int[] tailPos = new int[] {0,0};
        Set<Integer> allTailPos = new HashSet<Integer>();
        for(int i=0;i<input.length;i++){
            String[] thisInput = input[i].split(" ");
            for(int j=0;j<Integer.valueOf(thisInput[1]);j++){
                countTailPos(tailPos, allTailPos);
                int[] thisVector = getVector(thisInput[0]);
                headPos = getNewHeadPos(headPos, thisVector);
                tailPos = getNewTailPosP1(tailPos, headPos);
                System.out.print("");
            }
        }
        countTailPos(tailPos, allTailPos);
        System.out.println(allTailPos.size());
    }
    public static void part2(){
        String[] input = loadFileToArray("day09/input.txt");
        int[] headPos = new int[] {0,0};
        int[][] tailPos = new int[9][]; //tail is now 9 positions long
        for(int i=0;i<9;i++){
            tailPos[i] = new int[] {0,0};
        }
        Set<Integer> allTailPos = new HashSet<Integer>();
        for(int i=0;i<input.length;i++){
            String[] thisInput = input[i].split(" ");
            for(int j=0;j<Integer.valueOf(thisInput[1]);j++){
                countTailPos(tailPos[8], allTailPos);
                int[] thisVector = getVector(thisInput[0]);
                headPos = getNewHeadPos(headPos, thisVector);
                tailPos[0] = getNewTailPosP1(tailPos[0], headPos);
                for(int k=1;k<tailPos.length;k++){
                    tailPos[k] = getNewTailPosP1(tailPos[k], tailPos[k-1]);
                }
                countTailPos(tailPos[8], allTailPos);
                System.out.print("");
            }
        }
        countTailPos(tailPos[8], allTailPos);
        System.out.println(allTailPos.size());
    }
    public static void main(String[] args){
        //part1();
        part2();
    }
}
