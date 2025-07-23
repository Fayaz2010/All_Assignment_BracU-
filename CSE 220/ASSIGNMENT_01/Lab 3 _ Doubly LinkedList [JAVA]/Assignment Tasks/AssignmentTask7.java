public class AssignmentTask7 {

    
    public static void rangeMove(DNode dh, int start, int end) {
     
         DNode temp=dh.next;
      DNode curr=dh.next;

      int r1= start;
      int r2=end;
      while(curr.next!=dh){
        curr=curr.next;
      }
      
         
      while(temp!=curr){
        if ((int)temp.elem>=r1 && (int)temp.elem<=r2){
        DNode store= new DNode(temp.elem);
        DNode t2=temp.next;
        DNode t1=temp.prev;
        t1.next=t2;
        t2.prev=t1;
        DNode lastnode= dh.prev;
        
        store.next=dh;
        store.prev=lastnode;
        dh.prev=store;
        lastnode.next=store;
        

      }
      temp =temp.next;
      
        

      }

       
    }

    
    public static void main(String[] args) {
        Object[] values = {5, 3, 7, 1, 9, 6, 2, 4};
        DNode dh = LinkedListHelpers.createDummyHeadedDoublyLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);

        System.out.println("\nExpected Output:");
        Object[] expected = {3, 1, 9, 2, 4, 5, 7, 6};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);
        
        //Running the Range Move with [5,7] range 
        rangeMove(dh, 5, 7);
        //Printing after Range Move
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);
    }
}
