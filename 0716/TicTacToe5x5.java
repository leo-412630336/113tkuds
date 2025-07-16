import java.util.Scanner;

public class TicTacToe5x5{
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';


    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    static void printBoard(char[][] board) {
        System.out.println("\n  井字遊戲棋盤");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.printf("無效座標：(%d, %d) 超出範圍，請重新輸入！\n", row, col);
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用，請重新輸入！\n", row, col);
            return false;
        }
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    static char checkWinner(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            char first = board[row][0];
            boolean same = first != EMPTY;
            for (int col = 1; col < SIZE && same; col++) {
                if (board[row][col] != first) same = false;
            }
            if (same) return first;
        }

        for (int col = 0; col < SIZE; col++) {
            char first = board[0][col];
            boolean same = first != EMPTY;
            for (int row = 1; row < SIZE && same; row++) {
                if (board[row][col] != first) same = false;
            }
            if (same) return first;
        }

        char first = board[0][0];
        boolean same = first != EMPTY;
        for (int i = 1; i < SIZE && same; i++) {
            if (board[i][i] != first) same = false;
        }
        if (same) return first;

        first = board[0][SIZE - 1];
        same = first != EMPTY;
        for (int i = 1; i < SIZE && same; i++) {
            if (board[i][SIZE - 1 - i] != first) same = false;
        }
        if (same) return first;

        return EMPTY;
    }

    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;

        System.out.println("=== 5x5 井字遊戲開始 ===");

        while (true) {
            printBoard(board);
            System.out.printf("輪到玩家 %c，請輸入 row col (0~%d)：", currentPlayer, SIZE - 1);

            int row, col;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("輸入格式錯誤，請輸入兩個整數！");
                scanner.nextLine(); 
                continue;
            }

            if (placePiece(board, row, col, currentPlayer)) {
                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    printBoard(board);
                    System.out.printf("\n玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("\n平手！");
                    break;
                }
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
    }
}