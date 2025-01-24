public class task22{
  public static void main(String[]args){
    int a =0;
    while(a<20){
      a+=2;
      System.out.print(a+",");      
    }
    while(a>2){
      a-=2;
      if(a==2){
        System.out.print(a);
      }
      else{
        System.out.print(a+",");
      }
    }
  }
}
    