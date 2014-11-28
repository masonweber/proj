/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Mason
 */
public class Sudoku {

    boolean[][] rowPool, colPool, permanent;// boxPool;

    public Sudoku(boolean[][] new_permanent) {
        //pool assignment
        permanent = new boolean[10][10];
        rowPool = new boolean[10][10];
        colPool = new boolean[10][10];
        //boxPool = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                rowPool[i][j] = true;
                colPool[i][j] = true;
                permanent = new_permanent;
                //boxPool[i][j] = true;
            }
        }
    }

//    public boolean rowcheck(int row, int board[][]) {
//        for (int i = 1; i < 10; i++) {
//            int temp = board[row][i];
//            if (rowPool[row][temp]) {
//                rowPool[row][temp] = false;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean colcheck(int col, int board[][]) {
//        for (int i = 1; i < 10; i++) {
//            int temp = board[col][i];
//            if (colPool[col][temp]) {
//                colPool[col][temp] = false;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean boxcheck(int row, int col, int board[][]) {
//        boolean[] values = new boolean[10];
//        for (int i = 1; i < 10; i++) {
//            values[i] = true;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (values[board[row + i][col + j]]) {
//                    values[board[row + i][col + j]] = false;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public boolean progresscheck(int row, int col, int[][] board) {
        int lowrow = (((row - 1) / 3) * 3) + 1; // 1-3 = 1; 4-6 = 4; 7-9 = 7;
        int lowcol = (((col - 1) / 3) * 3) + 1; // 1-3 = 1; 4-6 = 4; 7-9 = 7;
        int checks = (3 * (row - lowrow)) + (col - lowcol); //numbers of squares above to check
        //int highrow = lowrow + (row%3); // 1-3 = 3?
        boolean cont = true;

        for (int i = 0; i < checks; i++) {
            int newrow = lowrow + (i / 3);
            int newcol = lowcol + (i % 3);

            if (board[row][col] == board[newrow][newcol]) {
                cont = false;
            }
        }

        return cont;
    }

    public int[][] backtrack(int board[][], int row, int col) {
        for (int k = 1; k < 10; k++) { //value iterative loop for backtracking
            boolean assigned = false;
//            boolean boxcheck = true;
            if (rowPool[row][k] && colPool[col][k]) {
                board[row][col] = k; //gives value 
                rowPool[row][k] = false;
                colPool[col][k] = false;
                assigned = true;
            } else if (permanent[row][col]) {
                assigned = true;
            }

//            if (row == 3) {
//                if (col == 3) {
//                    boxcheck = boxcheck(row, col, board);
//                } else if (col == 6) {
//                    boxcheck = boxcheck(row, col, board);
//                } else if (col == 9) {
//                    boxcheck = boxcheck(row, col, board);
//                }
//            } else if (row == 6) {
//                if (col == 3) {
//                    boxcheck = boxcheck(row, col, board);
//                } else if (col == 6) {
//                    boxcheck = boxcheck(row, col, board);
//                } else if (col == 9) {
//                    boxcheck = boxcheck(row, col, board);
//                }
//            } else if (row == 9) {
//                if (col == 3) {
//                    boxcheck = boxcheck(row, col, board);
//                } else if (col == 6) {
//                    boxcheck = boxcheck(row, col, board);
//                } else if (col == 9) {
//                    boxcheck = boxcheck(row, col, board);
//                }
//            }
            if (assigned && progresscheck(row, col, board)) {
                if ((row < 9) && (col < 9)) {
                    board = backtrack(board, row, col + 1);
                }
                if ((col == 9) && (row < 9)) {
                    board = backtrack(board, row + 1, 1);
                }
                if (row == 9) {
                    if ((col < 9)) {
                        board = backtrack(board, row, col + 1);                     
                    }
                }
                if ((row == 9) && (col == 9)) {
                    printboard(board);
                    
                    return board;
                }
            }

            if (board[row][col] == k) {
                rowPool[row][k] = true;
                colPool[col][k] = true;
            }
            printboard(board);
        }
//        for (int i = 0; i < 9; i++) {
//            System.out.print(board[row][i]);
//        }
//        System.out.println("");
//        System.out.println("bad?");
        return board; //shouldnt ever need this
    }

    public void printboard(int[][] board) {
        for (int i = 1; i < 10; i++) { //outer positional control loop
            for (int j = 1; j < 10; j++) { //inner positional control loop
                System.out.print(board[i][j]);
                if ((j%3 == 0) && (j < 9)) {
                    System.out.print(" | ");
                }
            }
            System.out.println("");
            if ((i%3 == 0) && (i < 9)) {
                for (int j = 1; j < 16; j++) {
                    System.out.print("-");
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
