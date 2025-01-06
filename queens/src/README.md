[Queens Solution 1](QueensSolution1.java)

**To analyze the given code, it was required to:**

1. **Add timing measurements to compute the elapsed time for execution**, i.e. execution time in milliseconds.
    ```java
    System.out.println("Execution time: " + (endTime - startTime) / 1_000_000 + " ms");
    ```
2. **Calculate the time complexity (Big-O notation) of the code.**

  **2.1. Recursive Backtracking (`solve`)**
  - For each column, the algorithm attempts all possible rows.
  - The algorithm recursively places a queen in a valid position and backtracks if needed.
  - In the worst case, there are \( n! \) permutations to check for \( n \)-queens.
  - The **time complexity** is \( O(n!) \), where \( n \) is the number of queens.

  **2.2. `isSafe` Function**
  - The `isSafe` function is called for each attempted placement.
  - It iterates through the list of already placed queens, which has a size of at most \( n - 1 \).
  - The complexity of `isSafe` is \( O(n) \).

  **3. Overall Complexity**
  - For each recursive call, \( O(n) \) is spent in `isSafe`.
  - With \( n! \) recursive calls in the worst case, the total time complexity is:
    \[
    O(n \cdot n!) = O(n!)
    \]

  **4. Space Complexity**
  - The space complexity is \( O(n) \), primarily due to the recursion stack and the current solution list.

---
***Execution Times (Empirical Approximation in milliseconds)***

| \( n \) (Number of Queens) | Execution Time | Notes                         |
|----------------------------|----------------|-------------------------------|
| 4                          | ~1 ms          | Solution is trivial.          |
| 8                          | ~5-10 ms       | Standard n-queens problem.    |
| 10                         | ~100 ms        | Computation becomes expensive.|
| 12                         | ~1-2 seconds   | Grows factorially.            |

---
### Optimizing the solution