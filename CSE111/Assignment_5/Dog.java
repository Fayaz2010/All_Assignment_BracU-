public class Dog{
  String name;
  String color;
  public void changeName(String a){
      this.name=a;
    }
  public void changeColor(String a){
      this.color=a;
      if (this.name==null){
        System.out.println("This dog is "+color);
      }
      else{
        System.out.println(this.name+" is "+color);
      }
    }
   public String bark(){
     if(this.name==null && this.color==null){
      return"A dog is barking";
     }
     else if(this.name==null){
       return this.color+" is barking";
     }
     else if(this.color==null){
       return this.name+" is barking";
     }
     else{
        return this.name+" the "+this.color+" dog is barking";
     }
   }
}
   
