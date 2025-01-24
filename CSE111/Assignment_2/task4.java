import java.util.Scanner;
public class task4{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    int sum=0,max=0,min=0;
    double c=0;
    for(int i=1;i<=10;i++){
      int x=sc.nextInt();
      if(x>0 && x%2!=0){
        c++;
      sum=sum+x;
      if(c==1){
         max=x;
      }
      else if(max<x){
        max=x;
      }
      else{
          max=max;
      }
      if(c==1){
         min=x;
      }
      else if(min>x){
        min=x;
      }
      else{
          min=min;
      }
    }
    }
    if(sum==0){
      System.out.println("No odd positive numbers found");
    }
    else{
      double avg =sum/c;
      System.out.println("sum = "+sum);
      System.out.println("Minimum = "+min);
      System.out.println("Maximum = "+max);
      System.out.println("Average = "+avg);
    }
  }
}