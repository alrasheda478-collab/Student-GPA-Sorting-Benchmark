public class MergeSort {

    public static long comparisons = 0;
    public static long movements = 0;

    public static void sort(Student[] students) {
        mergeSort(students, 0, students.length - 1);
    }

    private static void mergeSort(
            Student[] students,
            int left,
            int right) {

        if (left < right) {

            int mid = left + (right - left) / 2;

            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);

            merge(students, left, mid, right);
        }
    }

    private static void merge(
            Student[] students,
            int left,
            int mid,
            int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = students[left + i];
            movements++;
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = students[mid + 1 + j];
            movements++;
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            comparisons++;

            if (leftArray[i].getGpa()
                    <= rightArray[j].getGpa()) {

                students[k] = leftArray[i];
                movements++;
                i++;

            } else {

                students[k] = rightArray[j];
                movements++;
                j++;
            }

            k++;
        }

        while (i < n1) {
            students[k] = leftArray[i];
            movements++;
            i++;
            k++;
        }

        while (j < n2) {
            students[k] = rightArray[j];
            movements++;
            j++;
            k++;
        }
    }
}