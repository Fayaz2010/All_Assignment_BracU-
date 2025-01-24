import java.util.Scanner;
public class task6{
  public static void main(String[]args){
    Scanner sc =new Scanner(System.in);
    int x =sc.nextInt();
    int [] arr=new int[x];
    int temp=0,a=0,b=0,z=0;
    for(int i=0; i<x;i++){
      int y =sc.nextInt();
      arr[i]=y;
    }
    for(int j=0;j<arr.length;j++){
     for(int i=0;i<arr.length-1;i++){
      if(arr[i]>arr[i+1]){
      temp=arr[i];
      arr[i]=arr[i+1];
      arr[i+1]=temp;
      }
     }
    }  
    if(x%2!=0){
      a=(x/2);
      z=arr[a];
    }
    else{
      a=(x/2)-1;
      b=(x/2);
      z=(arr[a]+arr[b])/2;
    }
    System.out.print("The median is "+z);

  }
}
    
      
      