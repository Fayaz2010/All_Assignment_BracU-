import java.util.Scanner;
public class task5{
  public static void main(String []args){
   Scanner sc= new Scanner(System.in);
   int a=sc.nextInt(); 
   int b=sc.nextInt(); 
   int c=sc.nextInt(); 
   if(a>b&&a>c){
   System.out.println("Largest number:"+a);
   }
   else if(b>a&&b>c){
     System.out.println("Largest number:"+b);
   }
   else if(c>b&&a<c){
     System.out.println("Largest number:"+c);
   }
  }
}
   
     
       