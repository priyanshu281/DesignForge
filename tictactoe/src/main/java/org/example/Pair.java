package org.example;

public class Pair<T, U> {
    private T row;
    private U column;

    // Constructor
    public Pair(T row, U column) {
        this.row = row;
        this.column = column;
    }
}