//task01
import java.util.Scanner;
public class task9{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    int x =sc.nextInt();
    int c=0;
    while(x>0){
      x=x/10;
      c++;
    }
    System.out.print(c+" digits");
    
    //task b
        int y = sc.nextInt();
        int s;
        int d = 0;
        int div = 0;
        
        while (y> 0) {
            s = y;
            while (s>0){
                d++;
                s = s/10;
            }
            int power = d- 1;
            div = (int) Math.pow(10, power);
            System.out.print((y / div) * 7 + " ");
            y = y % div;
            d= 0;
            div = 0;

  }
}
}