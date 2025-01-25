public class MobilePhone {
    private int capacity; 
    private String [] names; 
    private int [] phones;   
    private int count;  
public void setContactCapacity(int capacity) {
        this.capacity = capacity;
        names=new String[capacity];
        phones=new int[capacity];
          }
public void addContact(String name,int Phone) {
           if(count<capacity){
            names[count]=name;
            phones[count]=Phone;
            System.out.println("The contact of "+ name+" is added.");
            count++;
            }
           else{
            System.out.println("Storage Full!!");
         }     
     }
 public void makeCall(int call) {
     for(int i=0;i<count;i++) {
         if(phones[i]==call) {
             System.out.println("Calling "+ names[i]);
          }
     } 
       System.out.println("Calling "+call);
  }
  public void details() {
     System.out.println("Total Contacts: "+count);
     System.out.println("Contact List:");
       for (int i=0;i<count;i++) {
          System.out.println(names[i]+":"+phones[i]);
        }
    }
}