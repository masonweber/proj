/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Mason
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        int[][] board = new int[10][10]; //represents the 9x9 sudoku
        boolean[][] hasval = new boolean[10][10];
        Scanner s = new Scanner(System.in);
        // get values assigned to 9x9

        // fill rest of values in with 0
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                try {
                    System.out.print("Row " + i + ", Col " + j + ": ");
                    int k = s.nextInt();
                    board[i][j] = k;
                    if (board[i][j] > 0) {
                        hasval[i][j] = true;
                    }
                } catch (Exception e) {
                    board[i][j] = 0;
                }
            }
        }
        Sudoku su = new Sudoku(hasval);
        board = su.backtrack(board, 1, 1); //currently generates
        su.printboard(board);

    }
}
