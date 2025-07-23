// AssignmentTask4: ID Generator
public class AssignmentTask4{
  
    public static Node idGenerator(Node head1, Node head2, Node head3) {
        Node head= new Node(head1.elem);
        Node temp= head1.next;
        while(temp!=null){
            Node newnode =new Node(temp.elem);
            newnode.next=head;
            head=newnode;
            temp=temp.next;

        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;

        }
        Node temp1= head2;
        Node temp2=head3;
        while(temp1!=null){
            int sum=0;
            sum=(int)temp1.elem+(int)temp2.elem;
            if (sum>=10){
                sum=sum%10;
            }
            Node newnode=new Node(sum);
            curr.next=newnode;
            curr=newnode;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return head;

       } 


        

     
    public static void main(String[] args) {
        System.out.println("=========Test Case 1=============");
        Node head1 = LinkedList.createList(new Integer[]{0, 3, 2, 2});
        Node head2 = LinkedList.createList(new Integer[]{5, 2, 2, 1});
        Node head3 = LinkedList.createList(new Integer[]{4, 3, 2, 1});

        System.out.print("LinkedList#1:  ");
        LinkedList.printLL(head1); // This should print 0 -> 3 -> 2 -> 2

        System.out.print("LinkedList#2:  ");
        LinkedList.printLL(head2); // This should print 5 -> 2 -> 2 -> 1

        System.out.print("LinkedList#3:  ");
        LinkedList.printLL(head3); // This should print 4 -> 3 -> 2 -> 1

        Node result = idGenerator(head1, head2, head3);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result); // This should print 2 -> 2 -> 3 -> 0 -> 9 -> 5 -> 4 -> 2

        System.out.println("\n=========Test Case 2=============");
        Node head4 = LinkedList.createList(new Integer[]{0, 3, 9, 1});
        Node head5 = LinkedList.createList(new Integer[]{3, 6, 5, 7});
        Node head6 = LinkedList.createList(new Integer[]{2, 4, 3, 8});

        System.out.print("LinkedList#4:  ");
        LinkedList.printLL(head4); // This should print 0 -> 3 -> 9 -> 1

        System.out.print("LinkedList#5:  ");
        LinkedList.printLL(head5); // This should print 3 -> 6 -> 5 -> 7

        System.out.print("LinkedList#6:  ");
        LinkedList.printLL(head6); // This should print 2 -> 4 -> 3 -> 8

        Node result2 = idGenerator(head4, head5, head6);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result2); // This should print 1 -> 9 -> 3 -> 0 -> 5 -> 0 -> 8 -> 5
    }
}
