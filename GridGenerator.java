import java.util.*;
public class GridGenerator {
    public static int getRandomEven() {
        Random rand = new Random();
        int num = rand.nextInt(10) + 1; 
        return num * 2; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        while (true) {
            System.out.print("Enter array size (for NxN array): ");
            try {
                N = Integer.parseInt(sc.nextLine());

                if (N > 1) break;
                else System.out.println("Please enter a number greater than 1.");
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a valid integer.");
            }
        }
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = getRandomEven();
            }
        }
        System.out.println("\nGenerated 2D array:\n");
        printGrid(grid, -1); 
        int highlightNum = 0;
        while (true) {
            System.out.print("\nEnter a number to highlight (even number 2-20): ");
            try {
                highlightNum = Integer.parseInt(sc.nextLine());
                if (highlightNum >= 2 && highlightNum <= 20 && highlightNum % 2 == 0)
                    break;
                else
                    System.out.println("Please enter even number between 2 and 20!");
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        System.out.println("\nArray with " + highlightNum + " highlighted:\n");
        int count = printGrid(grid, highlightNum);

        System.out.println("\nNumber " + highlightNum + " appeared " + count + " time(s)");
    }
    public static int printGrid(int[][] grid, int highlightNum) {
        int N = grid.length;
        int count = 0;
        System.out.print("    ");
        for (int i = 0; i < N; i++) {
            System.out.printf("%02d ", i);
        }
        System.out.println();
        System.out.print("   +");
        for (int i = 0; i < N; i++) System.out.print("---");
        System.out.println("+");
        for (int i = 0; i < N; i++) {
            System.out.printf("%02d | ", i);
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == highlightNum) {
                    System.out.printf("[%02d] ", grid[i][j]);
                    count++;
                } else {
                    System.out.printf("%02d  ", grid[i][j]);
                }
            }
            System.out.println("|");
        }
        System.out.print("   +");
        for (int i = 0; i < N; i++) System.out.print("---");
        System.out.println("+");
        return count;
    }
}