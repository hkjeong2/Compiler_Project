package lexicalAnalyzer.DFAmachine;

import lexicalAnalyzer.alphabet.*;

import java.util.ArrayList;

public class bracesMachine extends machine {

    braces braces = new braces();

    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {braces};
    int[][] table = {
            {1},
            {-1},
    };

    public bracesMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        if (super.lexeme.charAt(0) == '{')
            tokenName.add("lbrace");
        else
            tokenName.add("rbrace");
        tokenValue.add(super.lexeme);
    }

}
