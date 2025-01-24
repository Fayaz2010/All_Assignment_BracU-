  //task a
import java.util.Scanner;
public class task7{
  public static void main(String[]args){
    Scanner sc =new Scanner (System.in);
    int x=sc.nextInt();
    int a=1,c=0;
    while(a<=x){
      int d=a;      
     System.out.print(a+" ");
     a+=c;
     c=d;
    }
    System.out.println();
    
      //task b
    
    int y=sc.nextInt();
    int e=1,f=0,sum=0;
    while(e<=y){
      int i=e;      
     System.out.print(e+" "); 
     sum+=e;
     e+=f;
     f=i;
    }
    System.out.println();
    System.out.println(sum);
  }
}