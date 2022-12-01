import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class day1{
    public static List<List<Integer>> loadFileToArray(String filename){
        List<List<Integer>> listOfInts = new ArrayList<List<Integer>>();
        try {

            File fileToRead = new File(filename);
            Scanner myReader = new Scanner(fileToRead);
            int mainIndex = 0;
            listOfInts.add(new ArrayList<Integer>());
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(line.isEmpty()){
                    mainIndex++;
                    listOfInts.add(new ArrayList<Integer>());
                }
                else{
                    listOfInts.get(mainIndex).add(Integer.valueOf(line));
                }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        return listOfInts;
    }
    public static int[] findMax(int[] arr){
        int max = 0; //calories can't be -
        int maxIndex = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        return new int[] {maxIndex, max};
    }

    public static void part1(){
        List<List<Integer>> input = loadFileToArray("day1/input.txt");
        int[] caloriesPerMonkey = new int[input.size()];
        for(int i=0;i<input.size();i++){
            int thisSum = 0;
            for(int j=0;j<input.get(i).size();j++){
                thisSum += input.get(i).get(j);
            }
            caloriesPerMonkey[i] = thisSum;
            thisSum =0;
        }
        System.out.println(findMax(caloriesPerMonkey)[1]);
    }
    public static void part2(){
        List<List<Integer>> input = loadFileToArray("day1/input.txt");
        int[] caloriesPerMonkey = new int[input.size()];
        for(int i=0;i<input.size();i++){
            int thisSum = 0;
            for(int j=0;j<input.get(i).size();j++){
                thisSum += input.get(i).get(j);
            }
            caloriesPerMonkey[i] = thisSum;
            thisSum =0;
        }
        int max3Sum = 0;
        for(int i = 0; i<3;i++){
            int[] thisMax = findMax(caloriesPerMonkey);
            max3Sum += thisMax[1];
            caloriesPerMonkey[thisMax[0]] = 0;
        }
        System.out.println(max3Sum);
    }
    public static void main(String args[]){
        part1();
        part2();
    }
}