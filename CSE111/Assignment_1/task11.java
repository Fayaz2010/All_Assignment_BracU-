import java.util.Scanner;
public class task11{
  public static void main(String []args){
   Scanner sc= new Scanner(System.in);
   int x = sc.nextInt();
   if (x<0){
     System.out.println(2*x);
   }
   else if(0<=x&& x<2){
    System.out.println(x+1);
   }
    else if(2<=x&& x<5){
    System.out.println(x*x-1);
    }
    else if(x>=5){
    System.out.println(3*x*x+2);
    }
    sc.close();
  }
  
}