package DFAmachine;

import alphabet.*;

import java.util.ArrayList;

public class bracketMachine extends machine {

    bracket bracket = new bracket();
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {bracket};
    int[][] table = {
            {1},
            {-1},
    };

    public bracketMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        if (super.lexeme.charAt(0) == '(')
            tokenName.add("L_BRACKET");
        else
            tokenName.add("R_BRACKET");
        tokenValue.add(super.lexeme);
    }

}
