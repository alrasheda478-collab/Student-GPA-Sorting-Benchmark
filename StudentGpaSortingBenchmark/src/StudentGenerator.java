import java.util.Arrays;
import java.util.Random;

public class StudentGenerator {
    private static Random rand = new Random();

    // Case 1: random array
    private static String[] names = {"Aisha" , "Shahad" , "Ghanima" , "Khaled" , "Ahmed",
    "Jana" , "Yousef" , "Ali" , "Bader" , "Fatma" , "Abdullah" , "Mohammed" };

    public static Student[] generateStudents(int numOfStudents){
        Student[] students = new Student[numOfStudents];

        for(int i = 0 ; i < students.length ; i++){
            int id = 100000 + rand.nextInt(900000);

            String name = names[rand.nextInt(names.length)]; //Generate random name from names array

            double gpa = Math.round((rand.nextDouble() * 4.0) * 100.0) / 100.0; //Generate random GPA

            students[i] = new Student(name , gpa , id);
        }
        return students;
    }

    //Case 2: Sorted array
    public static Student[] generateSortedStudents(int numOfStudents){
        Student[] students = generateStudents(numOfStudents);
        InsertionSort.sort(students); //or any sorting algorithm used
        return students;
    }

    //Case 3: Reversely sorted array
    public static Student[] generateReverseSortedStudents(int numOfStudents){
        Student[] students = generateSortedStudents(numOfStudents);

        //Reverse the sorted array
        for(int i = 0 ; i < students.length / 2 ; i++){
            Student t = students[i];
            students[i] = students[students.length - 1 - i];
            students[students.length - 1 - i] = t;
        }
        return students;

    }


}
