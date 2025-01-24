import java.util.Scanner;
public class task3{
  public static void main(String[]args){
    Scanner sc =new Scanner(System.in);
    int x =sc.nextInt();
    int [] arr=new int[x];
    for(int i=0; i<x;i++){
      int y =sc.nextInt();
      arr[i]=y;
    }
    for(int i=arr.length-1; i>=0;i--){
      System.out.print(arr[i]+" ");
    }
  }
}