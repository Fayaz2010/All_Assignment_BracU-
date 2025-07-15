public class AssignmentTask5 {

    //SUBMIT ONLY THIS METHOD
    public static void sumOddAppend(Node dh) {
        Node temp =dh.next;

        while((int)temp.elem%2==0){
            temp=temp.next;

        }
        dh.next=temp;
        temp.prev=dh;
        while(temp!=dh){
            if((int)temp.next.elem%2!=0){
                if(temp.next.next!=dh){
                temp.next=temp.next.next;
                temp.next.next.prev=temp;    

                }
                temp.next=temp.next.next;
                temp.next.next.prev=temp;        

            }
            temp=temp.next;
        }
        return;
    

        // TO DO
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
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
