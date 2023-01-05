package DFAmachine;
import alphabet.alphabet;
import alphabet.digit;
import alphabet.letter;
import alphabet.empty;

import java.util.ArrayList;

public class identifierMachine extends DFAMachine{

    letter letter = new letter();
    digit digit = new digit();
    empty empty = new empty();

    boolean[] accepted = {false, true, true, true};
    alphabet[][] table = {
            {empty, letter, empty, empty},
            {empty, empty, letter, digit},
            {empty, empty, letter, digit},
            {empty, empty, letter, digit},
    };

    public identifierMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        if (super.lexeme.equals("if") || super.lexeme.equals("else") || super.lexeme.equals("while") || super.lexeme.equals("return"))
            token.add(super.lexeme.toUpperCase());
        else if (super.lexeme.equals("int") || super.lexeme.equals("char"))
            token.add("VTYPE");
        else
            token.add("ID");
        tokenValue.add(super.lexeme);
    }

}
