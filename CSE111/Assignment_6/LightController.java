public class LightController{
  boolean Light;
  int brightness;
  public void showLightStatus(){    
    if (Light==true){ 
    System.out.println("Light status: ON");
    }
    else{
     System.out.println("Light status: OFF");
    }
    System.out.println("Brightness Level: "+brightness);
  }
  public void adjustBrightness(int a){
    if (Light==false){ 
      System.out.println("Please turn on the light first!");
    }
    else{
      
      brightness+=a; 
      if(brightness<=10){
        System.out.println("Brightness adjusted.");
      }
      else{
        brightness-=a; 
        System.out.println("Brightness out of range. Set between 0 to 10.");
      }
    }
  }
  public void switchLight(){
    if(Light ==false){ 
      Light= true;
      System.out.println("Lights are now ON");
      brightness=1;
    }
    else{
      Light=false;
      System.out.println("Lights are now OFF");
      brightness=0;
      }
  }
   public String resetSettings(){
    Light= true;
    brightness=1;
    return"Light settings have been reset.";
  }
}
    
      
      
      
      
      
      
      
  