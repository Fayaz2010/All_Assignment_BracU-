public class CellPhone{
    String model= "unknown";
    int Count=0;
    String [] arr= new String[3];
    
    public void printDetails(){
        System.out.println("Phone Model "+ this.model);
        System.out.println("Contacts Stored "+ this.Count);
        if(Count==3){
            for(int i=0; i<3; i++){
                System.out.println(arr[i]);
            }
        }
    }
    
    
    public void storeContact(String a){
        if(Count<3){
            arr[Count]= a;
            Count++;
        }else {
            System.out.println("Memory full. New contact can't be stored.");
        }
    }
}
