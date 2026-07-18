import javax.swing.*;
import java.awt.*;

public class ComparisonGUI extends JFrame {

    private final JComboBox<Integer> sizeBox;
    private final JComboBox<String> typeBox;


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
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel(
                "Student GPA Sorting Comparison",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        Integer[] sizes = {500, 1000, 2000, 2500, 3000, 4000, 4500, 5000, 6000, 6500, 7000,
                8000, 8500, 9000, 10000, 10500};

        sizeBox = new JComboBox<>(sizes);

        typeBox = new JComboBox<>(new String[]{
                "Random",
                "Sorted",
                "Reverse Sorted",
        });

        JButton compareButton =
                new JButton("Compare Algorithms");

        JPanel choices = new JPanel();

        choices.add(new JLabel("Students:"));
        choices.add(sizeBox);

        choices.add(new JLabel("Dataset:"));
        choices.add(typeBox);

        JPanel results = new JPanel(
                new GridLayout(4, 1, 10, 10)
        );

        results.setBorder(
                BorderFactory.createTitledBorder(
                        "Performance Results"
                )
        );

        insertionResult.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        mergeResult.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        quickResult.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        winnerResult.setFont(
                new Font("Arial", Font.BOLD, 19)
        );

        winnerResult.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        results.add(insertionResult);
        results.add(mergeResult);
        results.add(quickResult);
        results.add(winnerResult);

        JPanel bottom = new JPanel();
        bottom.add(compareButton);

        add(title, BorderLayout.NORTH);
        add(choices, BorderLayout.CENTER);
        add(results, BorderLayout.EAST);
        add(bottom, BorderLayout.SOUTH);

        compareButton.addActionListener(
                e -> compareAlgorithms()
        );
    }

    private void compareAlgorithms() {

        int size = (int) sizeBox.getSelectedItem();
        String type = (String) typeBox.getSelectedItem();

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

        double insertionTime =
                (System.nanoTime() - start)
                        / 1_000_000.0;

        long insertionComparisons =
                InsertionSort.comparisons;

        long insertionMovements =
                InsertionSort.movements;

        /*
         * Merge Sort
         */

        MergeSort.comparisons = 0;
        MergeSort.movements = 0;

        start = System.nanoTime();

        MergeSort.sort(mergeArray);

        double mergeTime =
                (System.nanoTime() - start)
                        / 1_000_000.0;

        long mergeComparisons =
                MergeSort.comparisons;

        long mergeMovements = MergeSort.movements;

        /*
         * Quick Sort
         */

        QuickSort.comparisons = 0;
        QuickSort.movements = 0;

        start = System.nanoTime();

        QuickSort.sort(quickArray);

        double quickTime =
                (System.nanoTime() - start)
                        / 1_000_000.0;

        long quickComparisons =
                QuickSort.comparisons;

        long quickMovements =
                QuickSort.movements;

        /*
         * Display results
         */

        insertionResult.setText(
                String.format(
                        "<html><b>Insertion Sort</b><br>" +
                                "Time: %.4f ms<br>" +
                                "Comparisons: %,d<br>" +
                                "Movements: %,d</html>",
                        insertionTime,
                        insertionComparisons,
                        insertionMovements
                )
        );

        mergeResult.setText(
                String.format(
                        "<html><b>Merge Sort</b><br>" +
                                "Time: %.4f ms<br>" +
                                "Comparisons: %,d<br>" +
                                "Movements: %,d</html>",
                        mergeTime,
                        mergeComparisons,
                        mergeMovements
                )
        );

        quickResult.setText(
                String.format(
                        "<html><b>Quick Sort</b><br>" +
                                "Time: %.4f ms<br>" +
                                "Comparisons: %,d<br>" +
                                "Movements: %,d</html>",
                        quickTime,
                        quickComparisons,
                        quickMovements
                )
        );

        if (insertionTime <= mergeTime
                && insertionTime <= quickTime) {

            winnerResult.setText(
                    "Winner: Insertion Sort"
            );

        } else if (mergeTime <= insertionTime
                && mergeTime <= quickTime) {

            winnerResult.setText(
                    "Winner: Merge Sort"
            );

        } else {

            winnerResult.setText(
                    "Winner: Quick Sort"
            );
        }
    }

    private Student[] generateDataset(
            int size,
            String type) {

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

        SwingUtilities.invokeLater(() ->
                new ComparisonGUI().setVisible(true)
        );
    }
}