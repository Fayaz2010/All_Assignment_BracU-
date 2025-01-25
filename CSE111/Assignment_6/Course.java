public class Course {
    String name;
    String code;
    int c=0;
    String [] syllabus=new String[4];
   public void printDetails(){
      System.out.println("Course details:");
      System.out.println("Course Name: "+name);
      System.out.println("Course Code: "+code);
      System.out.print("Course Syllabus: ");
     if(c==0){
        System.out.println("No content yet.");
        }
     else{
         for(int i=0;i<c;i++) {
         if(i==c-1){         
           System.out.println(syllabus[i]);  
          } 
         else{
         System.out.print(syllabus[i] + ", ");            }
            }
        }
   }
    
   public void createCourse(String naam,String code){
         name=naam;
         this.code=code;
      }
    public void addOneContent(String a){
        if(c<4){
            syllabus[c]=a;
            c++;
            System.out.println(c+" was added.");
            }
           else{
            System.out.println("Cannot add more content");
         }
     }
public void addTwoContent(String c1, String c2) {
            if (c<4){
            syllabus[c]=c1;
            c++;
            System.out.println(c1+" was added.");
           } 
            else {
            System.out.println("Cannot add more content");
          }
        if(c<4){
            syllabus[c] = c2;
            c++;
            System.out.println(c2+ " was added.");
          }
         else{
            System.out.println("Cannot add more content");
        
          }
      }
}

