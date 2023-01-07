package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class terminatingMachine extends machine {

    terminator terminator = new terminator();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {terminator};
    int[][] table = {
            {1},
            {-1},
    };

    public terminatingMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        tokenName.add("SEMICOLON");
        tokenValue.add(super.lexeme);
    }

}
