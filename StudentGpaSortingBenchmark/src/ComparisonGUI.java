import javax.swing.*;
import java.awt.*;

public class ComparisonGUI extends JFrame {

    private final JComboBox<Integer> sizeBox;
    private final JComboBox<String> typeBox;
    private final JComboBox<Integer> trialBox;

    private final JLabel insertionResult =
            new JLabel("Insertion Sort: --");

    private final JLabel mergeResult =
            new JLabel("Merge Sort: --");

    private final JLabel quickResult =
            new JLabel("Quick Sort: --");

    private final JLabel winnerResult =
            new JLabel("Winner: --");

    public ComparisonGUI() {

        setTitle("Sorting Algorithm Comparison");
        setSize(750, 550);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel(
                "Student GPA Sorting Comparison",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        title.setForeground(new Color(90 , 55 , 170));

        Integer[] sizes = {
                100, 250, 500, 750,
                1000, 1250, 1500, 1750,
                2000, 2250, 2500, 2750,
                3000, 3500, 4000, 4500,
                5000, 6000, 7000, 8000,
                9000, 10000, 12000, 15000
        };

        sizeBox = new JComboBox<>(sizes);
        sizeBox.setBackground(new Color(90 , 55 , 170));
        typeBox = new JComboBox<>(new String[]{"Random", "Sorted", "Reverse Sorted"});
        typeBox.setBackground(new Color(90 , 55 , 170));

        Integer[] trials = {1, 5, 10, 20, 30, 50, 100};

        trialBox = new JComboBox<>(trials);
        trialBox.setSelectedItem(10);
        trialBox.setBackground(new Color(90 , 55 , 170));
        JButton compareButton = new JButton("Compare Algorithms");
        compareButton.setBackground(new Color(245, 240 , 255));

        JPanel choices = new JPanel();
        choices.setBackground(new Color(245, 240 , 255));

        choices.add(new JLabel("Students:"));
        choices.add(sizeBox);
        sizeBox.setForeground(Color.WHITE);

        choices.add(new JLabel("Dataset:"));
        choices.add(typeBox);
        typeBox.setForeground(Color.WHITE);

        choices.add(new JLabel("Trials:"));
        choices.add(trialBox);
        trialBox.setForeground(Color.WHITE);

        JPanel results = new JPanel(new GridLayout(4, 1, 10, 10));

        results.setBackground(new Color(90 , 55 , 170));

        results.setBorder(BorderFactory.createTitledBorder("Results"));

        insertionResult.setFont(new Font("Arial", Font.PLAIN, 15));

        mergeResult.setFont(new Font("Arial", Font.PLAIN, 15));

        quickResult.setFont(new Font("Arial", Font.PLAIN, 15));

        winnerResult.setFont(new Font("Arial", Font.BOLD, 19));

        winnerResult.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        results.add(insertionResult);
        results.add(mergeResult);
        results.add(quickResult);
        results.add(winnerResult);

        insertionResult.setForeground(Color.WHITE);
        mergeResult.setForeground(Color.WHITE);
        quickResult.setForeground(Color.WHITE);
        winnerResult.setForeground(Color.WHITE);

        JPanel bottom = new JPanel();
        bottom.add(compareButton);
        bottom.setBackground(new Color(90 , 55 , 170));
        add(title, BorderLayout.NORTH);
        add(choices, BorderLayout.CENTER);
        add(results, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);

        compareButton.addActionListener(e -> compareAlgorithms());
    }

    private void compareAlgorithms() {

        int size =
                (Integer) sizeBox.getSelectedItem();

        String type =
                (String) typeBox.getSelectedItem();

        int trials =
                (Integer) trialBox.getSelectedItem();

        double insertionTotalTime = 0;
        double mergeTotalTime = 0;
        double quickTotalTime = 0;

        long insertionTotalComparisons = 0;
        long insertionTotalMovements = 0;

        long mergeTotalComparisons = 0;
        long mergeTotalMovements = 0;

        long quickTotalComparisons = 0;
        long quickTotalMovements = 0;

        for (int trial = 0; trial < trials; trial++) {

            Student[] original =
                    generateDataset(size, type);

            Student[] insertionArray = original.clone();

            Student[] mergeArray = original.clone();

            Student[] quickArray = original.clone();

            /*
             * Insertion Sort
             */

            InsertionSort.comparisons = 0;
            InsertionSort.movements = 0;

            long start = System.nanoTime();

            InsertionSort.sort(insertionArray);

            insertionTotalTime +=
                    (System.nanoTime() - start)
                            / 1_000_000.0;

            insertionTotalComparisons +=
                    InsertionSort.comparisons;

            insertionTotalMovements +=
                    InsertionSort.movements;

            /*
             * Merge Sort
             */

            MergeSort.comparisons = 0;
            MergeSort.movements = 0;

            start = System.nanoTime();

            MergeSort.sort(mergeArray);

            mergeTotalTime +=
                    (System.nanoTime() - start)
                            / 1_000_000.0;

            mergeTotalComparisons +=
                    MergeSort.comparisons;

            mergeTotalMovements +=
                    MergeSort.movements;

            /*
             * Quick Sort
             */

            QuickSort.comparisons = 0;
            QuickSort.movements = 0;

            start = System.nanoTime();

            QuickSort.sort(quickArray);

            quickTotalTime +=
                    (System.nanoTime() - start)
                            / 1_000_000.0;

            quickTotalComparisons +=
                    QuickSort.comparisons;

            quickTotalMovements +=
                    QuickSort.movements;
        }

        double insertionTime = insertionTotalTime / trials;

        double mergeTime = mergeTotalTime / trials;

        double quickTime = quickTotalTime / trials;

        long insertionComparisons = Math.round((double) insertionTotalComparisons / trials);

        long insertionMovements = Math.round((double) insertionTotalMovements / trials);

        long mergeComparisons = Math.round((double) mergeTotalComparisons / trials);

        long mergeMovements =
                Math.round(
                        (double) mergeTotalMovements
                                / trials
                );

        long quickComparisons =
                Math.round(
                        (double) quickTotalComparisons
                                / trials
                );

        long quickMovements =
                Math.round(
                        (double) quickTotalMovements
                                / trials
                );

        insertionResult.setText(String.format("<html><b>Insertion Sort</b><br>" + "Average Time: %.4f ms<br>" +
                                "Average Comparisons: %,d<br>" + "Average Movements: %,d</html>", insertionTime, insertionComparisons, insertionMovements));

        mergeResult.setText(String.format("<html><b>Merge Sort</b><br>" + "Average Time: %.4f ms<br>" + "Average Comparisons: %,d<br>" + "Average Movements: %,d</html>",
                        mergeTime, mergeComparisons, mergeMovements));

        quickResult.setText(String.format("<html><b>Quick Sort</b><br>" + "Average Time: %.4f ms<br>" + "Average Comparisons: %,d<br>" +
                                "Average Movements: %,d</html>", quickTime, quickComparisons, quickMovements));

        if (insertionTime <= mergeTime
                && insertionTime <= quickTime) {

            winnerResult.setText("Winner: Insertion Sort");

        } else if (mergeTime <= insertionTime
                && mergeTime <= quickTime) {

            winnerResult.setText("Winner: Merge Sort");

        } else {

            winnerResult.setText("Winner: Quick Sort");
        }
    }

    private Student[] generateDataset(
            int size,
            String type
    ) {

        if (type.equals("Sorted")) {

            return StudentGenerator
                    .generateSortedStudents(size);
        }

        if (type.equals("Reverse Sorted")) {

            return StudentGenerator
                    .generateReverseSortedStudents(size);
        }

        return StudentGenerator
                .generateStudents(size);
    }

    public static void main(String[] args) {

         new ComparisonGUI().setVisible(true);
    }
}