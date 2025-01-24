import java.util.Scanner;
public class task2{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    int [] arr=new int[5];
    int max=0,min=0,a=0,b=0;
    for(int i=0; i<5; i++){
      int y=sc.nextInt();
      arr[i]=y;
    }
    for(int i=0;i<arr.length;i++){
      if(i==0){
        max=arr[i];
        min=arr[i];
        a=i;
        b=i;
      }
      else{
       if(arr[i]>max){
          max=arr[i];
          a=i;
      }
       if(arr[i]<max){
        max=max;
      }
       if(arr[i]<min){
          min=arr[i];
          b=i;
      }
      if(arr[i]>min){
        min=min;
      }
     }
    }
    System.out.println ("The largest number "+max+" was found at location "+a+".");
    System.out.println ("The smallest number "+min+" was found at location "+b+".");
  }
}

          
        
        