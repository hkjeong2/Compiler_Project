package DFAmachine;

import alphabet.*;
import java.util.ArrayList;

public class parenthesisMachine extends DFAMachine{
    parenthesis parenthesis = new parenthesis();
    empty empty = new empty();

    boolean[] accepted = {false, true, true};
    alphabet[][] table = {
            {empty, parenthesis, parenthesis},
            {empty, empty, empty},
            {empty, empty, empty},
    };

    public parenthesisMachine(){
        super.accepted = accepted;
        super.table = table;
    }

    public void addToken(ArrayList<String> token, ArrayList<String> tokenValue){
        if (super.lexeme.charAt(0) == '{')
            token.add("L_PARENTHESIS");
        else
            token.add("R_PARENTHESIS");
        tokenValue.add(super.lexeme);
    }
}
