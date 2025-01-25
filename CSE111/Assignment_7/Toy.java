public class Toy {
  String name ="";
  int Price;
  public  Toy (String name,int Price){
    this.name =name;
    this.Price =Price;
    System.out.println("A new toy has been made!");
  }
  public int updatePrice(int Price){
    this.Price =Price;
    return  this.Price ;
  }
  public void updateName(String name){
    System.out.println("Changing old name: "+this.name);
    this.name =name;
    System.out.println("new name: "+this.name);
  }
  public void showPrice(){
    this.Price =Price;
    System.out.println("price: "+Price+"Taka");   
  }
}
  
  
  
  
  
  