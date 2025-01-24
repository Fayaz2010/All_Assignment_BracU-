//task a
public class task1{
  public static void main(String []args){
    int a=2;
    while(a<=50){
     
      if (a==50){
      System.out.print(a);
      break;
      }
      else{
        System.out.print(a+",");
         a+=4;
      }
    }
  //task b
    System.out.println();
    int b=1;
    int c=2;
    while(b<=120){
      if(b==120){
      System.out.print(b);
      break;
  }
      else{
        System.out.print(b+",");
        b=b+c;
      c++;
}
}
  }
}