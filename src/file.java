import java.io.*;
import java.util.ArrayList;

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

            for (int i = 0; i < tokenName.size(); i++){
                bw.write("tokenName = " + "[" + tokenName.get(i) + "]");
                for (int j = tokenName.get(i).length(); j <= 30 - tokenName.get(i).length(); j++){
                    bw.append(' ');
                }
                bw.append("tokenValue = " + "[").append(tokenValue.get(i)).append("]").append("\n");
            }
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
            bw.write("Starting Symbol : " + symbol + "\n");
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
