public class Course {
    private String courseName;
    private String courseCode;
    private int credits;
    public void createCourse(String a, String b, int c) {
        this.courseName = a;
        this.courseCode = b;
        this.credits = c;
    }  
    public void updateCourse(String a, String b, int c) {
        this.courseName = a;
        this.courseCode = b;
        this.credits = c;
    }

    public void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credits: " + credits);
    }
}
