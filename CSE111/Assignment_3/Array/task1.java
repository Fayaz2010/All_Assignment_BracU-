import java.util.Scanner;
public class task1{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    int j=0;
    boolean a=true;
    int x=sc.nextInt();
    int [] arr=new int[x];
    int [] arr1=new int[x-1];
    for(int i=0; i<x; i++){
      int y=sc.nextInt();
      arr[i]=y;
    }
    
    System.out.println ("input array");
    for(int i=0; i<arr.length;i++){
      System.out.print (arr[i]+" ");
    }
    System.out.println ();
    int z=sc.nextInt();
    for(int i=0; i<arr.length;i++){
      if(arr[i]==z){
          a=false;
      }
    }
      if(a==true){
        System.out.println ("Element not found");

    }
    if (a==false){
      System.out.println ("New array");
      for(int i=0; i<arr.length;i++){
        if(arr[i]!=z){
          arr1[j]=arr[i];
        System.out.print(arr1[j]+" ");
        j++; 
        }
       }
     }
   }
 }
