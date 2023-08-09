import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        char[] board = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char currentPlayer = 'X';
        int movesLeft = 9;
        Scanner  scanner = new Scanner(System.in);

        while (true) {
            // Display the board
            for (int i = 0; i < 9; i += 3)
                System.out.println(board[i] + " | " + board[i + 1] + " | " + board[i + 2]);

            // Check for a win
            for (int i = 0; i < 9; i += 3) {
                if (board[i] == board[i + 1] && board[i] == board[i + 2]
                        || board[i / 3] == board[i / 3 + 3] && board[i / 3] == board[i / 3 + 6]
                        || board[0] == board[4] && board[0] == board[8]
                        || board[2] == board[4] && board[2] == board[6]) {
                    System.out.println(currentPlayer + " wins!");
                    return;
                }
            }

            if (movesLeft == 0) {
                System.out.println("It's a draw!");
                return;
            }

            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt() - 1;

            if (move < 0 || move >= 9 || board[move] == 'X' || board[move] == 'O') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[move] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            movesLeft--;
        }
    }
}