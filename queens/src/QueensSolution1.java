import java.util.*;

class QueensSolution1 {
    public static void mqueens(int m) {
        long startTime = System.nanoTime();

        List<List<Integer>> solutions = new ArrayList<>();
        solve(m, new ArrayList<>(), solutions);

        if (solutions.isEmpty()) {
            System.out.print("-1");
        } else {
            for (List<Integer> solution : solutions) {
                System.out.print("["); // Add space before opening bracket
                for (int i = 0; i < solution.size(); i++) {
                    System.out.print(solution.get(i));
                    if (i < solution.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.print(" ] "); // Add space before closing bracket
            }
            System.out.println(); // Ensure a newline after all solutions are printed
        }

        long endTime = System.nanoTime(); // End timing
        System.out.println("Execution time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void solve(int m, List<Integer> current, List<List<Integer>> solutions) {
        if (current.size() == m) {
            solutions.add(new ArrayList<>(current));
            return;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(current, i)) {
                current.add(i);
                solve(m, current, solutions);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isSafe(List<Integer> current, int row) {
        int col = current.size() + 1; // 1-based column index
        for (int i = 0; i < current.size(); i++) {
            int placedRow = current.get(i);
            int placedCol = i + 1;

            // Check same row or diagonal conflict
            if (placedRow == row || Math.abs(placedRow - row) == Math.abs(placedCol - col)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        mqueens(m);
        in.close();
    }
}
