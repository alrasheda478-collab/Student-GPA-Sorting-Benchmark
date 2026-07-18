import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("=================================");
            System.out.println("Student GPA sorting Benchmark");
            System.out.println("=================================");
            System.out.println("\nChoices: ");
            System.out.println("1. Run Demo");
            System.out.println("2. Run Benchmark");
            System.out.println("3. Open Comparison GUI ");
            System.out.println("4. Exit");
            System.out.println("Select an option: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Demo.runDemo();
                    break;

                case 2:
                    Benchmark.runBenchmark();
                    break;

                case 3:
                    ComparisonGUI.main(null);
                    break;
                case 4:
                    System.out.println("Exiting... ");
                    scan.close();
                    return;

                default:
                    System.out.println("invalid option");
            }
        }
    }
}
