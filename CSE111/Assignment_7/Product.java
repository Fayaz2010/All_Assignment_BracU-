public class Product{
 String Name="Unknown";
 double Price;
 int Quantity; 
  public void displayInfo(){
    System.out.println("Product Name: "+this.Name);
    System.out.print("Price: $"+this.Price);
  }
  public Product(String Name, double Price){
    this.Name=Name;
    this.Price=Price;
  }
  public Product(){
  }
  public void displayInfo(boolean a){
    System.out.println("Product Name: "+this.Name);
    System.out.println("Price: $"+this.Price);
    System.out.println("Quantity: "+this.Quantity);
  }
  public int setQuantity(int Quantity){
    this.Quantity=Quantity;
    return this.Quantity;
  }
  public int getQuantity(){
   return this.Quantity;
  }
  public double getPrice(){
    return this.Price;
  }
}
    
    
    
    
