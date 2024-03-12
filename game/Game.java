package game;

import java.util.*;
import player.Player;
import board.Board;

public class Game {
    Player[] players;
    Board board;
    int turn;
    int noOfmoves;
    boolean gameOver;
    String zero;
    String cross;

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfmoves = 0;
        this.gameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for (int i = 0; i < board.size; i++) {
            z.append('0');
            c.append('X');
        }
        this.zero = z.toString();
        this.cross = c.toString();
    }

    public void printBoardConfig() {
        int sz = this.board.size;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++)
                System.out.print(board.matrix[i][j] + " ");
            System.out.println();
        }
    }

    public void play() {
        printBoardConfig();

        int sz = board.size;
        while (gameOver == false) {
            noOfmoves++;
            int idx = getIdx();
            int row = idx / sz;
            int col = idx % sz;
            board.matrix[row][col] = players[turn].getSymbol();
            if (noOfmoves >= sz * sz) {
                System.out.println("Game draw!!");
                return;
            }
            if (checkComb() == true) {
                gameOver = true;
                printBoardConfig();
                System.out.println("Winner is " + players[turn].getName());
                return;
            }
            turn = (turn + 1) % 2;
            printBoardConfig();
        }
    }

    public int getIdx() {
        while (true) {
            int sz = board.size;
            System.out.println("Player :" + players[turn].getName() + " " + "give one pos");
            Scanner sc = new Scanner(System.in);
            int pos = sc.nextInt() - 1;
            int row = pos / sz;
            int col = pos % sz;
            if (row < 0 || row >= sz || col < 0 || col >= sz) {
                System.out.println("Invalid position");
                continue;
            } else if (board.matrix[row][col] != '_') {
                System.out.println("Already occupied");
                continue;
            } else
                return pos;
        }
    }

    public boolean checkComb() {
        int sz = board.size;
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[i][j]);
            }
            String patt = sb.toString();
            if (patt.equals(zero) || patt.equals(cross))
                return true;
        }
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[j][i]);
            }
            String patt = sb.toString();
            if (patt.equals(zero) || patt.equals(cross))
                return true;
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String patt = sb.toString();
        if (patt.equals(zero) || patt.equals(cross))
            return true;

        i = 0;
        j = sz - 1;
        sb = new StringBuilder();
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        patt = sb.toString();
        if (patt.equals(zero) || patt.equals(cross))
            return true;
        return false;
    }

}
