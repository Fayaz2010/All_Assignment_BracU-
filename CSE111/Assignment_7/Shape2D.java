public class Shape2D  {
  public int length;
  public int breadth;
  public int base;
  public int height;
  double area;
  String name;
  public  Shape2D(int length){
    this.length=length;
    System.out.println("A Square has been created with ");
    System.out.println("length: "+this.length);
    area= length*length;
    name="Square";
  }
  public void area(){
    
    System.out.println("The area of the "+name+" is: "+area);
  }
  public  Shape2D(int length,  int breadth){
    this.length=length;
    this.breadth=breadth;
    area= length*breadth;
    name="Rectangle";
    System.out.println("A Rectangle  has been created with ");
    System.out.println("length: "+this.length+"and breadth:  "+this.breadth);
  }
  
  public Shape2D(int height, int base,String Triangle){
    area= 0.5*height*base;
    name="Triangle";
    System.out.println("A Triangle has been created with ");
    System.out.println("height: "+height+"and base:  "+base);
  }
  
  public  Shape2D(int a, int b,int c){
  
   double s = (a + c + b) / 2;
    area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    
    System.out.println("A Triangle has been created with ");
    System.out.println("the following sides: "+a+","+b+","+c);
  }
  
}
  
  
  
  
  
  
  
  
  
  
  