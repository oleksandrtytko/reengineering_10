package com.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

    private final Board board;

    public GameRunner(int boardSize) {
        this.board = new Board(boardSize);
    }

    void playGame() {
        Scanner scan = new Scanner(System.in);

        BoardSymbol turn = BoardSymbol.X;

        System.out.println("Crosses and zeroes");
        board.printBoard();

        while (true) {
            System.out.println(" move " + turn + ", insert row and column");
            int row = scan.nextInt() - 1;
            int col = scan.nextInt() - 1;

            BoardSymbol selectedSymbol = board.getSymbol(row, col);
            if (selectedSymbol == BoardSymbol.X || selectedSymbol == BoardSymbol.O) {
                System.out.println("Occupied, try again");
                continue;
            }

            board.setSymbol(row, col, turn);

            if (gameOver(board)) {
                System.out.println("gameover! " + turn + " win!");
                break;
            }

            board.printBoard();
            turn = turn == BoardSymbol.X ? BoardSymbol.O : BoardSymbol.X;
        }
    }

    boolean gameOver(Board board) {
        List<BoardSymbol> auxDiagonal = new ArrayList<>();
        List<BoardSymbol> mainDiagonal = new ArrayList<>();
        for (int i = 0; i < board.getSize(); i++) {
            List<BoardSymbol> row = new ArrayList<>();
            List<BoardSymbol> column = new ArrayList<>();
            for (int j = 0; j < board.getSize(); j++) {
                row.add(board.getSymbol(i, j));
                column.add(board.getSymbol(j, i));
            }
            int auxDiagonalPosition = board.getSize() - 1 - i;
            mainDiagonal.add(board.getSymbol(auxDiagonalPosition, auxDiagonalPosition));
            auxDiagonal.add(board.getSymbol(i, i));
            if (checkIfListContainsAllEqualSymbols(row) || checkIfListContainsAllEqualSymbols(column)) {
                return true;
            }
        }
        return checkIfListContainsAllEqualSymbols(mainDiagonal) || checkIfListContainsAllEqualSymbols(auxDiagonal);
    }

    private boolean checkIfListContainsAllEqualSymbols(List<BoardSymbol> list) {
        BoardSymbol firstSymbol = list.get(0);
        return firstSymbol != BoardSymbol.BLANK && Collections.frequency(list, firstSymbol) == list.size();
    }
}
