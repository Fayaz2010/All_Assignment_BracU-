import java.util.Scanner;
public class task5{
  public static void main(String[]args){
    Scanner sc =new Scanner(System.in);
    System.out.print("N:");
    int x =sc.nextInt();
    int c=0;
    int [] arr=new int[x];
    System.out.print("Please enter the elements of the array:");
    for(int i=0; i<x;i++){
      int y =sc.nextInt();
      arr[i]=y;
    }
    System.out.print("New Array : ");
    for(int i=0; i<arr.length-1; i++){
      if(i==0){
        System.out.print(arr[i]+" ");
      }
      if(arr[i]!=arr[i+1]){
        System.out.print(arr[i+1]+" ");
      }
      else{
        c++;
      } 
    }
    System.out.println();
    System.out.print("Removed elements : "+c);
  }
}
        
        
        
        
      