import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        //variáveis
        int option;

        //variáveis para definição do arquivo
        String line;
        int linesNumber = 0;
        int lineNumber = 0;

        //variáveis para definição do AFND
        Vector<String> states = new Vector<String>();
        Vector<String> alphabet = new Vector<String>();
        String initialState = "";
        String finalState = "";

        //variáveis para criação da matriz
        int matrixColumnSize = 3;
        int matrixLineSize = 4;
        String matrix[][] = new String[matrixLineSize][matrixColumnSize];

        try {
            //leitura do arquivo, ele tem que estar na raiz do projeto junto com o main
            FileReader reader = new FileReader("config.txt");
            BufferedReader buffer = new BufferedReader(reader, 2 * 1024 * 1024);

            //lê a primeira linha do arquivo
            line = buffer.readLine();

            //conta o total de linhas
            Path path = Paths.get("./config.txt");
            linesNumber = ((int) Files.lines(path).count());

            //continua em quanto houver linhas no documeto
            while(line != null) {
                //divide o conteúdo das linhas em entradas num array
                Vector<String> splitResults = new Vector<String>();
                splitResults.addAll(Arrays.asList(line.split(" ")));

                //extrai o valor das variáveis das linhas
                if(lineNumber == 0) {
                    //estados
                    states = splitResults;

                    //contador para controle de qual linha esta sendo lida
                    lineNumber = lineNumber + 1;

                    //vai para a próxima linha
                    line = buffer.readLine();
                    Thread.sleep(1000);
                } else if(lineNumber == 1) {
                    //alphabet
                    alphabet.addAll(splitResults);

                    //qualquer AFND tem sempre o ε em seu alfabeto
                    alphabet.add("ε");

                    //contador para controle de qual linha esta sendo lida
                    lineNumber = lineNumber + 1;

                    //vai para a próxima linha
                    line = buffer.readLine();
                    Thread.sleep(1000);
                } else if(lineNumber == linesNumber - 1) {
                    //estado final
                    finalState = line;

                    //contador para controle de qual linha esta sendo lida
                    lineNumber = lineNumber + 1;

                    //vai para a próxima linha
                    line = buffer.readLine();
                    Thread.sleep(1000);
                } else if(lineNumber == linesNumber - 2) {
                    //estado inicial
                    initialState = line;

                    //contador para controle de qual linha esta sendo lida
                    lineNumber = lineNumber + 1;

                    //vai para a próxima linha
                    line = buffer.readLine();
                    Thread.sleep(1000);
                } else {
                    //organização dos caminhos dos estados em matriz
                    for (int matrixLine = 0; matrixLine < matrixLineSize; matrixLine++) {
                        for (int matrixColumn = 0; matrixColumn < matrixColumnSize; matrixColumn++) {
                            /*
                            if(line.split("\\s+").length > 1) {
                                for(String result: splitResults) {
                                    //caso cada linha tenha mais de um resultado, adiciona na proxima coluna
                                    matrix[matrixLine][matrixColumn] = result;
                                    matrixColumn = matrixColumn + 1;
                                }
                            } else {
                                //caso a linha só tenha um resultado
                                matrix[matrixLine][matrixColumn] = line;
                            }*/

                            //adiciona os valores na matriz por linha x coluna
                            matrix[matrixLine][matrixColumn] = line;

                            //contador para controle de qual linha esta sendo lida
                            lineNumber = lineNumber + 1;

                            //vai para a próxima linha
                            line = buffer.readLine();
                            Thread.sleep(1000);
                        }
                    }
                }
            }

            Scanner enterData = new Scanner(System.in);
            do {
                System.out.println("|============================|");
                System.out.println("|             AFND           |");
                System.out.println("|============================|");
                System.out.println("| 1 ----> Executar entrada   |");
                System.out.println("| 2 ----> Sair               |");
                System.out.println("|============================|");
                System.out.print("Informe a opção desejada: ");
                option = enterData.nextInt();

                switch (option){
                    case 1:
                        //variáveis para definição dos simbolos de entradas
                        Vector<String> symbols = new Vector<String>();
                        String symbol;

                        //variáveis para compor documento com resultados
                        Vector<String> currentStates = new Vector<String>();
                        Vector<String> readSymbols = new Vector<String>();
                        String stateOne = "";
                        String stateTwo = "";
                        Boolean accept = false;
                        String content;

                        //solicitação de entrada de simbolos
                        Scanner scanner = new Scanner(System.in);
                        System.out.printf("Digite um simbolo (0 ou 1) por linha. \nQuando finalizar as entrads, digite a palavra 'fim' e pressione enter. \n");
                        while(scanner.hasNext()){
                            symbol = scanner.next();
                            if(symbol.equals("fim")){
                                break;
                            } else {
                                if(!alphabet.contains(symbol)) {
                                    System.out.printf("O programa será finalizado pois foi encontrado um simbolo inválido: "  + symbol + "\n");
                                    option = 2;
                                    break;
                                } else {
                                    symbols.add(symbol);
                                }
                            }
                        }

                        if(option == 1) {
                            System.out.println("\nOs simbolos que serão executados são: " + symbols);
                        }

                        //execução dos simbolos
                        for(int symbolCounter = 0; symbolCounter < symbols.size(); symbolCounter++) {
                            if (symbolCounter == 0) {
                                stateOne = initialState;
                            }

                            //alteração dos estados
                            if(symbols.get(symbolCounter).equals("0")) {
                                if(stateOne.equals("q1")) {
                                    stateOne = matrix[0][0];
                                } else if(stateOne.equals("q2")) {
                                    stateOne = matrix[1][0];
                                }
                                else if(stateOne.equals("q3")) {
                                    stateOne = matrix[2][0];
                                }
                                else if(stateOne.equals("q4")) {
                                    stateOne = matrix[3][0];
                                }
                            } else if(symbols.get(symbolCounter).equals("1")) {
                                if(stateOne.equals("q1")) {
                                    //como tem 2 estados nessa posição da matriz, separo em 2 variáveis
                                    String[] statesOptions = matrix[0][1].split(" ");
                                    stateOne = statesOptions[0];

                                    //como tem 2 estados possíveis, suas duas possibilidades serão executadas
                                    if(stateTwo.equals("")) {
                                        stateTwo = statesOptions[1];
                                    }
                                } else if(stateOne.equals("q2")) {
                                    stateOne = matrix[1][1];
                                }
                                else if(stateOne.equals("q3")) {
                                    stateOne = matrix[2][1];
                                }
                                else if(stateOne.equals("q4")) {
                                    stateOne = matrix[3][1];
                                }
                            } else if(symbols.get(symbolCounter).equals("ε")) {
                                if(stateOne.equals("q1")) {
                                    stateOne = matrix[0][2];
                                } else if(stateOne.equals("q2")) {
                                    stateOne = matrix[1][2];
                                }
                                else if(stateOne.equals("q3")) {
                                    stateOne = matrix[2][2];
                                }
                                else if(stateOne.equals("q4")) {
                                    stateOne = matrix[3][2];
                                }
                            }

                            readSymbols.add(symbols.get(symbolCounter));
                            currentStates.add(stateOne);

                            if(!stateTwo.equals("")) {
                                //após finalizar o primeiro estado possível o estado principal é substituído pelo secundário que dará continudade
                                readSymbols.add(symbols.get(symbolCounter));
                                currentStates.add(stateTwo);
                                stateOne = stateTwo;
                                stateTwo = "";
                            }
                        }

                        //verificação do estado de aceitação
                        if(stateOne.equals(finalState)) {
                            accept = true;
                        } else {
                            accept = false;
                        }

                        //criando arquivo de resultados
                        Date date = new Date();
                        System.out.println(date.toString());
                        File file = new File("result.txt");

                        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
                            //adicionando informações ao conteúdo do arquivo.
                            content = "Data do arquivo: " + date + "\n";
                            content = "Estado inicial: " + initialState + "\n";
                            for(int i = 0; i < readSymbols.size(); i++) {
                                content = content + "\n";
                                content = content + "Simbolo lido: " + readSymbols.get(i) + "\n";
                                content = content + "Estados correntes: " + currentStates.get(i) + "\n";
                                content = content + "\n";
                            }
                            content = content + "Aceito? " + accept + "\n";

                            writer.write(content);
                            writer.flush();
                        }

                        System.out.println("Arquivo com resultados gerado, verifique na raiz do projeto por: " + file.getName());
                        break;
                    case 2:
                        System.out.println("Nos vemos na próxima, S.V.");
                        break;
                }
            } while(option != 2);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}