public class Parcel {
  String name ="";
  int weight;
  double fee;
  public void printDetails(){
    if(name==null){
      System.out.println("Set name first");
    }
    else{
      System.out.println("Name: "+name);
      System.out.println("Total Weight: "+weight);
      System.out.println("Total Fee: "+fee);
    }
  }
  public Parcel(String name){
    this.name=name;
  }
  public Parcel(String name, int Weight){
    this.name=name;
    this.weight=Weight;
  }
  public double calcFee(String Location){
    if (Location.equals("Dhanmondi")){
      this.fee=(this.weight * 20) + 50;
    }
    else{
      this.fee=(this.weight * 20) ;
    }
    return this.fee ;
  }
  public void addWeight(double Weight){
    this.weight+=Weight;
    System.out.println("Updated Weight: "+this.weight);
  }
  public Parcel(){
  }
}
  
    
    
    