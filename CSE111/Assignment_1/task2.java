//import java.util.Scanner;
public class task2{
  public static void main(String []args){
    int a =23;
    int b=36; 
    int temp =a;
    a=b;
    b=temp;
    System.out.println(a);
    System.out.println(b);
    int a1 =23;
    int b1=36;
    int sum=a1+b1;
    a1=sum-a1;
    b1=sum-b1;   
    System.out.println(a1);
    System.out.println(b1);
  }
}