public class HanoiTower{
    void move(int n, char source, char destination, char auxiliary){  
        if(n==1) System.out.println(source+"--->"+destination);
        else{
            move(n-1,source,auxiliary,destination);
            move(1,source,destination,auxiliary);
            move(n-1,auxiliary,destination,source);
        }
    }
    public static void main(String[] args){
         HanoiTower ht = new HanoiTower();
         ht.move(3,'A','B','C');  //move n disk from rod A to rod B
    }
}
