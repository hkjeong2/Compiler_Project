package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class commaMachine extends machine {
    comma comma = new comma();
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {comma};
    int[][] table = {
            {1},
            {-1},
    };

    public commaMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        tokenName.add("COMMA");
        tokenValue.add(super.lexeme);
    }

}
