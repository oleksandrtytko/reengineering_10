package com.game;

public class Board {

    private final BoardSymbol[][] board;

    public Board(int boardSize) {
        board = new BoardSymbol[boardSize][boardSize];
        initializeBoard();
    }

    public void setSymbol(int x, int y, BoardSymbol symbol) {
        this.board[x][y] = symbol;
    }

    public BoardSymbol getSymbol(int x, int y) {
        return this.board[x][y];
    }

    public int getSize() {
        return board.length;
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = BoardSymbol.BLANK;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board.length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j].getValue() + " | ");
            }
        }
        System.out.println();
    }
}
