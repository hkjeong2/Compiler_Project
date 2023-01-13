package lexicalAnalyzer.DFAmachine;

import lexicalAnalyzer.alphabet.*;
import java.util.ArrayList;

public class parenthesesMachine extends machine {

    parentheses parentheses = new parentheses();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true};
    alphabet[] alphabets = {parentheses};
    int[][] table = {
            {1},
            {-1},
    };

    public parenthesesMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        if (super.lexeme.charAt(0) == '(')
            tokenName.add("lparen");
        else
            tokenName.add("rparen");
        tokenValue.add(super.lexeme);
    }

}
