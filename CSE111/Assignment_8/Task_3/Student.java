package task03;

public class Student {
    public static int TotalStudent;
    public static int CSEStudent;
    public static int Other_Department_Student;
    String Name="";
    double CGPA;
    String Department="";
    public static int ID;
    public static void printDetails(){
        System.out.println(TotalStudent);
        System.out.println(CSEStudent);
        System.out.println(Other_Department_Student);
    }
    public Student(String name,double cg){
        Name=name;
        CGPA=cg;
        Department="CSE";
        ID++;
        CSEStudent++;
        TotalStudent++;
    }
    public Student(String name ,double cg, String department){
        Name=name;
        CGPA=cg;
        Department=department;
        ID++;
        TotalStudent++;
        if(department.equals("CSE")){
            CSEStudent++;
        }
        else{
          Other_Department_Student++;
        }
    }
    public static Student createStudent(String name ,double cg, String department){
     Student h=new  Student(name,cg,department);
     return h;
    }
    public void individualDetail(){
        System.out.println(ID);
        System.out.println(Name);
        System.out.println(CGPA);
        System.out.println(Department);
    }
    
    
}
