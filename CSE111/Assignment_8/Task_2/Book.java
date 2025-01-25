package Task02;

public class Book {
    String Title="";
    double price;
    static int total_books_sold;
    static double total_revenue;
   
    public  Book(String name, double d){
        Title=name;
        price=150-150*(d/100);
        total_books_sold++;
        total_revenue+=price;
    }
    public void bookDetails(){
        System.out.println("Title: "+Title);
        System.out.println("Price after Discount: "+price);

    }

    
}
