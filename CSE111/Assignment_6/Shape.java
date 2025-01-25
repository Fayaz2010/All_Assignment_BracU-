public class Shape{
       String name;
       double area;
  public void setParameters(String name, double r){
        this.name= name;
        area=3.1416*r*r;
  }
  public String details(){
        String shape= "Shape name: "+name +"\nArea: "+area;
        return shape;
  }
  public void setParameters(String x,double y,double z){
      name= x;
    area= .5*y*z;
  }
  public void setParameters(String a, double b1, double b2, double h){
      name= a;
      area= 0.5*(b1+b2)*h;
   }
}