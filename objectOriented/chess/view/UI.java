package objectOriented.chess.view;

import javaRepositories.Print;
import objectOriented.chess.ChessMatch;
import objectOriented.chess.piece.attribute.ChessPosition;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Color;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    //https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void printBoard(ChessPiece[][] pieces) {
        for(int i = 0; i < pieces.length; i++) {
            Print.printf((8 - i) + " ");
            for(int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            Print.print("\n");
        }
        Print.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possiblePieceMoves) {
        Print.printf("\n");
        for(int i = 0; i < pieces.length; i++) {
            Print.printf((8 - i) + " ");
            for(int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possiblePieceMoves[i][j]); //se a peça na posição atual do tabuleiro tiver movimentação, terá o background azul nessa casa do tabuleiro
            }
            Print.print("\n");
        }
        Print.println("  a b c d e f g h");
    }

    public static void printPiece(ChessPiece piece, boolean background) {
        if(background) {
            Print.print(ANSI_BLUE_BACKGROUND);
        }
        if(piece == null) {
            Print.print("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) {
                Print.print(ANSI_WHITE + piece.getInitial() + ANSI_RESET);
            } else {
                Print.print(ANSI_YELLOW + piece.getInitial() + ANSI_RESET);
            }
        }
        Print.print(" ");
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> capturedPieces) {
        Print.println("\n");
        printBoard(chessMatch.getPieces());
        printCapituredPieces(capturedPieces);

        Print.println("\nTurn: " + chessMatch.getTurn());

        if(!chessMatch.getCheck()) {
            Print.println("Waiting player: " + chessMatch.getCurrentPlayerColor());

            if(chessMatch.getCheck()) {
                Print.print("You are in check risk!");
            }
        } else {
            Print.println("Checkmate!");
            Print.println("Winner: " + chessMatch.getCurrentPlayerColor());
        }
    }

    private static void printCapituredPieces(List<ChessPiece> capturedPieces) {
        List<ChessPiece> whiteCapturedPieces = capturedPieces.stream().filter(piece -> piece.getColor() == Color.WHITE).collect(Collectors.toList()); //adicionando a lista somente as peças brancas
        List<ChessPiece> blackCapturedPieces = capturedPieces.stream().filter(piece -> piece.getColor() == Color.BLACK).collect(Collectors.toList());

        Print.print("\nCaptured pieces");
        Print.println(ANSI_WHITE);
        Print.println("White: ");
        for(ChessPiece piece: whiteCapturedPieces) {
            Print.println(piece.getInitial());
        }
        Print.print(ANSI_RESET);

        Print.print(ANSI_YELLOW);
        Print.println("Black: ");
        for(ChessPiece piece: blackCapturedPieces) {
            Print.println(piece.getInitial());
        }
        Print.print(ANSI_RESET);
    }

    public static void clear() {
        Print.print("\033[H\033[2J");
        Print.clear();
    }

    public static ChessPosition readChessPosition(Scanner scanner) {
        try {
            String string = scanner.nextLine();
            char column = string.charAt(0);
            int row = Integer.parseInt(string.substring(1));
            return new ChessPosition(column, row);
        } catch(RuntimeException error) {
            throw new InputMismatchException("Error: The valid value are from a1 to h8.");
        }
    }
}
