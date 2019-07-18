package objectOriented.chess;

import objectOriented.chess.exception.ChessException;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.view.UI;
import javaRepositories.Print;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Position position = new Position();
        position.setRow(3);
        position.setColumn(5);
        position.print();

        Board board = new Board(3,5);
         */

        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            try {
                UI.printBoard(chessMatch.getPieces());
                ChessPosition origin = getOriginChessPosition(scanner);
                showPiecePossibleMoves(chessMatch, origin);
                ChessPosition target = getTargetChessPosition(scanner);
                performeChessMove(chessMatch, origin, target);
            } catch(ChessException error) {
                showExceptionErrorMessage(error.getMessage());
                pressEnterToContinue(scanner);
            } catch(InputMismatchException error) {
                showExceptionErrorMessage(error.getMessage());
                pressEnterToContinue(scanner);
            }
        }
    }

    public static ChessPosition getOriginChessPosition(Scanner scanner) {
        Print.print("\nEnter with piece origin position: ");
        return UI.readChessPosition(scanner);
    }

    public static ChessPosition getTargetChessPosition(Scanner scanner) {
        Print.print("\nEnter with piece target position: ");
        return UI.readChessPosition(scanner);
    }

    public static void showPiecePossibleMoves(ChessMatch chessMatch, ChessPosition origin) {
        boolean[][] possiblePieceMoves = chessMatch.possiblePieceMoves(origin);
        UI.printBoard(chessMatch.getPieces(), possiblePieceMoves);
    }

    public static ChessPiece performeChessMove(ChessMatch chessMatch, ChessPosition origin, ChessPosition target) {
        return chessMatch.performeChessMove(origin, target);
    }

    public static void showExceptionErrorMessage(String errorMessage) {
        Print.println("\n" + errorMessage);
    }

    public static void pressEnterToContinue(Scanner scanner) {
        Print.println("Press enter to continue");
        scanner.nextLine();
    }
}
