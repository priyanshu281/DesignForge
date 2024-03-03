package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int m) {
        this.size = m;
        this.board = new PlayingPiece[size][size];

    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].piecetype.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

    public List<Pair<Integer, Integer>> getFreeCells(){
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i=0; i< size; i++){
            for(int j=0; j< size; j++){
                if(board[i][j] == null)  freeCells.add(new Pair(i,j));
            }
        }
        return freeCells;
    }
   public boolean addPiece(int row , int colummn, PlayingPiece playingpiece ){
        if(board[row][colummn] != null){
            return false;
        }else {
            board[row][colummn] = playingpiece;


            return true;
        }
   }

}
