package com.kodilla.tictactoe;

import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe {

    static HashSet<Integer> urSet = new HashSet<Integer>();
    static HashSet<Integer> compSet = new HashSet<Integer>();

    public static void main (String args[]) {

        char [][] gBoard ={
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        printBoard(gBoard);
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter values from 1 to 9:");
            int userPos = in.nextInt();
            while (urSet.contains(userPos) || compSet.contains(userPos)) {
                System.out.println();
                System.out.print("Retry, enter values from 1 to 9:");
                userPos = in.nextInt();
            }
            pHolder(gBoard, userPos, "You");
        }
    }

    static void printBoard(char [][]gBoard) {
        for (int r = 0; r < gBoard.length; r++) {

            for (int c = 0; c < gBoard[0].length; c++) {

                System.out.print(gBoard[r][c]); //I'm printing my r(ow) and c(olumn)
            }
            System.out.println();
        }
    }

    static void pHolder(char [][] gBoard, int pos, String user) {

        char syb = ' ';
        if (user.equals("You")) {
            syb = 'X';
            urSet.add(pos);
        }
        else if (user.equals("Comp")) {
            syb = 'O';
            compSet.add(pos);
        }

        switch (pos) {
            case 1:
                gBoard[0][0] = syb;
                break;
            case 2:
                gBoard[0][2] = syb;
                break;
            case 3:
                gBoard[0][4] = syb;
                break;
            case 4:
                gBoard[2][0] = syb;
                break;
            case 5:
                gBoard[2][2] = syb;
                break;
            case 6:
                gBoard[2][4] = syb;
                break;
            case 7:
                gBoard[4][0] = syb;
                break;
            case 8:
                gBoard[4][2] = syb;
                break;
            case 9:
                gBoard[4][4] = syb;
                break;

            default:
                System.out.println("Please type number 1-9");
        }
        printBoard(gBoard); //everytime we place a value, it will print board
    }
}
