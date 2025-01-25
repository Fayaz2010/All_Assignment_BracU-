public class MoneyTracker {
  String name;
  double Balance;
  double x,y;
  public String info(){
    return "Name: "+this.name+"\nCurrent Balance: "+ this.Balance;

  }
  public void createTracker(String a){
    this.name=a;
    if(this.name!=null){
      this.Balance=1;
    }
//    this.name=a;
//    System.out.println(name);
//    System.out.println(Balance);
  }
  public void income(int a){
    this.x=a;
    System.out.println("Balance Updated!");
    this.Balance+=a;
    
  }
  public void expense(int a){
    
    
    this.Balance-=a;
    if(Balance>0){
      this.y=a;
      System.out.println("Balance Updated!");
    }
    if(Balance==0){
      System.out.println("You're broke!");
    }
    if(Balance<0){
      System.out.println("Not enough balance.");
    }
    
  }
  public void showHistory(){
    System.out.println("Last added: "+x);
    System.out.println("Last spent: "+y);
  }
}
  
    
    
    
    
    
    
    
    
    
  
    