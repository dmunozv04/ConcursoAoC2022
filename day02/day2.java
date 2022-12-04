package day02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class day2{
    public static List<List<Character>> loadFileToArray(String filename){
        List<List<Character>> listOfInts = new ArrayList<List<Character>>();
        try {

            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            int mainIndex = 0;
            //listOfInts.add(new ArrayList<Character>());
            while (myReader.hasNextLine()) {
                listOfInts.add(new ArrayList<Character>());
                String line = myReader.nextLine();
                listOfInts.get(mainIndex).add(line.charAt(0));
                listOfInts.get(mainIndex).add(line.charAt(2));
                mainIndex++;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return listOfInts;
    }
    public static int calculateScore(char[] inputs){
        int score =0;
        char theirs = inputs[0];
        char mine = inputs[1];
        switch (mine){
            case 'X':
                score = 1;
                break;
            case 'Y':
                score = 2;
                break;
            case 'Z':
                score = 3;
                break;
            default:
                score = 0;
                break;
        }
        switch(theirs){
            case 'A':
                theirs = 'X'; //ROCK
                break;
            case 'B':
                theirs = 'Y'; //PAPER
                break;
            case 'C':
                theirs = 'Z'; //SCISSORS
                break;
        }
        if(mine==theirs){ //TIE
            score +=3;
        }
        //OPPONENT WINS
        else if((theirs=='Y' && mine=='X') || (theirs=='Z' && mine == 'Y') || (theirs=='X' && mine=='Z')){ 
            score += 0;
        }   
        else{
            score += 6;
        } //I WIN
        return score;
    }
    public static char calculateMove(char their, char outcome){
        int theirInt = 0;
        switch (their){
            case 'A': //ROCK x
                theirInt = 0;
                break;
            case 'B': //PAPER y
                theirInt = 1;
                break;
            case 'C': //SCISSORS z
                theirInt = 2;
                break;
        }
        char[] possibleSolutions;
        switch (outcome){
            case 'X'://LOOSE
                possibleSolutions = new char[] {'Z', 'X', 'Y'};
                break;
            case 'Y'://DRAW
                possibleSolutions = new char[] {'X', 'Y', 'Z'};
                break;
            case 'Z'://WIN
                possibleSolutions = new char[] {'Y', 'Z', 'X'};
                break;
            default://SHOULDN'T GO HERE
                possibleSolutions = new char[] {};
        }
        return possibleSolutions[theirInt];

    }
    public static void part1(){
        List<List<Character>> input = loadFileToArray("day02/input.txt");
        int result = 0;
        for(int i =0;i<input.size();i++){
            char[] thisMove = new char[] {input.get(i).get(0), input.get(i).get(1)};
            result += calculateScore(thisMove);
            System.out.print("");
        }
        System.out.println(result);
    }
    public static void part2(){
        List<List<Character>> input = loadFileToArray("day02/input.txt");
        int result = 0;
        for(int i =0;i<input.size();i++){
            char[] thisMove = new char[] {input.get(i).get(0), calculateMove(input.get(i).get(0), input.get(i).get(1))};
            result += calculateScore(thisMove);
            // moves[i][i] = calculateMinePart1(input.get(i).get(0));
        }
        System.out.println(result);
    }
    public static void main(String args[]){
        part2();
    }
}