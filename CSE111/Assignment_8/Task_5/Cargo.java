package Task05;

public class Cargo {
    String Contents;
    double Weight;   
    public static double Capacity=10.0;
    public static double TotalWeight;  
    public static int ID;
    boolean Loaded=false; 
    public Cargo(String contents ,double weight){
        Contents=contents;
        Weight=weight;
        TotalWeight+=Weight;
    }
    public  void details(){
        ID++;
        System.out.print(ID);
        System.out.print(Contents);
        System.out.print(Weight);
        System.out.print(Loaded);
       
    }
    public void load(){
        if(TotalWeight<=10){
        System.out.println ("Cargo "+ID+" loaded for transport.");
        Loaded=true;
        }
        else{
            System.out.println ("Cannot load cargo, exceeds weight capacity");  
            Loaded=false;
        }
    }
    public static double capacity(){
        Capacity-=TotalWeight;
        return Capacity;
    }
    public void unload(){
        TotalWeight-=Weight;
        System.out.println ("Cargo "+ID+" unloaded for transport.");
 if(TotalWeight<=10){
    Loaded=true;
 }
 else{
    Loaded=false;
 }
 }
    
}
