package day07;
import java.util.ArrayList;
import java.util.List;
public class dir {
    private int fileSize;
    private int subDirSize;
    private List<dir> subDirs;
    private dir parent;
    private String name;

    public dir(){
        this.subDirs = new ArrayList<>();
    };
    public dir(dir parent, String name){
        this.parent = parent;
        this.name = name;
        this.subDirs = new ArrayList<>();
    };


    public void addElement(String contents){
        if(contents.split(" ")[0].equals("dir")){
            this.subDirs.add(new dir(this, contents.split(" ")[1]));
        }
        else{
            this.fileSize += Integer.valueOf(contents.split(" ")[0]);
        }
    }
    public dir getSubDir(String name){
        dir subDir = null;
        for(int i=0;i<this.subDirs.size();i++){
            if(this.subDirs.get(i).name.equals(name)){
                subDir= this.subDirs.get(i);
            }
        }
        if(subDir == null){
            System.out.println("ERROR: subDir not found");
        }
        return subDir;
    }

    public int getTotalSize(){
        if(this.subDirSize ==0){
            calculateSubDirSize();
        }
        return this.fileSize + this.subDirSize;
    }
    public void calculateSubDirSize(){
        subDirSize = 0;
        for(int i=0;i<this.subDirs.size();i++){
            subDirSize += this.subDirs.get(i).getTotalSize();
        }
        this.subDirSize = subDirSize;
    }
    public dir getParent(){
        return this.parent;
    }
    public List<Integer> getAllSubSizes(){
        List<Integer> allSubSizes = new ArrayList<>();
        for(int i=0;i<this.subDirs.size();i++){
            allSubSizes.add(this.subDirs.get(i).getTotalSize());
            allSubSizes.addAll(this.subDirs.get(i).getAllSubSizes());
        }
        return allSubSizes;
    }
}