public class Course2{
    private String name;
    private String code;
    private int c=0;
    private String [] syllabus = new String[4];
       public void createCourse(String naam,String code){
           this.name=naam;
           this.code= code;
        }
       public void printDetails() {
        System.out.println("Course details:");
        System.out.println("Course Name: "+name);
        System.out.println("Course Code: "+code);
        System.out.println("Course Syllabus:");
        if (c==0) {
            System.out.println("No content yet.");
        }
        else{
          for(int i=0;i<c;i++){
             if (i==c-1){
                 System.out.println(syllabus[i]); 
                }
            else{
                System.out.print(syllabus[i] + ", ");
                  }
             }
       }
}
 public void addContent(String content) {
           if(c<4){
             syllabus[c]=content;
             c++;
             System.out.println(content + " was added.");
        }
          else{           
            System.out.println("Cannot add more content");
        }
   }
    public void addContent(String c1, String c2) {
           if(c<4) {
            syllabus[this.c]=c1;
            this.c++;
            System.out.println(c1+" was added.");
          }
           else{   
            System.out.println("Cannot add more content");
              }
           if(c<4){
             syllabus[this.c]=c2;
            this.c++;
             System.out.println(c2+ " was added.");
           }
           else{
             System.out.println("Cannot add more content");
          }
    }
}
