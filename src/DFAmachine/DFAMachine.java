package DFAmachine;

import alphabet.alphabet;
import java.util.ArrayList;

public class DFAMachine {
    int row = 0;
    boolean last = false;
    String lexeme = "";
    boolean[] accepted;
    alphabet[][] table;

    public int transit(String input, ArrayList<String> token, ArrayList<String> tokenValue) {
        for (int i = 0; i < input.length(); i++){
            int nextRow = checkTransition(input.charAt(i), row);

            if (i == input.length() - 1 && nextRow != -1){
                row = nextRow;
                nextRow = -1;
                last = true;
            }

            if (nextRow == -1){
                if (accepted[row]){
                    addToken(token, tokenValue);

                    if (last){
                        init();
                        return input.length();
                    }
                    init();
                    return i;
                }
                init();
                return 0;
            }
            else{
                row = nextRow;
            }
        }
        init();
        return 0;
    }

    public int checkTransition(char c, int row){
        for (int col = 0; col < table[row].length; col++){
            if (table[row][col].doesHave(c)){
                lexeme += String.valueOf(c);
                return col;
            }
        }
        return -1;
    }

    public void init(){
        row = 0;
        last = false;
        lexeme = "";
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){}

}
