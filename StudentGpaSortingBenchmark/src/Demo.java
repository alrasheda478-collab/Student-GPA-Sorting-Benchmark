public class Demo {
    public static void runDemo() {
        Student[] students = StudentGenerator.generateStudents(10);
        Student[] insertionStudents = students.clone();
        Student[] mergeStudents = students.clone();
        Student[] quickStudents = students.clone();

        System.out.println("=========================================");
        System.out.println("         INSERTION SORT DEMO");
        System.out.println("=========================================");
        System.out.println("\nBefore Sorting:\n");
        printStudents(students);

        InsertionSort.comparisons = 0;
        InsertionSort.movements = 0;

        InsertionSort.sort(insertionStudents);
        System.out.println("\nAfter Sorting:\n");
        printStudents(insertionStudents);

        System.out.println("\nComparisons: " + InsertionSort.comparisons );
        System.out.println("Moves: " + InsertionSort.movements);

        System.out.println("\n=========================================");
        System.out.println("           MERGE SORT DEMO");
        System.out.println("=========================================");

        System.out.println("\nBefore Sorting:\n");
        printStudents(mergeStudents);

        MergeSort.comparisons = 0;
        MergeSort.movements = 0;

        MergeSort.sort(mergeStudents);

        System.out.println("\nAfter Sorting:\n");
        printStudents(mergeStudents);

        System.out.println("\nComparisons: " + MergeSort.comparisons);
        System.out.println("Moves: " + MergeSort.movements);

        System.out.println("\n=========================================");
        System.out.println("           QUICK SORT DEMO");
        System.out.println("=========================================");

        System.out.println("\nBefore Sorting:\n");
        printStudents(quickStudents);

        QuickSort.comparisons = 0;
        QuickSort.movements = 0;

        QuickSort.sort(quickStudents);

        System.out.println("\nAfter Sorting:\n");
        printStudents(quickStudents);

        System.out.println("\nComparisons: " + QuickSort.comparisons);
        System.out.println("Moves: " + QuickSort.movements);
    }

    private static void printStudents(Student[] students) {
        System.out.printf("%-10s %-20s %-5s%n",
                "ID", "NAME", "GPA");
        System.out.println("----------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-10d %-20s %.2f%n",
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getGpa());
        }
    }
}

