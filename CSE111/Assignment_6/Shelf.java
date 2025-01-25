public class Shelf{
  int capacity;
  int booksnummber;
  public void showDetails(){
    System.out.println("Shelf capacity: "+capacity);
    System.out.println("Number of books: "+booksnummber);
  }
  public void addBooks(int a){
    booksnummber+=a;
    if(booksnummber<capacity){
    System.out.println(a+" books added to shelf");
    }
    else if(capacity==0){
     System.out.println("Zero capacity. Cannot add books.");
     booksnummber-=a;
    }
    else if(booksnummber>capacity){
     System.out.println("Exceeds capacity");
     booksnummber-=a;
    }
  }
}