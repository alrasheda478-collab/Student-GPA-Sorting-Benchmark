public class InsertionSort {

    public static long comparisons = 0;
    public static long movements = 0;

    public static void sort(Student[] students) {

        for (int i = 1; i < students.length; i++) {

            Student k = students[i];

            int j = i - 1;

            while (j >= 0) {

                comparisons++;

                if (students[j].getGpa() <= k.getGpa()) {
                    break;
                }

                students[j + 1] = students[j];
                movements++; // shifted one element

                j--;
            }

            students[j + 1] = k;
            movements++; // inserted key
        }
    }
}