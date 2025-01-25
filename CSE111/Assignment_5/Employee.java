public class Employee{
  String name;
  int Salary=30000;
  String Designation="junior";
  public void newEmployee(String a){
    this.name=a;
  }
  
  public void displayInfo(){
    System.out.println("Employee Name: "+this.name);
    System.out.println("Employee Salary: "+this.Salary);
    System.out.println("Employee Designation: "+this.Designation);
  }
  public void calculateTax(){
    if(Salary<=30000){
      System.out.println("No need to pay tax");
    }
    else if(Salary>30000 && Salary<50000){
      System.out.println(this.name+"Tax Amount: "+Salary*.1);
    }
    else if(Salary>50000 ){
      System.out.println(this.name+"Tax Amount: "+Salary*.3);
    }
  }
  public void promoteEmployee(String a){
   this.Designation = a;
   if(Designation.equals("lead")){
     System.out.println(this.name+" has been promoted to lead");
     this.Salary+=50000;
     System.out.println("New Salary: "+Salary);
   }
   else if(Designation.equals("manager")){
      System.out.println(this.name+" has been promoted to manager");
      this.Salary+=75000;
      System.out.println("New Salary: "+Salary);
   }
  }
}
    
  
    
    
    
    
    
    
    
    