package objectOriented.chess;

import objectOriented.chess.piece.attribute.ChessPosition;
import objectOriented.chess.exception.ChessException;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.view.UI;
import javaRepositories.Print;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        List<ChessPiece> capturedPieces = new ArrayList<>();

        while(!chessMatch.getCheck()) {
            try {
                UI.clear();
                UI.printMatch(chessMatch, capturedPieces);

                ChessPosition origin = getOriginChessPosition(scanner);
                showPiecePossibleMoves(chessMatch, origin);
                ChessPosition target = getTargetChessPosition(scanner);

                ChessPiece capturedPiece = performeChessMove(chessMatch, origin, target);
                if(capturedPiece != null) {
                    capturedPieces.add(capturedPiece);
                }

                if(chessMatch.getPromoted() != null) {
                    String type = getTypeToPromotion(scanner);
                    chessMatch.replacePromotedPiece(type, chessMatch.getPromoted());
                }
            } catch(ChessException error) {
                showExceptionErrorMessage(error.getMessage());
                pressEnterToContinue(scanner);
            } catch(InputMismatchException error) {
                showExceptionErrorMessage(error.getMessage());
                pressEnterToContinue(scanner);
            }
        }

        UI.clear();
        UI.printMatch(chessMatch, capturedPieces);
    }

    private static ChessPosition getOriginChessPosition(Scanner scanner) {
        Print.print("\nEnter with piece origin position: ");
        return UI.readChessPosition(scanner);
    }

    private static ChessPosition getTargetChessPosition(Scanner scanner) {
        Print.print("\nEnter with piece target position: ");
        return UI.readChessPosition(scanner);
    }

    private static void showPiecePossibleMoves(ChessMatch chessMatch, ChessPosition origin) {
        boolean[][] possiblePieceMoves = chessMatch.possiblePieceMoves(origin);
        UI.printBoard(chessMatch.getPieces(), possiblePieceMoves);
    }

    private static ChessPiece performeChessMove(ChessMatch chessMatch, ChessPosition origin, ChessPosition target) {
        return chessMatch.performeChessMove(origin, target);
    }

    private static void showExceptionErrorMessage(String errorMessage) {
        Print.println("\n" + errorMessage);
    }

    private static void pressEnterToContinue(Scanner scanner) {
        Print.println("Press enter to continue");
        scanner.nextLine();
    }

    private static String getTypeToPromotion(Scanner scanner) {
        Print.println("Enter with the piece to promotion (B/N/R/Q)");
        return scanner.nextLine();
    }
}
