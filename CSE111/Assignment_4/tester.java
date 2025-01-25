public class tester{
  public static void main(String [] args){
    University u1 =new University();
    University u2 =new University();
    //TASK A
    System.out.println(u1);
    System.out.println(u2);
    
    //TASK B
    
    u1.name="Imperial College London";
    u1.country = "England";
    
    u2.name =  "Brac University";
    u2.country = "Bangladesh";
    
    System.out.println(u1.name);
    System.out.println(u1.country);
    System.out.println(u2.name);
    System.out.println(u2.country); 
  }
}
    
