public class Benchmark {

    public static void runBenchmark(){
        int[] sizes = {500, 1000, 2000, 2500, 3000, 4000, 4500, 5000, 6000, 6500, 7000,
                8000, 8500, 9000, 10000, 10500};

        int trials = 50;

        Student[][] students = new Student[sizes.length][];

        for (int i = 0; i < sizes.length; i++) {
            students[i] = StudentGenerator.generateStudents(sizes[i]);
        }

        System.out.println("\n\n==============================");
        System.out.println("       RANDOM DATASET");
        System.out.println("==============================");

        double insertionTotal = 0;
        double mergeTotal = 0;
        double quickTotal = 0;

        // ---------------- BENCHMARK ----------------
        System.out.println("\nINSERTION SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < students.length; i++) {
            insertionTotal += Benchmark.insertionTest(students[i], trials);
        }

        System.out.println("\nMERGE SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < students.length; i++) {
            mergeTotal += Benchmark.mergeTest(students[i], trials);
        }

        System.out.println("\nQUICK SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < students.length; i++) {
            quickTotal += Benchmark.quickTest(students[i], trials);
        }

        System.out.println();

        if (insertionTotal <= mergeTotal && insertionTotal <= quickTotal) {
            System.out.println("Winner: Insertion Sort");
        } else if (mergeTotal <= quickTotal) {
            System.out.println("Winner: Merge Sort");
        } else {
            System.out.println("Winner: Quick Sort");
        }


        System.out.println("\n\n==============================");
        System.out.println("        SORTED DATASET");
        System.out.println("==============================");

        insertionTotal = 0;
        mergeTotal = 0;
        quickTotal = 0;

        Student[][] sortedStudents = new Student[sizes.length][];

        for (int i = 0; i < sizes.length; i++) {
            sortedStudents[i] = StudentGenerator.generateSortedStudents(sizes[i]);
        }

        System.out.println("\nINSERTION SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < sortedStudents.length; i++) {
            insertionTotal += Benchmark.insertionTest(sortedStudents[i], trials);
        }

        System.out.println("\nMERGE SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < sortedStudents.length; i++) {
            mergeTotal += Benchmark.mergeTest(sortedStudents[i], trials);
        }

        System.out.println("\nQUICK SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");
        for (int i = 0; i < sortedStudents.length; i++) {
            quickTotal += Benchmark.quickTest(sortedStudents[i], trials);
        }

        System.out.println();

        if (insertionTotal <= mergeTotal && insertionTotal <= quickTotal) {
            System.out.println("Winner: Insertion Sort");
        } else if (mergeTotal <= quickTotal) {
            System.out.println("Winner: Merge Sort");
        } else {
            System.out.println("Winner: Quick Sort");
        }

        insertionTotal = 0;
        mergeTotal = 0;
        quickTotal = 0;

        System.out.println("\n\n==============================");
        System.out.println("   REVERSE SORTED DATASET");
        System.out.println("==============================");

        Student[][] reverseStudents = new Student[sizes.length][];

        for (int i = 0; i < sizes.length; i++) {
            reverseStudents[i] = StudentGenerator.generateReverseSortedStudents(sizes[i]);
        }

        System.out.println("\nINSERTION SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < reverseStudents.length; i++) {
            insertionTotal += Benchmark.insertionTest(reverseStudents[i], trials);
        }

        System.out.println("\nMERGE SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < reverseStudents.length; i++) {
            mergeTotal += Benchmark.mergeTest(reverseStudents[i], trials);
        }

        System.out.println("\nQUICK SORT PERFORMANCE BENCHMARK");
        System.out.println("----------------------------------------");
        System.out.printf("%-12s %-15s%n", "Students", "Average Time (ms)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < reverseStudents.length; i++) {
            quickTotal += Benchmark.quickTest(reverseStudents[i], trials);
        }

        System.out.println();


        System.out.println();

        if (insertionTotal <= mergeTotal && insertionTotal <= quickTotal) {
            System.out.println("Winner: Insertion Sort");
        } else if (mergeTotal <= quickTotal) {
            System.out.println("Winner: Merge Sort");
        } else {
            System.out.println("Winner: Quick Sort");
        }

    }

    public static double insertionTest(Student[] s, int trials) {

        double totalExecutionTime = 0;

        for (int i = 0; i < trials; i++) {

            Student[] copy = s.clone();

            long start = System.nanoTime();

            InsertionSort.sort(copy);

            long end = System.nanoTime();

            totalExecutionTime += (end - start) / 1_000_000.0;
        }

        double avg = totalExecutionTime / trials;

        System.out.printf("%-10d %.3f ms%n", s.length, avg);

        return avg;
    }


    public static double mergeTest(Student[] s, int trials) {

        double totalExecutionTime = 0;

        for (int i = 0; i < trials; i++) {

            Student[] copy = s.clone();

            long start = System.nanoTime();

            MergeSort.sort(copy);

            long end = System.nanoTime();

            totalExecutionTime += (end - start) / 1_000_000.0;
        }

        double avg = totalExecutionTime / trials;

        System.out.printf("%-10d %.3f ms%n", s.length, avg);

        return avg;
    }


    public static double quickTest(Student[] s, int trials) {

        double totalExecutionTime = 0;

        for (int i = 0; i < trials; i++) {

            Student[] copy = s.clone();

            long start = System.nanoTime();

            QuickSort.sort(copy);

            long end = System.nanoTime();

            totalExecutionTime += (end - start) / 1_000_000.0;
        }

        double avg = totalExecutionTime / trials;

        System.out.printf("%-10d %.3f ms%n", s.length, avg);

        return avg;
    }
}
