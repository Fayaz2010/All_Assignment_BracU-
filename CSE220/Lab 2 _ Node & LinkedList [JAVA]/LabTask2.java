// LabTask2: Word Decoder
public class LabTask2 {
   
    // Must Submit this method
    // After you're done coding submit only this method
    public static Node wordDecoder( Node head ){
        int c=0;
        Node tem=head;
        Node dhead = new Node(null, null);
        while(tem!=null){
            c++;
            tem=tem.next;
        }
        Node tail;
        tem=head;
        int k= 13%c;
         if (k!=0) {
             c=0;
         }
           
             else{
                 c=1;
             }
        
       // Node tail=dhead;
        while(tem!=null){
            if(c%k==0 && c!=0){
                Node newNode= new Node(tem.elem);
               tail=tem;
                if(dhead.next==null){
                    dhead.next= newNode;
                    

                         
                }
                else{
                    newNode.next=dhead.next;
                    dhead.next=newNode;

                    
                }
            }
               tem=tem.next;
                c++;
        }
           return dhead;
    }




        
        
        //You're suppose to create a new Dummy headed Singly Linked List in this method
        //Dummy head is basically a head Node where the elem is null
        // Node dHead = new Node(null, null); here the dHead is a Dummy Head

        //TO DO

        //remove the following line when you're ready to return the new head
     

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT TOUCH THE DRIVER CODE BELOW
    public static void main(String[] args){
        System.out.println("==============Test Case 1=============");
        Node head = LinkedList.createList(new Character[]{'B', 'M', 'D', 'T', 'N', 'O', 'A', 'P', 'S', 'C'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> C -> A -> T");
        Node result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> C -> A -> T
        System.out.println();
        System.out.println("==============Test Case 2=============");
        head = LinkedList.createList(new Character[]{'Z', 'O', 'T', 'N', 'X'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> N");
        result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> N
        System.out.println();
    }
}
