import java.util.*;
public class array1{
  public static void main (String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String  [] arr=new String[n];
    for(int i=0;i<n;i++){
    arr[i]=sc.nextLine();
    }
    //String str1= Arrays.toString(arr);
    System.out.println(Arrays.toString(arr));
  }
}

      