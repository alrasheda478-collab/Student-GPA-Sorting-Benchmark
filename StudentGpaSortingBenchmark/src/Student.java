public class Student {
    private String studentName;
    private double gpa;
    private int studentId;

    public Student(String name, double gpa, int id){
        this.studentName = name;
        this.gpa = gpa;
        this.studentId = id;
    }

    public String getStudentName(){
        return studentName;
    }

    public double getGpa(){
        return gpa;
    }

    public int getStudentId(){
        return studentId;
    }
}
