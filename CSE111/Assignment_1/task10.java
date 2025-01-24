import java.util.Scanner;
public class task10{
  public static void main(String []args){
   Scanner sc= new Scanner(System.in);
   int a = sc.nextInt();
   if (a%2==0 && a%5==0){
     System.out.println("Multiple of 2 and 5 both");;
   }
   else if (a%2==0 || a%5==0){
     System.out.println(a);
   }
   else{
     System.out.println("Not a multiple we want");
   }
  }
}
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     