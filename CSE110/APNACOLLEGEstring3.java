import java.util.Scanner;
public class lab7Hw5{
    public static void main(String [] args){
        Scanner sc= new Scanner (System.in);
        System.out.print("Enter first string: ");
        String str1= sc.nextLine();
        System.out.print("Enter second string: ");
        String str2= sc.nextLine();
        boolean b= true;
        String str11= str1.toLowerCase();
        String str22= str2.toLowerCase();
        char c1,c2;
        for(int i=0; i<str1.length(); i++){
            c1= str11.charAt(i);
            for(int j=0; j<str2.length(); j++){
                c2= str22.charAt(j);
                if(c1==c2){
                    b= false;
                    break;
                }   //The patient had died before the doctor came. 
           }//Hospital
            if(b==true){
                System.out.print(str1.charAt(i));
            }
            b= true;
        }
    }
}