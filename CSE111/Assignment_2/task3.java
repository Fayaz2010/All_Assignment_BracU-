import java.util.Scanner;
public class task3{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    int sum=0,max=0,min=0;
    for(int i=1;i<=10;i++){
      int x=sc.nextInt();
      sum=sum+x;
      if(i==1){
         max=x;
      }
      else if(max<x){
        max=x;
      }
      else{
          max=max;
      }
      if(i==1){
         min=x;
      }
      else if(min>x){
        min=x;
      }
      else{
          min=min;
      }
    }
      double avg =sum/10.0;
      System.out.println("sum = "+sum);
      System.out.println("Minimum = "+min);
      System.out.println("Maximum = "+max);
      System.out.println("Average = "+avg);
   
  }
}
