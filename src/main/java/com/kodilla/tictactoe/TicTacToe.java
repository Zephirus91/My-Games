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

            String result = checkWinner();
            if (result.length()>0) {
                System.out.println(result);
                break;
            }

            System.out.println("Enter values from 1 to 9:");
            int compPos = in.nextInt();
            while (urSet.contains(compPos) || compSet.contains(compPos)) {
                System.out.println();
                System.out.print("Retry, enter values from 1 to 9:");
                compPos = in.nextInt();
            }
            pHolder(gBoard, compPos, "Comp");


            if (result.length()>0) {
                System.out.println(result);
                break;
            }
        }
    }

    private static String checkWinner() {
        HashSet<Integer> r1 = new HashSet<>();
        r1.add(1);r1.add(2);r1.add(3);
        HashSet<Integer> r2 = new HashSet<>();
        r2.add(4);r2.add(5);r2.add(6);
        HashSet<Integer> r3 = new HashSet<>();
        r3.add(7);r3.add(8);r3.add(9);
        HashSet<Integer> c1 = new HashSet<>();
        c1.add(1);c1.add(4);c1.add(7);
        HashSet<Integer> c2 = new HashSet<>();
        c2.add(2);c2.add(5);c2.add(8);
        HashSet<Integer> c3 = new HashSet<>();
        c3.add(3);c3.add(6);c3.add(9);
        HashSet<Integer> d1 = new HashSet<>();
        d1.add(1);d1.add(5);d1.add(9);
        HashSet<Integer> d2 = new HashSet<>();
        d2.add(3);d2.add(5);d2.add(7);

        HashSet<HashSet> set = new HashSet<>();
        set.add(r1);set.add(r2);set.add(r3);
        set.add(c1);set.add(c2);set.add(c3);
        set.add(d1);set.add(d2);

        for (HashSet o:set) {
            if (urSet.containsAll(o))
                return "you won";
            else if (compSet.containsAll(o))
                return "comp won";
        }
        if (urSet.size()+ compSet.size()==9)
            return "draw";

        return "";
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
