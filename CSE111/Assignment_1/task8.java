import java.util.Scanner;
public class task8{
  public static void main(String []args){
   Scanner sc= new Scanner(System.in);
   int a=sc.nextInt();
   int b= a/1000;
   int c=b/100;
   int d=b%100;
   if(d==1){
     System.out.println("Student Joined BRAC in Spring "+d);
   }
   else if(d==2){
     System.out.println("Student Joined BRAC in Fall "+d);
   }
   else if(d==3){
     System.out.println("Student Joined BRAC in Summer "+d);
   }
  }
}
   