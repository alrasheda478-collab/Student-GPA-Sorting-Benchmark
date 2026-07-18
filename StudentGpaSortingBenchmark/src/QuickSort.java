public class QuickSort {

    public static long comparisons = 0;
    public static long movements = 0;

    public static void sort(Student[] students) {
        quickSort(students, 0, students.length - 1);
    }

    private static void quickSort(Student[] students, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(students, low, high);

            quickSort(students, low, pivotIndex - 1);

            quickSort(students, pivotIndex + 1, high);
        }
    }

    private static int partition(Student[] students, int low, int high) {

        double pivot = students[high].getGpa();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            comparisons++;

            if (students[j].getGpa() <= pivot) {

                i++;

                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;

                movements += 3;   // one swap = 3 assignments
            }
        }

        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        movements += 3;   // final pivot swap

        return i + 1;
    }
}