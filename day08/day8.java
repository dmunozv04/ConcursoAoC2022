package day08;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class day8 {
    public static List<List<Integer>> loadFileToArray(String filename){
        List<List<Integer>> listOfInts = new ArrayList<List<Integer>>();
        try {

            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            while (myReader.hasNextLine()) {
                List<Integer> line = new ArrayList<Integer>();
                char[] lineArray = myReader.nextLine().toCharArray();
                for(int i=0;i<lineArray.length;i++){
                    line.add(Integer.valueOf(lineArray[i]));
                }
                listOfInts.add(line);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return listOfInts;
    }
    public static void part1(){
        int[][] vectors = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0} };

        List<List<Integer>> input = loadFileToArray("day08/input.txt");
        int count = 0;
        for(int i = 0; i<input.size();i++){
            for(int j = 0; j<input.get(i).size();j++){
                boolean isVisible = false;
                //System.out.println(input.get(i).get(j));
                for(int k=0;k<vectors.length && !isVisible;k++){
                    int x = i;
                    int y = j;
                    int treeValue = input.get(i).get(j);
                    while(x>=0 && x<input.size() && y>=0 && y<input.get(i).size()){
                        x += vectors[k][0];
                        y += vectors[k][1];
                        try{
                            if(input.get(x).get(y) >= treeValue){ 
                                break;
                            }
                        }
                        catch(Exception e){
                            isVisible = true;
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    };


    public static void part2(){
        int[][] vectors = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0} };

        List<List<Integer>> input = loadFileToArray("day08/input.txt");
        int biggestScenicValue = 0;
        for(int i = 0; i<input.size();i++){
            for(int j = 0; j<input.get(i).size();j++){
                //System.out.println(input.get(i).get(j));
                int treeScenicValue = 1; // 1 is neutral in multiplication
                for(int k=0;k<vectors.length;k++){
                    int x = i;
                    int y = j;
                    int treeValue = input.get(i).get(j);
                    int thisTreeScenicValue = 0;
                    while(x>=0 && x<input.size() && y>=0 && y<input.get(i).size()){
                        x += vectors[k][0];
                        y += vectors[k][1];
                        try{
                            if(input.get(x).get(y) >= treeValue){ 
                                thisTreeScenicValue++; //count the tree that blocks the view
                                break;
                            }
                            thisTreeScenicValue++;
                        }
                        catch(Exception e){
                            break; //dont count outside the edge
                        }
                    }
                    treeScenicValue *= thisTreeScenicValue;
                }
                if(treeScenicValue > biggestScenicValue){
                    biggestScenicValue = treeScenicValue;
                }
            }
        }
        System.out.println(biggestScenicValue);
    };
    public static void main(String args[]){
        //part1();
        part2();
    }
}