package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board boardObj;

    public Game() {

        initialiseGame();
    }

    public void initialiseGame() {
        this.players = new LinkedList<>();
        Player p1 = new Player("kyle", new PlayingPieceX());
        Player p2 = new Player("mini", new PlayingPieceO());
        this.boardObj = new Board(3);
        players.add(p1);
        players.add(p2);

    }

    public String startGame() {
        Boolean noWinner = true;
        while (noWinner) {


            Player activePlayer = players.removeFirst();
            boardObj.printBoard();
            List<Pair<Integer, Integer>> freeCells = boardObj.getFreeCells();
            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;

            }
            System.out.print("Player:" + activePlayer.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            Boolean pieceAddedSuccessfully = boardObj.addPiece(row, col, activePlayer.getPiece());
            if (!pieceAddedSuccessfully) {
                System.out.println("Incorrect position given , please provide the free positions");
                players.addFirst(activePlayer);
                continue;
            }
            players.addLast(activePlayer);

            Boolean winner = isThereWinner(row, col, activePlayer.piece.piecetype);

            if(winner){
                System.out.println("Winner is :"+activePlayer.name);
                return activePlayer.name;
            }

        }
        return "Tie";
    }

    public Boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for (int i = 0; i < boardObj.size; i++) {

            if (boardObj.board[row][i] == null || boardObj.board[row][i].piecetype != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for (int i = 0; i < boardObj.size; i++) {

            if (boardObj.board[i][column] == null || boardObj.board[i][column].piecetype != pieceType) {
                columnMatch = false;
            }
        }

        for (int i = 0; i < boardObj.size ; i++) {
            if(boardObj.board[i][i] == null || boardObj.board[i][i].piecetype != pieceType){
                diagonalMatch= false;
            }
        }
        for (int i=0 ; i< boardObj.size ; i++){
            if(boardObj.board[i][boardObj.size - 1 -i] == null || boardObj.board[i][boardObj.size - 1-i].piecetype != pieceType){
              antiDiagonalMatch= false;
            }
        }


        return  rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
