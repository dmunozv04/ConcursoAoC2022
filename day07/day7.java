package day07;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import day07.dir;
public class day7{
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
    public static List<Integer> removeLargerThan(List<Integer> list, int max){
        List<Integer> newList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)<=max){
                newList.add(list.get(i));
            }
        }
        return newList;
    }
    public static List<Integer> removeSmallerThan(List<Integer> list, int max){
        List<Integer> newList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>=max){
                newList.add(list.get(i));
            }
        }
        return newList;
    }
    public static int min(List<Integer> list){
        int min = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<min){
                min = list.get(i);
            }
        }
        return min;
    }
    public static int sumOfElements(List<Integer> list){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }

    public static void part1(){
        dir root = new dir();
        dir currentDir = root;

        String[] input = loadFileToArray("day07/input.txt");
        for(int i=1;i<input.length;i++){ //ignore first command that just cd's to root
            if(input[i].split(" ")[0].equals("$")){
                if(input[i].charAt(2)=='c'){ //CD COMMAND
                    if(input[i].equals("$ cd ..")){
                        currentDir = currentDir.getParent();
                    }
                    else{
                        currentDir = currentDir.getSubDir(input[i].split(" ")[2]);
                    }
                }
            }
            else{ //LS OUTPUT 
                currentDir.addElement(input[i]);
            }
        }
        List<Integer> allSubSizes = root.getAllSubSizes();
        System.out.println(root.getTotalSize());
        System.out.println(sumOfElements(removeLargerThan(allSubSizes, 100000)));


    }
    public static void part2(){
        dir root = new dir();
        dir currentDir = root;

        String[] input = loadFileToArray("day07/input.txt");
        for(int i=1;i<input.length;i++){ //ignore first command that just cd's to root
            if(input[i].split(" ")[0].equals("$")){
                if(input[i].charAt(2)=='c'){ //CD COMMAND
                    if(input[i].equals("$ cd ..")){
                        currentDir = currentDir.getParent();
                    }
                    else{
                        currentDir = currentDir.getSubDir(input[i].split(" ")[2]);
                    }
                }
            }
            else{ //LS OUTPUT 
                currentDir.addElement(input[i]);
            }
        }
        List<Integer> allSubSizes = root.getAllSubSizes();
        int sizeUsed = 70000000 - root.getTotalSize();
        int sizeToRemove = 30000000 - sizeUsed;
        System.out.println(sizeToRemove);
        System.out.println(min(removeSmallerThan(allSubSizes, sizeToRemove)));
    }
    public static void main(String[] args){
        //part1();
        part2();
    }
}