package CourseWork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final String input = getStringFromFile("input.txt");
        System.out.println("Input:");
        System.out.println(input);
        System.out.println("=========== Compilation Begin ============");

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        final List<Token> listOfTokens = lexicalAnalyzer.getListOfTokens(input);
        if (listOfTokens == null) {
            System.out.println("Error: Lexical analysis failed.");
            System.out.println("Error: Compilation failed.");
            return;
        }

        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
        final boolean successfulParse = syntaxAnalyzer.parse(listOfTokens);
        if (!successfulParse) {
            System.out.println("Error: Syntax analysis failed.");
            System.out.println("Error: Compilation failed.");
            return;
        }
        final List<Node> listOfNodes = syntaxAnalyzer.getListOfNodes();
        final Map<String, Type> variablesTable = syntaxAnalyzer.getVariablesTable();

        CodeGenerator codeGenerator = new CodeGenerator(listOfNodes, variablesTable);
        final String output = codeGenerator.generate();

        System.out.println("=========== Compilation End ============");
        System.out.println("Output assembly code:");

        try (FileWriter fileWriter = new FileWriter("output.asm")) {
            fileWriter.write(output);
        } catch (Exception e) {

        }

        System.out.println(output);
    }

    public static String getStringFromFile(String path){
        StringBuilder inputFromFile= new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while(br.ready()){
                inputFromFile.append((char)br.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputFromFile.toString().replaceAll("    ", "\t").replaceAll("\r", "");
    }
}
