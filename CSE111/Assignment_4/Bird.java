public class Bird {
  public String name;
  public void flyUp(int a){
  System.out.println(this.name+" has flown up "+a+" feet");
  }
  public void makeNoise(){
    if(this.name.equals("Parrot")){
    System.out.println("Squawk");
    }
     else if(this.name.equals("Eagle")){
     System.out.println("Squee");  
    }
  }
  public void flyDown(int a){
    if(this.name.equals("Parrot") && a==5){
      System.out.println(this.name+" cannot fly down "+a+" feet ");
    }
    else if(this.name.equals("Parrot") && a==1){
      System.out.println(this.name+" has flown down "+a+" feet and landed");
    }
    else if(this.name.equals("Eagle")){
      System.out.println(this.name+" has flown down "+a+" feet and landed");
    }
    else{
    System.out.println(this.name+" has flown down "+a+" feet");
    }
  }
}