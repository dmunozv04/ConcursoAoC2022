package day05;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class day5 {
    public static List<List<String>> loadFileToArray(String filename){
        List<String> firstPart = new ArrayList<>();
        List<String> secondPart = new ArrayList<>();
        try {
            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            boolean getFirstPart = true;
            while (myReader.hasNextLine()) {
                String nextLine = myReader.nextLine();
                if(nextLine.isEmpty()){
                    getFirstPart = false;
                }
                else if(getFirstPart){
                    firstPart.add(nextLine);
                }
                else{
                    secondPart.add(nextLine);
                }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        List<List<String>> input = new ArrayList<>();
        input.add(firstPart);
        input.add(secondPart);
        return input;
    }
    public static List<Character>[] processColumns(List<String> firstPart){
        String lastline = firstPart.get(firstPart.size()-1);
        int length = Integer.valueOf(lastline.substring(lastline.length()-2, lastline.length()-1));
        List<Character>[] processed = (List<Character>[]) new List[length];
        for(int i=0;i<length;i++){
            processed[i] = new ArrayList<>();
        }
        for(int i=firstPart.size()-2;i>=0;i--){
            //String[] line = new String[length-1];
            String line = firstPart.get(i);
            for(int j=0;j<length;j++){
                char thisChar = line.charAt(j*4+1);
                if(thisChar != ' '){
                    processed[j].add(thisChar);
                }
            }
        }
        return processed;
    }
    public static void doMovePart1(List<Character>[] board, int num, int colFrom, int colTo){
        for(int i=0;i<num;i++){
            char charToMove = board[colFrom].get(board[colFrom].size()-1);
            board[colFrom].remove(board[colFrom].size()-1);
            board[colTo].add(charToMove);
        }
    }
    public static void doMovePart2(List<Character>[] board, int num, int colFrom, int colTo){
        for(int i=num-1;i>=0;i--){
            char charToMove = board[colFrom].get(board[colFrom].size()-i-1);
            board[colTo].add(charToMove);
        }
        for(int i=0;i<num;i++){
        board[colFrom].remove(board[colFrom].size()-1);
        }
    }

    public static void part1(){
        List<List<String>> input = loadFileToArray("day05/input.txt");
        List<Character>[] board = processColumns(input.get(0));
        List<String> movements = input.get(1);
        for(int i=0;i<movements.size();i++){
            String[] thisMovement = movements.get(i).split(" ");
            doMovePart1(board,
                    Integer.valueOf(thisMovement[1]),
                    Integer.valueOf(thisMovement[3])-1,
                    Integer.valueOf(thisMovement[5])-1);
        }
        String result = "";
        for(int i=0; i<board.length;i++){
            result += board[i].get(board[i].size()-1);
        }
        System.out.println(result);

        
    }
    public static void part2(){
        List<List<String>> input = loadFileToArray("day05/input.txt");
        List<Character>[] board = processColumns(input.get(0));
        List<String> movements = input.get(1);
        for(int i=0;i<movements.size();i++){
            String[] thisMovement = movements.get(i).split(" ");
            doMovePart2(board,
                    Integer.valueOf(thisMovement[1]),
                    Integer.valueOf(thisMovement[3])-1,
                    Integer.valueOf(thisMovement[5])-1);
        }
        String result = "";
        for(int i=0; i<board.length;i++){
            result += board[i].get(board[i].size()-1);
        }
        System.out.println(result);
    }


    public static void main(String args[]){
        part1();
        part2();
    }
}
