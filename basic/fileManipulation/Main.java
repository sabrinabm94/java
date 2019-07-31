package fileManipulation;

import java.io.*;
import java.util.Scanner;
import javaRepositories.Print;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = null;
        String filePath = "C:\\Users\\smoreira\\Documents\\Documentos\\Trilhas e cursos\\Cursos\\java\\basic\\fileManipulation\\file.txt";

        file(filePath, fileScanner);
        bufferedReader(filePath, fileScanner);
    }

    private static void file(String filePath, Scanner fileScanner) throws IOException {
        try {
            //instancia um scanner a partir de um arquivo
            File file = new File(filePath);
            fileScanner = new Scanner(file);
            printFile(fileScanner, null, file);


        } catch (FileNotFoundException error) {
            error.printStackTrace();
            showErrorMessage(error.getMessage());
        } finally {
            if(fileScanner != null) {
                fileScanner.close();
            }
        }
    }

    private static void bufferedReader(String filePath, Scanner fileScanner) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        //instanciado a partir do file reader com melhorias e mais rapides
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            printFile(fileScanner, bufferedReader, null);

        }
        catch (IOException error) {
            error.printStackTrace();
            showErrorMessage(error.getMessage());
        }/*
        finally {
            try {
                if (bufferedReader != null) {
                    fileScanner.close();
                }
                if (fileReader != null) {
                    fileScanner.close();
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        }*/
    }

    private static void showErrorMessage(String error) {
        Print.println("Error: " + error);
    }

    private static void printFile(Scanner fileScanner, BufferedReader bufferedReader, File file) throws IOException {
        if(file != null) {
            Print.println("\nFileReader --------------------------------");
            //enquando haver conteúdo no arquivo
            while(fileScanner.hasNextLine()) {
                //são printadas as linhas do conteúdo
                Print.println("\n" + fileScanner.nextLine() + "\n");
            }
            Print.println("-------------------------------------------\n");
        } else if(bufferedReader != null) {
            String line = bufferedReader.readLine();

            Print.println("\nBufferedReader ----------------------------");
            while(line != null) {
                Print.println("\n" + line + "\n");
                line = bufferedReader.readLine();
            }
            Print.println("-------------------------------------------\n");
        }
    }
}
