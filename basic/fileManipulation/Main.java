package fileManipulation;

import java.io.*;
import java.util.Scanner;
import javaRepositories.Print;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = null;
        String filePath = "C:\\Users\\smoreira\\Documents\\Documentos\\Trilhas e cursos\\Cursos\\java\\basic\\fileManipulation\\file.txt";
        File file = new File(filePath);

        file(file, fileScanner);
        bufferedReader(filePath);
        buffedWriter(filePath);
        bufferedReader(filePath);
    }

    private static void file(File file, Scanner fileScanner) throws IOException {
        try {
            //instancia um scanner a partir de um arquivo
            fileScanner = new Scanner(file);
            printFile(fileScanner, null);

        } catch (FileNotFoundException error) {
            error.printStackTrace();
            showErrorMessage(error.getMessage());
        } finally {
            if(fileScanner != null) {
                fileScanner.close();
            }
        }
    }

    private static void bufferedReader(String filePath) {
        //BufferedReader: instanciado a partir do file reader com melhorias e mais rapidez
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            printFile(null,  bufferedReader);
        }
        catch (IOException error) {
            error.printStackTrace();
            showErrorMessage(error.getMessage());
        }
    }

    private static void buffedWriter(String filePath) {
        //FileWriter: stream de escrita de caracteres num arquivo
        //BufferedWriter: stream de escrita de caracteres num arquivo mais rápido
        String[] lines = new String[] {"", "Good morning", "Good afternoon", "Good night"};

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            for(String line: lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private static void showErrorMessage(String error) {
        Print.println("Error: " + error);
    }

    private static void printFile(Scanner fileScanner, BufferedReader bufferedReader) throws IOException {
        if(bufferedReader != null) {
            String line = bufferedReader.readLine();

            Print.println("\nBufferedReader ----------------------------");
            while (line != null) {
                Print.println("\n" + line + "\n");
                line = bufferedReader.readLine();
            }
            Print.println("-------------------------------------------\n");
        } else if(fileScanner != null){
            Print.println("\nFile --------------------------------");
            //enquando haver conteúdo no arquivo
            while(fileScanner.hasNextLine()) {
                //são printadas as linhas do conteúdo
                Print.println("\n" + fileScanner.nextLine() + "\n");
            }
            Print.println("-------------------------------------------\n");
        }
    }
}
