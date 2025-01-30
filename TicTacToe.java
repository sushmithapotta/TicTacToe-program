import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        Scanner scanner = new Scanner(System.in);
        char player = 'X';

        while (true) {
            printBoard(board);
            makeMove(board, player, scanner);
            if (isWinner(board, player)) {
                printBoard(board);
                System.out.println("Player " + player + " wins!");
                break;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a tie!");
                break;
            }
            player = (player == 'X') ? 'O' : 'X';
        }
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void makeMove(char[][] board, char player, Scanner scanner) {
        int row, col;
        while (true) {
            System.out.print("Enter row (1-3): ");
            row = scanner.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            col = scanner.nextInt() - 1;

            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid move! Try again.");
            } else if (board[row][col] != '-') {
                System.out.println("Cell already occupied! Try again.");
            } else {
                board[row][col] = player;
                break;
            }
        }
    }

    public static boolean isWinner(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
