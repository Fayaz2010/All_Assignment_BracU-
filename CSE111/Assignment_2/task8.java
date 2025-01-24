import java.util.Scanner;
public class task8{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    System.out.print("Give 1st integer");
    int x=sc.nextInt();
    System.out.print("Give 2nd integer");
    int y=sc.nextInt();
    int c=0,d=0;
    for (int i=x+1;i<y;i++){
      c=0;
      for(int j=2;j<i;j++){
        if(i%j==0){
          c++;
        }
      }
      if(c==0){
        d++;
      }
    }
    System.out.print("There are "+d+" prime numbers between "+x+" and "+y );
  }
}