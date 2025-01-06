[Queens Solution 1](QueensSolution1.java)

**To analyze the given code, it was required to:**

1. **Add timing measurements to compute the elapsed time for execution**, i.e. execution time in milliseconds.
    ```java
    System.out.println("Execution time: " + (endTime - startTime) / 1_000_000 + " ms");
    ```
2. **Calculate the time complexity (Big-O notation) of the code.**

  **2.1. Recursive Backtracking (`solve`)**
  - For each column, the algorithm attempts all possible rows.
    - The algorithm recursively places a queen in a valid position and backtracks if needed (undoing all previous queen placements and moving into next row of the starting column if needed, in case all possibilities were exhausted).
    - In the worst case, there are \( n! \) permutations to check for \( n \)-queens.
    - The **time complexity** is \( O(n!) \), where \( n \) is the number of queens.

  **2.2. `isSafe` Function**
  - The `isSafe` function is called for each attempted placement.
    - It iterates through the list of already placed queens, which has a size of at most \( n - 1 \).
    - The complexity of `isSafe` is \( O(n) \).

  **3. Overall Time Complexity**
  - For each recursive call, \( O(n) \) is spent in `isSafe`.
    - With \( n! \) recursive calls in the worst case, the total time complexity is:
      \[
      O(n multiplied by n!) = **O(n!)** because of the product rule
      \]

  **4. Space Complexity**
  - The space complexity is \( O(n) \), primarily due to the recursion stack and the current solution list.

***Execution Times (Empirical Approximation in milliseconds)***

| \( n \) (Number of Queens) | Execution Time | Notes                         |
|----------------------------|----------------|-------------------------------|
| 4                          | ~1 ms          | Solution is trivial.          |
| 8                          | ~5-10 ms       | Standard n-queens problem.    |
| 10                         | ~100 ms        | Computation becomes expensive.|
| 12                         | ~1-2 seconds   | Grows factorially.            |

---
### Optimizing the solution

[Queens Solution Optimized](QueensSolutionOptimized.java)

**The classic N-Queens problem has a time complexity of \( O(n!) \) due to its exhaustive backtracking approach.**

***Note that it's possible to optimize the code to reduce unnecessary checks and improve performance but the overall time complexity 
remains factorial according to the Product Rule because of the nature of the problem.***

Instead of checking all constraints manually in the `isSafe` function for every recursive call, it's possible to track which rows and diagonals are under attack using arrays or bitmasks, i.e.:

1. Use **bitmasks** or arrays to track which rows and diagonals are under attack.
    ```java
    int d1 = row - col + n - 1; // Left diagonal index
    int d2 = row + col;         // Right diagonal index

    if (!cols[col] && !diag1[d1] && !diag2[d2]) {
        // Place queen
        current.add(col + 1); // Store 1-based column index
        cols[col] = diag1[d1] = diag2[d2] = true;
    ```
2. Eliminate redundant list operations (e.g., `current.add` and `current.remove`).

**Key Optimizations**

1. **Track Attacks Efficiently**:
    - Instead of recalculating conflicts in `isSafe`, use arrays (`cols`, `diag1`, and `diag2`) to track which columns and diagonals are under attack. This reduces \( O(n) \) checks in `isSafe` to \( O(1) \).

2. **Avoid Redundant Operations**:
    - Use integer indices for rows and columns directly, avoiding unnecessary `add` and `remove` operations on `List`.

3. **Memory Efficiency**:
    - Tracking arrays are much more memory-efficient compared to recalculating constraints "but less readable" in terms of code maintenance.

### Time Complexity of Optimized Code

- **Recursive Calls**: Each recursive call places a queen in a valid position. The number of valid placements decreases as constraints increase.
- **Constraint Checking**: \( O(1) \) per call due to the use of tracking arrays.
- **Overall Complexity**: Remains \( O(n!) \) in the worst case, but the constant factors are significantly reduced, leading to practical performance improvements.

***Execution Times of Optimized Solution (Empirical Approximation in milliseconds)***

| \( n \) | Original Code Time | Optimized Code Time |
|--------|--------------------|--------------------|
| 8      | ~5 ms              | ~1-2 ms           |
| 10     | ~100 ms            | ~30-50 ms         |
| 12     | ~1-2 seconds       | ~300-500 ms       |

---

### Summary
While the time complexity of the N-Queens problem cannot fundamentally change due to its combinatorial nature, optimizations like tracking conflicts using arrays and reducing redundant operations can make the solution significantly faster and more efficient for larger inputs.