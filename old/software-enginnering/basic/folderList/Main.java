package folderList;

import java.io.*;
import java.util.Scanner;
import javaRepositories.Print;

public class Main {
    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        folder(fileScanner);
    }

    private static void folder(Scanner fileScanner) {
        try {
            String filePath = getfilePath(fileScanner);
            File file = new File(filePath);

            listFilesFromDirectory(file);
            listDirectoriesFromDirectory(file);
            createFolder(filePath);
            listDirectoriesFromDirectory(file);
        } catch (Error error) {
            error.printStackTrace();
        }
    }

    private static String getfilePath(Scanner fileScanner) {
        Print.println("Enter with the folders path: ");
        String filePath = fileScanner.nextLine();
        return filePath;
    }

    private static void printFile(File[] folders) {
        for(File folder: folders) {
            Print.println(folder + "");
        }
    }

    private static void showErrorMessage(String error) {
        Print.println("Error: " + error);
    }

    private static void listFilesFromDirectory(File file) {
        File[] files = file.listFiles(File::isFile);
        Print.println("\nListing files");
        printFile(files);
    }

    private static void listDirectoriesFromDirectory(File file) {
        File[] folders = file.listFiles(File::isDirectory); //listar somente diretórios/pastas
        Print.println("\nListing folders");
        printFile(folders);
    }

    private static void createFolder(String filePath) {
        boolean success = new File(filePath + "\\newFolder").mkdir();
        Print.println("\nCreate subfolder: " + success);
    }
}
