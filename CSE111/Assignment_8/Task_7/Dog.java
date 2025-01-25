public class Dog extends Animal{
    String name;
   public Dog(){
    System.out.println("The dog says hello!");
   }
   public String getName(){
     return name;
   }
   public void updateSound(String s){
    sound =s;
   }
}



