import java.util.*;

class QueensSolutionOptimized {
    public static void mqueens(int n) {
        long startTime = System.nanoTime(); // Start timing

        List<List<Integer>> solutions = new ArrayList<>();
        // Tracking arrays for row and diagonal conflicts
        boolean[] cols = new boolean[n + 1]; // Index from 1 to n
        boolean[] diag1 = new boolean[2 * n + 1]; // Left diagonals (\)
        boolean[] diag2 = new boolean[2 * n + 1]; // Right diagonals (/)
        solve(n, 1, new ArrayList<>(), solutions, cols, diag1, diag2);

        if (solutions.isEmpty()) {
            System.out.print("-1");
        } else {
            for (List<Integer> solution : solutions) {
                System.out.print("[");
                for (int i = 0; i < solution.size(); i++) {
                    System.out.print(solution.get(i));
                    if (i < solution.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.print(" ] ");
            }
            System.out.println();
        }

        long endTime = System.nanoTime(); // End timing
        System.out.println("Execution time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void solve(int n, int row, List<Integer> current, List<List<Integer>> solutions,
                              boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row > n) { // Base case: All queens placed
            solutions.add(new ArrayList<>(current));
            return;
        }

        for (int col = 1; col <= n; col++) {
            int d1 = row - col + n; // Left diagonal index (\)
            int d2 = row + col;     // Right diagonal index (/)

            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place queen
                current.add(col); // Store 1-based column index
                cols[col] = diag1[d1] = diag2[d2] = true;

                solve(n, row + 1, current, solutions, cols, diag1, diag2);

                // Backtrack
                current.remove(current.size() - 1);
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Input the size of the board
        mqueens(n);
        in.close();
    }
}
