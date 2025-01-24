import java.util.Scanner;
public class task9{
  public static void main(String []args){
   Scanner sc= new Scanner(System.in);
   System.out.println("enter cgpa");
   double a=sc.nextDouble();
   System.out.println("enter credit");
   int b=sc.nextInt();
   if (a<3.8 || b<30){
     System.out.println("The student is not eligible for a waiver");
   }
   else if(a>=3.80 && a<=3.89){
    System.out.println("25 percent");
   }
    else if(a>=3.90 && a<=3.94){
    System.out.println("50 percent");
    }
    else if(a>=3.95 && a<=3.99){
    System.out.println("75 percent");
    }
    else if(a==4.00){
    System.out.println("100 percent");
    }
  }
}
    
    
      