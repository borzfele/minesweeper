package com.codecool;

import java.util.Random;

public class Minesweeper {

    private char[][] table;
    private char[][] solvedTable;

    public Minesweeper(int size) {
        if (size <= 1) {
            System.out.println("Table size unavailable.");
        }
        table = new char[size][size];
        solvedTable = new char[size][size];
    }

    public void initTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                Random random = new Random();
                if (random.nextBoolean()) {
                    table[i][j] = '*';
                } else {
                    table[i][j] = '.';
                }
            }
        }
    }

    public void solveTable() {
        int mineCount = 0;
        int firstRow;
        int lastRow;
        int firstColumn;
        int lastColumn;

        //iterálj végig a sorokon
        for (int i = 0; i < table.length; i++) {
            if (i == 0) {
                firstRow = i;
                lastRow = i + 1;
            } else if (i == table.length - 1) {
                firstRow = i - 1;
                lastRow = i;
            } else {
                firstRow = i - 1;
                lastRow = i + 1;
            }
            //element
            for (int j = 0; j < table[i].length; j++) {
                if (j == 0) {
                    firstColumn = j;
                    lastColumn = j + 1;
                } else if (j == table[i].length - 1) {
                    firstColumn = j - 1;
                    lastColumn = j;
                } else {
                    firstColumn = j - 1;
                    lastColumn = j + 1;
                }
                if (table[i][j] == '.') {

                    for (int k = firstRow; k <= lastRow ; k++) {
                        for (int l = firstColumn; l <= lastColumn ; l++) {
                            if (table[k][l] == '*') {
                                mineCount++;
                            }
                        }
                    }

                    int castableMineCount = mineCount + 48;
                    solvedTable[i][j] = (char) castableMineCount;

                } else {
                    solvedTable[i][j] = '*';
                    continue;
                }
                mineCount = 0;
            }
        }
    }

    public char[][] getTable() {
        return table;
    }

    public char[][] getSolvedTable() {
        return solvedTable;
    }
}
