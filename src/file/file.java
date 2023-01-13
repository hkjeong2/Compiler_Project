package file;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class file {

    public String readFile(){
        StringBuilder str = new StringBuilder();
        String line = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            while((line = br.readLine()) != null){
                str.append(line);
                str.append("\n");
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        return str.toString();
    }

    public void writeFile(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            bw.write(">>> Lexical Analyzer <<<\n\n");
            bw.write("Lexical Analyzer has successfully created the following symbol table\n\n");

            for (int i = 0; i < tokenName.size(); i++){
                bw.append(tokenName.get(i));
                for (int j = tokenName.get(i).length(); j <= 15; j++){
                    bw.append(' ');
                }
                bw.append(tokenValue.get(i)).append("\n");
            }
            bw.append("\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile(int line, int index, char symbol){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            bw.write("Error : Lexical Analyzer has an unrecognizable token at\n");
            bw.write("Line : " + line + "\n");
            bw.write("Index : " + index + "\n");
            bw.write("Starting symbol : " + symbol + "\n");
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile(int line, int index, String symbol, String tokenValue){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true));

            bw.write("\nError : Syntax Analyzer has an error with a token at\n");
            bw.write("Line : " + line + "\n");
            bw.write("Index : " + index + "\n");
            bw.write("Symbol : " + symbol + "\n");
            bw.write("Token Value : " + tokenValue + "\n");
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile(int step, Stack<Integer> stState, Stack<String> stSymbol){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true));

            bw.write(step + " : ");
            for (int i = 0; i < stState.size(); i++){
                bw.append(String.valueOf(stState.get(i))).append(" ");
                if (!stSymbol.empty() && i < stSymbol.size())
                    bw.append(stSymbol.get(i)).append(" ");
            }
            bw.append("\n");
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile(String[] str){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true));

            for (String s : str) {
                bw.write(s);
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
