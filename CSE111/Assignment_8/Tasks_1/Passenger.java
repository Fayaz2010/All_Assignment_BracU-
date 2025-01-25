public class Passenger {
    String Name;
    double Fare;
    static int no_of_passenger;
    static double total_fare;
    public Passenger(String name, double fare){
        Name=name;
        Fare=fare*20;
        
        total_fare+=Fare;
    }
    public void passengerDetails(){
        System.out.println("Name "+Name);
        System.out.println("Fare "+Fare);
        
    }
    public void setBaggageWeight(double a){
        Fare=Fare+a*10;
        total_fare+=a*10;
    }
//    public  static int  no_of_passenger(){
//        return c;
//    }  
//    public static double total_fare(){
//        return x;
//    }
}
