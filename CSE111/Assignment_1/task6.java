import java.util.Scanner;
public class task6{
  public static void main(String []args){
   Scanner sc= new Scanner(System.in);
   int a=sc.nextInt(); 
   if(a%100==0 && a%400!=0){
     System.out.println(a+" is not a leap year");
   }
   else if(a%4==0){
     System.out.println(a+" is a leap year");
   }
   else{
     System.out.println(a +" is not a leap year");
   }
  }
}