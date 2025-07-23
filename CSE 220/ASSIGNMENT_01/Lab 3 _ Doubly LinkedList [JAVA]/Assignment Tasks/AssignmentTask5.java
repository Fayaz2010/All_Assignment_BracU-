public class AssignmentTask5 {

    
    public static void sumOddAppend(Node dh) {
        Node temp =dh.next;
        int sum=0;

       if((int)temp.elem%2!=0){
        sum+=(int)temp.elem;
        temp=temp.next;
        dh.next=temp;
        
       } 
        while(temp.next!=dh){
            if((int)temp.next.elem%2!=0){
                  sum+=(int)temp.next.elem;
                
                temp.next=temp.next.next;               

            }
            temp=temp.next;
        }
        Node newnode = new Node(sum);
        temp.next=newnode; 
       return;
    

    }

   
    public static void main(String[] args) {
        Object[] values = {11, 22, 33, 44, 55, 66};
        Node head = LinkedListHelpers.createDummyHeadedSinglyCircularLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
        System.out.println("\nExpected Output:");
        Object[] expected = {22, 44, 66, 99};
        Node expectedHead = LinkedListHelpers.createDummyHeadedSinglyCircularLL(expected, true);
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(expectedHead);
        
        //Running the Sum Odd Append
        sumOddAppend(head);
        //Printing after Sum Odd Append
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
    }
}
