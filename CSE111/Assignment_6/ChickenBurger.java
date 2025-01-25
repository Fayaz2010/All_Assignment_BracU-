public class  ChickenBurger{
    public String bun="Sesame";
    public int price=200;
    public String sauceOption="Less";
    public String spiceLevel="Not Set";
    String [] spices={"Mild","Spicy","Naga","Extreme"};
    
    public String serveBurger(){
        if(spiceLevel.equals("Not Set")){
        return "Cannot serve now. Customize Spice Level first.";
        }else{
          return "The burger is being served:-\nBun Type: "+bun+"\nPrice: "+price+"\nSauce Option: "+sauceOption+"\nSpice Level: "+spiceLevel;
          }
        }
    public void customizedSpiceLevel(String str){
        for(int i=0;i<spices.length;i++){
            if(spices[i].equals(str)){
            this.spiceLevel=str;
            System.out.println("Spice level set to " +str);
            }
         }
          System.out.println("This spice level is unavailable.");
        
        }
      }

