package Task04;

public class Borrower {
    public static int book_count[] = {3, 3, 3};
    public static String book_name[] = {"Pather Panchali", "Durgesh Nandini", "Anandmath"};
  String Name;
  int c;
  public String [] borrowed_books=new String[3];

    public static void bookStatus(){
        System.out.println("Available Books: ");
      for (int i =0; i<3;i++){
        System.out.print(book_name[i]+": ");
        System.out.print(book_count[i]);
        System.out.println();
      }
    }
      public Borrower(String Name){
        this.Name=Name;

      }
      public void borrowBook(String book){
        for (int i=0; i<3; i++){
            if(book_name[i].equals("Name")){
                if(book_count[i]>0){
                    borrowed_books[c]=book;
                    book_count[i]--;
                    c++;
                }
                else{
                    System.out.println("This book is not available.");
                }
            }
        }
      }
      public void borrowerDetails(){
        System.out.println(Name);
        for (int i=0;i<borrowed_books.length;i++){
            System.out.println("Books Borrowed:");
            System.out.println(book_name[i]); 
        }
      }
      public static int remainingBooks(String name){
        for (int i=0;i<3;i++){
            if(book_name[i].equals(name)){
                   return book_count[i];   
            }
        }
        return 0;
    } 
 
}






