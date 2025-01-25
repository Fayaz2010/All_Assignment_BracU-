public class Book{
  String Title="";
  String Year="";
  String Author="";
  int Price;
  public Book(String Author){
    this.Author=Author;
    this.Title=Author;
  }
  public Book(String Year,String Author ){
    this.Year=Year;
    this.Author=Author;
    this.Title=Year+", Author: "+Author;
  }
  public Book(String Title,String Author,int Price ){
    this.Author=Author;
    this.Price=Price;
    this.Title=Title+", Author: "+ Author+", Price: "+Price;
  }
  public String setDetails(int a){
    this.Price= a;
    this.Title=this.Author+", Price: "+this.Price;
     return this.Title;
  }
  public String setDetails(String Author, int a){
    this.Price= a;
    this.Author=Author;
    this.Title=this.Year+", Author: "+this.Author+", Price: "+this.Price;
    return  this.Title; 
  }
  
  
   public void displayDetails(){
    System.out.println("Title: "+this.Title);
  }
}
    