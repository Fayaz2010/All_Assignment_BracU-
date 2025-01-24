import java.util.Scanner;
public class task6{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    double sum=0;
    int b=0;
    for(int i=0;i<5;i++){
      System.out.print("number");
      double x=sc.nextDouble();
      System.out.print("weight");
      int y=sc.nextInt();
      double a=x*y;
      sum+=a;
      b+=y;
    }
    System.out.print(sum/b);
  }
}