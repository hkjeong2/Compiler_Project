package lexicalAnalyzer.DFAmachine;
import lexicalAnalyzer.alphabet.alphabet;
import lexicalAnalyzer.alphabet.digit;
import lexicalAnalyzer.alphabet.letter;

import java.util.ArrayList;

public class identifierMachine extends machine {

    letter letter = new letter();
    digit digit = new digit();
    
    ArrayList<String> tokenName;
    ArrayList<String> tokenValue;

    boolean[] accepted = {false, true, true, true};
    alphabet[] alphabets = {letter, digit};
    int[][] table = {
            {1, -1},
            {2, 3},
            {2, 3},
            {2, 3},
    };

    public identifierMachine(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
        super.accepted = this.accepted;
        super.alphabets = this.alphabets;
        super.table = this.table;
    }

    public void addToken(ArrayList<String> tokenName, ArrayList<String> tokenValue){
        if (super.lexeme.equals("if") || super.lexeme.equals("else") || super.lexeme.equals("while") || super.lexeme.equals("return"))
            tokenName.add(super.lexeme);
        else if (super.lexeme.equals("int") || super.lexeme.equals("char") || super.lexeme.equals("String") )
            tokenName.add("vtype");
        else
            tokenName.add("id");
        tokenValue.add(super.lexeme);
    }

}
