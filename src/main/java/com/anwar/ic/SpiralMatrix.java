package com.anwar.ic;

/**
 * @author Anwar
 */

public class SpiralMatrix {


    // Function print matrix in spiral form
    static void spiralPrint(int rows, int columns, int a[][]) {
        int i, rowIndex = 0, columnIndex = 0;
        /*  rowIndex - starting row index
        rows - ending row index
        columnIndex - starting column index
        columns - ending column index
        i - iterator
        */

        while (rowIndex < rows && columnIndex < columns) {
            // Print the first row from the remaining rows
            for (i = columnIndex; i < columns; ++i) {
                System.out.print(a[rowIndex][i] + " ");
            }
            rowIndex++;

            // Print the last column from the remaining columns
            for (i = rowIndex; i < rows; ++i) {
                System.out.print(a[i][columns - 1] + " ");
            }
            columns--;

            // Print the last row from the remaining rows */
            if (rowIndex < rows) {
                for (i = columns - 1; i >= columnIndex; --i) {
                    System.out.print(a[rows - 1][i] + " ");
                }
                rows--;
            }

            // Print the first column from the remaining columns */
            if (columnIndex < columns) {
                for (i = rows - 1; i >= rowIndex; --i) {
                    System.out.print(a[i][columnIndex] + " ");
                }
                columnIndex++;
            }
        }
    }


    // driver program
    public static void main(String[] args) {
        int rows = 3;
        int columns = 6;
        int a[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(rows, columns, a);
    }
}
