package day11;
import java.util.List;
public class Monkey {
    private List<Integer> items;
    private boolean opType; //true = add, false = multiply
    private int opAmount;
    private boolean opWithOld;
    private int testAmount;
    private int monkeyIfTrue;
    private int monkeyIfFalse;
    private int numOfInspections;
    public Monkey(){}
    public Monkey(List<Integer> items, boolean opType, int opAmount, boolean opWithOld, int testAmount, int monkeyIfTrue, int monkeyIfFalse){
        this.items = items;
        this.opType = opType;
        this.opAmount = opAmount;
        this.opWithOld = opWithOld;
        this.testAmount = testAmount;
        this.monkeyIfTrue = monkeyIfTrue;
        this.monkeyIfFalse = monkeyIfFalse;
        this.numOfInspections = 0;
    }
    public int getNumOfInspections(){
        return numOfInspections;
    }
    public void addItem(int item){
        items.add(item);
    }
    public void inspect(Monkey[] monkeys){
        while(this.items.size() > 0){
            int item = this.items.remove(0);
            this.numOfInspections+= 1;
            if(!opWithOld){
                if(opType){//sum
                    item += opAmount;
                }
                else{
                    item *= opAmount;
                }
            }
            else{
                if(opType){//sum
                    item += item;
                }
                else{
                    item *= item;
                }
            }

            item = Math.floorDiv(item, 3);

            if(item%testAmount == 0){
                monkeys[monkeyIfTrue].addItem(item);
            }
            else{
                monkeys[monkeyIfFalse].addItem(item);
            }
        }
    }
}
