# bigo
Time complexity and BigO compendium

---
### Time Complexity

**Time complexity measures how the runtime of an algorithm grows relative to the size of its input**. 
It evaluates the **efficiency of an algorithm by counting the number of fundamental operations 
(e.g., comparisons, assignments) performed as the input size \( n \) increases**.

#### Variants of Time Complexity

1. **Best-Case Time Complexity**
    - **The minimal time** an algorithm takes **to complete under optimal conditions.**
    - Example:
      ```java
      public int findFirst(int[] arr, int x) {
          if (arr[0] == x) return 0; // Best-case: \( O(1) \) if the element is at the start.
          for (int i = 1; i < arr.length; i++) {
              if (arr[i] == x) return i;
          }
          return -1;
      }
      ```

2. **Worst-Case Time Complexity**
    - **The maximum time an algorithm can take** to complete for any input.
    - Example:
        - In the above function, if \( x \) is not present or at the last position, the complexity is \( O(n) \).

3. **Average-Case Time Complexity**
    - **The expected runtime over all possible inputs of size \( n \).**
    - Example:
        - For searching, average-case occurs **when \( x \) is in the middle of the array**. The complexity is \( O(n) \), assuming uniform distribution of \( x \)'s position.

4. **Amortized Time Complexity**
    - **Evaluates the "average runtime" per operation over a sequence of operations, even if a single operation is expensive.**
    - Example:
        - Appending elements to a **dynamic array has an amortized time complexity of \( O(1) \), though "resizing" occurs occasionally with \( O(n) \) cost.**

---
### Big-O Notation: Definition and Variants

**Big-O notation expresses the "upper bound" of an algorithm's runtime**, representing **the worst-case growth rate of an algorithm as the input size increases**.

#### Common Big-O Complexities

1. **Constant Time \( O(1) \):**
    - **Execution time is "independent of input size"**.
    - Example:
      ```java
      public int getFirstElement(int[] arr) {
          return arr[0]; // Always takes the same time.
      }
      ```

2. **Logarithmic Time \( O(\log n) \):**
    - **Execution time "increases logarithmically with input size".**
    - Example:
        - Binary Search:
          ```java
          public int binarySearch(int[] arr, int x) {
              int low = 0, high = arr.length - 1;
              while (low <= high) {
                  int mid = (low + high) / 2;
                  if (arr[mid] == x) return mid;
                  if (arr[mid] < x) low = mid + 1;
                  else high = mid - 1;
              }
              return -1;
          }
          ```

3. **Linear Time \( O(n) \):**
    - **Execution time "grows linearly with input size".**
    - Example:
      ```java
      public int sumArray(int[] arr) {
          int sum = 0;
          for (int num : arr) sum += num;
          return sum;
      }
      ```

4. **Linearithmic Time \( O(n \log n) \):**
    - **Combines "linear and logarithmic growth"**.
    - Example:
        - Merge Sort, Quick Sort (average case):
          ```java
          Arrays.sort(arr); // Uses Timsort, which is O(n log n)
          ```

5. **Quadratic Time \( O(n^2) \):**
    - **Execution time "grows quadratically with input size".**
    - Example:
      ```java
      public void printPairs(int[] arr) {
          for (int i = 0; i < arr.length; i++) {
              for (int j = 0; j < arr.length; j++) {
                  System.out.println("(" + arr[i] + ", " + arr[j] + ")");
              }
          }
      }
      ```

6. **Exponential Time \( O(2^n) \):**
    - **Runtime "doubles with every additional input"**.
    - Example:
        - Solving the Traveling Salesman Problem with brute force.

7. **Factorial Time \( O(n!) \):**
    - Execution time grows as \( n \) factorial.
    - Example:
        - Generating all permutations of \( n \) elements.

---
### Relation Between Time Complexity and Big-O Notation

- **Time complexity "quantifies the exact growth of an algorithm's runtime".**
- **Big-O provides a simplified asymptotic "upper bound" for the runtime (worst case scenario)**.
- Example:
    - A nested loop that runs \( 3n^2 + 2n + 5 \) operations has a time complexity of \( O(n^2) \) (dominant term).

---

### Tools for Analyzing Big-O and Time Complexity in Java

1. **Manual Analysis in IntelliJ IDEA (Community Edition):**
    - Use comments and code inspection to identify loops and recursion.
    - Analyze the number of iterations and recursive calls.

2. **Big-O Calculation Tools:**
    - **[Big-O Calculator](https://bigocheatsheet.com):** For theoretical analysis and cheat sheets.
    - **JProfiler:** Monitors and visualizes performance bottlenecks in Java applications.

3. **Runtime Profiling:**
    - Measure execution time of code snippets:
      ```java
      long startTime = System.nanoTime();
      // Code to measure
      long endTime = System.nanoTime();
      System.out.println("Execution time: " + (endTime - startTime) + " ns");
      ```

4. **Libraries for Complexity Analysis:**
    - **Java Microbenchmark Harness (JMH):** Specifically designed for benchmarking Java code.

5. **Plugins and Extensions:**
    - IntelliJ IDEA Marketplace offers plugins like "Code Iris" to visualize code complexity.
    - Use static analysis tools (e.g., SonarLint) to identify code patterns that lead to high complexity.

---
***Example: Checking Big-O in IntelliJ IDEA***

To determine the complexity of this Java function:
```java
public int[] bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
}
```

1. **Manual Analysis:**
    - Outer loop: \( O(n) \)
    - Inner loop: \( O(n - i) \), leading to \( O(n^2) \).

2. **Static Analysis:**
    - Highlight and right-click to find usages or inspect code complexity.

3. **Benchmarking:**
    - Use the `System.nanoTime()` method or integrate JMH for accurate runtime analysis.

With this approach, you can systematically evaluate the performance of Java code in terms of Big-O and time complexity.

---
# Tools for Analyzing Big-O and Time Complexity in Deep

Analyzing the time complexity and Big-O notation of existing Java code is a challenging task that often requires manual inspection and theoretical analysis. Automated tools for this purpose are limited due to the inherent difficulty in determining an algorithm's complexity programmatically. However, several approaches and tools can assist in this process:

1. **Manual Analysis**: Review your code to identify loops, recursive calls, and other constructs that influence time complexity. Understanding the algorithm's structure is crucial for determining its Big-O notation. Resources like GeeksforGeeks provide tutorials on Big-O analysis, which can be helpful.

2. **Profiling Tools**: While profilers do not directly provide Big-O complexity, they can help identify performance bottlenecks by measuring execution time and resource usage. In Java, tools like VisualVM or JProfiler can be used to monitor the performance of your code. These tools offer insights into which parts of your code consume the most time, aiding in manual complexity analysis.

3. **Empirical Analysis**: By running your code with various input sizes and measuring execution times, you can empirically determine how the runtime scales. Plotting input sizes against execution times may reveal patterns indicative of specific time complexities (e.g., linear, quadratic). This method requires careful experimentation and is not always conclusive.

4. **Static Code Analysis Tools**: Some static analysis tools can detect code patterns that may lead to inefficient performance, such as nested loops or recursive calls. While they don't provide exact Big-O notations, they can highlight areas of concern. Tools like SonarQube offer static analysis capabilities for Java code.

It's important to note that fully automated determination of an algorithm's time complexity is generally not feasible due to the undecidable nature of the problem, as discussed in various computer science literature. Therefore, combining these tools with manual analysis and a solid understanding of algorithmic principles is the most effective approach.

[BigO Guide and Time Complexity](https://youtu.be/HfIH3czXc-8)