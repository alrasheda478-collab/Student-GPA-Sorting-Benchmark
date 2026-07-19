public class MergeSort {

    public static long comparisons = 0;
    public static long movements = 0;

    public static void sort(Student[] students) {
        mergeSort(students);
    }

    private static void mergeSort(Student[] students) {

        int length = students.length;

        if (length <= 1) {
            return;
        }

        int middle = length / 2;

        Student[] leftArray = new Student[middle];
        Student[] rightArray = new Student[length - middle];

        for (int i = 0; i < middle; i++) {
            leftArray[i] = students[i];
            movements++;
        }

        for (int i = middle; i < length; i++) {
            rightArray[i - middle] = students[i];
            movements++;
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, students);
    }

    private static void merge(
            Student[] leftArray,
            Student[] rightArray,
            Student[] students) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArray.length &&
                j < rightArray.length) {

            comparisons++;

            if (leftArray[i].getGpa()
                    <= rightArray[j].getGpa()) {

                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }

            movements++;
            k++;
        }

        while (i < leftArray.length) {
            students[k] = leftArray[i];
            movements++;
            i++;
            k++;
        }

        while (j < rightArray.length) {
            students[k] = rightArray[j];
            movements++;
            j++;
            k++;
        }
    }
}