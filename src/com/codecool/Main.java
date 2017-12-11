package com.codecool;

public class Main {

    public static void main(String[] args) {
        int size = 3;
        Minesweeper minesweeper = new Minesweeper(size);
        minesweeper.initTable();
        minesweeper.solveTable();

        for (char[] row : minesweeper.getTable()) {
            System.out.println(row);
        }

        for (char[] row : minesweeper.getSolvedTable()) {
            System.out.println(row);
        }

    }

}