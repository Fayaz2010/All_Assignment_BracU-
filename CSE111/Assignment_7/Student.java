package Task07;

public class Student {
  private int id;
  private double cgpa=0.0;
  private String[] course =new String[4];
  private int count;

public Student(int id) {
      this.id = id;
  } 
public Student(int x, double a) {
      this.id=x;
      this.cgpa=a;   
  }
public void setCG(double a) {
      this.cgpa=a;
  }

public void setID(int x) {
      this.id = x;
      this.course = new String[4];  
      this.count=0;        
  }

public void addCourse(String c) {
   if(cgpa==0){
      System.out.println("Failed to add " + c);
      System.out.println("Set CG first");
     }
     else if(count == 4){
      System.out.println("Failed to add " + c);
      System.out.println("Maximum 4 courses allowed.");
        }else if(cgpa<3 && count==3){
           System.out.println("Failed to add "+c);
             System.out.println("CG is low. Can't add more than 3 courses.");
          }
          else{
            this.course[count]=c;
              count++;
           }

    }
public void addCourse(String [] courseArr) {
    for (int i=0;i<courseArr.length;i++) {
      addCourse(courseArr[i]);
      }
  }
public void rmAllCourse(){
      this.course = new String[4];
      this.count = 0;
  }
public void showAdvisee(){
      System.out.println("Student ID: " +id+", CGPA: "+cgpa);
      if (count==0){
          System.out.println("No courses added.");
         }
         else{    
             System.out.print("Added courses are: ");
              for(int i=0;i<count; i++) {
              System.out.print(course[i]+" ");
            }
         System.out.println();
      }
  }
}

