import java.util.Scanner;
public class task5{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    int sum=0,max=0,min=0,c=0;
    double d=0;
    while(c<3){
      int x=sc.nextInt();
      if(x!=0){
       d++;
      sum=sum+x;
      if(d==1){
         max=x;
      }
      else if(max<x){
        max=x;
      }
      else{
          max=max;
      }
      if(d==1){
         min=x;
      }
      else if(min>x){
        min=x;
      }
      else{
          min=min;
      }
      c=0;
    }
      else{
        c++;
      }
    }
    if(c==3&&d==0){
      System.out.println("No numbers found");
    }
    else{
      double avg =sum/d;
      System.out.println("sum = "+sum);
      System.out.println("Minimum = "+min);
      System.out.println("Maximum = "+max);
      System.out.println("Average = "+avg);
    }
  }
}