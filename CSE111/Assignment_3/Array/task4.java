import java.util.Scanner;
public class task4{
  public static void main(String[] args){
          Scanner scanner = new Scanner(System.in);
          System.out.print("Please enter the size of the array");
          int x = scanner.nextInt();
          int []arr = new int[x];
         System.out.println("Please enter any value");
         for(int i=0; i<x;i++){
            int y=scanner.nextInt();
            arr[i] =y;
            }
        for (int i=0; i<x;i++) {
                   int c=1;
                     if (arr[i]!=0) {
        for (int j=i+1;j<x;j++) {
               if (arr[i]==arr[j]) {
                    c++;
                      arr[j] = 0;
                     }
           }
              System.out.println(arr[i]+ " - "+c+" times");
         }
     }
  }
}